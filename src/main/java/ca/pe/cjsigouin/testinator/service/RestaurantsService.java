/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.service;

import ca.pe.cjsigouin.testinator.bean.RestaurantsBean;
import ca.pe.cjsigouin.testinator.dao.IBaseDAO;
import ca.pe.cjsigouin.testinator.dao.IRestaurantsDAO;
import ca.pe.cjsigouin.testinator.exception.BeanCopyException;
import ca.pe.cjsigouin.testinator.model.Restaurants;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author krystofurr
 */
@Service("restaurantsService")
public class RestaurantsService
    extends AbstractBaseService<RestaurantsBean, Restaurants> 
        implements IRestaurantsService {
    
    @Resource(name = "restaurantsDao")
    IRestaurantsDAO dao;

    @Override
    protected void copyModelToBean(Restaurants model, RestaurantsBean bean) throws BeanCopyException {
        BeanUtils.copyProperties(model, bean);
    }

    @Override
    protected void copyBeanToModel(RestaurantsBean bean, Restaurants model) throws BeanCopyException {
        BeanUtils.copyProperties(bean, model);
    }

    @Override
    protected IBaseDAO getDAO() {
        return dao;
    }

}
