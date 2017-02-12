/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.service;

import ca.pe.cjsigouin.testinator.dao.IRestaurantsDAO;
import ca.pe.cjsigouin.testinator.model.Restaurants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author krystofurr
 */
@Service("restaurantsService")
@Transactional
public class RestaurantsService implements IRestaurantsService {

    @Autowired
    IRestaurantsDAO dao;

    @Override
    public void create(Restaurants obj) {
        dao.create(obj);
    }

    @Override
    public List<Restaurants> findAll() {
        return dao.findAll();
    }
}
