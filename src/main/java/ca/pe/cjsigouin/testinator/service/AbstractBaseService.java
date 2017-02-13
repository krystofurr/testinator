/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.service;

import ca.pe.cjsigouin.testinator.bean.BaseBean;
import ca.pe.cjsigouin.testinator.dao.IBaseDAO;
import ca.pe.cjsigouin.testinator.exception.BaseDAOException;
import ca.pe.cjsigouin.testinator.exception.BaseServiceException;
import ca.pe.cjsigouin.testinator.exception.BeanCopyException;
import ca.pe.cjsigouin.testinator.model.BaseModel;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author krystofurr
 * @param <B>
 * @param <M>
 */
@Service("baseService")
@Transactional
public abstract class AbstractBaseService<B extends BaseBean, M extends BaseModel<Integer>> 
    implements IBaseService<B, M> {

    // Snippet pulled from https://developer.jboss.org/wiki/GenericDataAccessObjects - An implementation with Hibernate
    @SuppressWarnings("unchecked")
    protected Class<B> beanClass = (Class<B>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    @SuppressWarnings("unchecked")
    protected Class<M> modelClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    protected abstract void copyModelToBean(M model, B bean) throws BeanCopyException;
    protected abstract void copyBeanToModel(B bean, M model) throws BeanCopyException;
    protected abstract IBaseDAO getDAO();
    
    @Override
    public B convertModelToBean(M model, B bean) throws BaseServiceException {
        try {
            if (bean == null)
                    bean = beanClass.newInstance();

            copyModelToBean(model, bean);
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            throw new BaseServiceException();
        } catch (BeanCopyException ex) {
            ex.printStackTrace();
            throw new BaseServiceException();
        }
        return bean;
    }
    
    @Override
    public M convertBeanToModel(B bean, M model) throws BaseServiceException {
        try {
            if (bean == null)
                    bean = beanClass.newInstance();

            copyBeanToModel(bean, model);
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            throw new BaseServiceException();
        } catch (BeanCopyException ex) {
            ex.printStackTrace();
            throw new BaseServiceException();
        }
        return model;
    }

    @Override
    public B findById(Integer id) throws BaseServiceException {
        B bean = null;
        
        if (id != null) {
            try {
                M model = (M) getDAO().findById(id);
                if(model != null) bean = convertModelToBean(model, bean);
            } catch (BaseDAOException ex) {
                throw new BaseServiceException();
            }
        }
        return bean;
    }

    @Override
    public List<B> findAll() throws BaseServiceException {
        List<B> beans = new ArrayList<>();
        B bean = null;

        try {
            List<M> models = getDAO().findAll();

            for(M model : models) {
                bean = beanClass.newInstance();
                bean = convertModelToBean(model, bean);
                beans.add(bean);
            }
        } catch (Exception ex) {
                ex.printStackTrace();
                throw new BaseServiceException();
        }
        return beans;
    }

    /**
     * 
     * 
     * @param entity
     * @return ID returned has the possibility of being null
     * @throws BaseServiceException 
     */
    @Override
    public Integer create(B entity) throws BaseServiceException {
        Integer id = null;
        
        if (entity != null) {
            try {
                M model;

                model = modelClass.newInstance();

                model = convertBeanToModel(entity, model);
                getDAO().create(model);
                convertModelToBean(model, entity);
                
                id = entity.getId();
            } catch ( Exception ex ) {
                ex.printStackTrace();
                throw new BaseServiceException();
            }
        }
        return id;
    }

    @Override
    public Integer update(B entity) throws BaseServiceException {
        Integer id = null;
        B bean = null;
        
        if (entity != null && entity.getId() != null) {
            try {
                M model = (M) getDAO().findById(entity.getId());
                convertBeanToModel(entity, model);
                model = (M) getDAO().update(model);
                convertModelToBean(model, entity);
                id = entity.getId();
            } catch ( Exception ex ) {
                ex.printStackTrace();
                throw new BaseServiceException();
            }
        }
        return id;
    }

    @Override
    public void deleteById(Integer id) throws BaseServiceException {
        
        if (id != null) {
            try {
                M model = (M) getDAO().findById(id);
                getDAO().delete(model);
            } catch( Exception ex ) {
                ex.printStackTrace();
                throw new BaseServiceException();
            }
        }
    }
}

