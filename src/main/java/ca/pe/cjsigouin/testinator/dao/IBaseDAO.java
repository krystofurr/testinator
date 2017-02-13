/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.dao;

import ca.pe.cjsigouin.testinator.exception.BaseDAOException;
import ca.pe.cjsigouin.testinator.model.BaseModel;
import java.util.List;

/**
 *
 * @author krystofurr
 * @param <M>
 */
public interface IBaseDAO<M extends BaseModel<Integer>> {
    public M findById( Integer id ) throws BaseDAOException;
    public List< M > findAll() throws BaseDAOException;
    public void create( M entity ) throws BaseDAOException;
    public M update( M entity ) throws BaseDAOException;
    public void delete( M entity ) throws BaseDAOException;
    public void deleteById( Integer entityId ) throws BaseDAOException;
}
