/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.dao;

import ca.pe.cjsigouin.testinator.exception.BaseDAOException;
import ca.pe.cjsigouin.testinator.model.BaseModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author krystofurr
 * @param <M>
 * 
 * REF: http://www.baeldung.com/spring-dao-jpa
 */
@Repository("baseDao")
public @Getter @Setter @ToString class BaseDAO<M extends BaseModel<Integer>> implements IBaseDAO<M> {
 
    private static final Logger log = LoggerFactory.getLogger(BaseDAO.class);

    private Class< M > clazz;
 
    @PersistenceContext
    EntityManager entityManager;
 
    public final void setClazz( Class< M > clazzToSet ){
        this.clazz = clazzToSet;
    }

    @Override
    public M findById( Integer id ) throws BaseDAOException {
        M model;
        try {
           model = entityManager.find( clazz, id );
        } catch( Exception ex) {
           ex.printStackTrace();
           throw new BaseDAOException();
        }
        return model;
    }

   @Override
   public List<M> findAll() throws BaseDAOException{
        List<M> models;
        try {
            models = entityManager.createQuery( "from " + clazz.getName() ).getResultList();
        } catch( Exception ex) {
            ex.printStackTrace();
            throw new BaseDAOException();
        }
        return models;
   }

   @Override
   public void create( M entity ) throws BaseDAOException{
        try {
            entityManager.persist( entity );
            log.info(entity.toString());
        } catch( Exception ex ) {
            ex.printStackTrace();
            throw new BaseDAOException();
        }
        
   }

   @Override
   public M update( M entity ) throws BaseDAOException{
        try {

        } catch( Exception ex ) {
            ex.printStackTrace();
            throw new BaseDAOException();
        }
        return entityManager.merge( entity );
   }
 
   @Override
   public void delete( M entity ) throws BaseDAOException{
        try {

        } catch( Exception ex ) {
            ex.printStackTrace();
            throw new BaseDAOException();
        }
      entityManager.remove( entity );
   }

   @Override
   public void deleteById( Integer entityId ) throws BaseDAOException{
        try {

        } catch( Exception ex ) {
            ex.printStackTrace();
            throw new BaseDAOException();
        }
      M entity = findById( entityId );
      delete( entity );
   } 
}
