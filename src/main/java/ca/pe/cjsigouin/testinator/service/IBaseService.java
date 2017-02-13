/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.service;

import ca.pe.cjsigouin.testinator.exception.BaseServiceException;
import ca.pe.cjsigouin.testinator.model.BaseModel;
import java.util.List;


/**
 *
 * @author krystofurr
 * @param <B>
 * @param <M>
 */
public interface IBaseService<B, M extends BaseModel<Integer>> {
    public M convertBeanToModel(B bean, M model) throws BaseServiceException;
    public B convertModelToBean(M model, B bean) throws BaseServiceException;
    public B findById( Integer id ) throws BaseServiceException;
    public List< B > findAll() throws BaseServiceException;
    public Integer create( B entity ) throws BaseServiceException;
    public Integer update( B entity ) throws BaseServiceException;
    public void deleteById( Integer entityId ) throws BaseServiceException;
}
