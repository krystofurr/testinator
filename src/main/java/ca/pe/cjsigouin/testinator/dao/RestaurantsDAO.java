/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.dao;

import ca.pe.cjsigouin.testinator.model.Restaurants;
import org.springframework.stereotype.Repository;

/**
 *
 * @author krystofurr
 */
@Repository("restaurantsDao")
public class RestaurantsDAO extends BaseDAO<Restaurants> implements IRestaurantsDAO{

    public RestaurantsDAO() {
        setClazz(Restaurants.class);
    }

}
