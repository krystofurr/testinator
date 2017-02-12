/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.dao;

import ca.pe.cjsigouin.testinator.model.Restaurants;
import java.util.List;

/**
 *
 * @author krystofurr
 */
public interface IRestaurantsDAO {
    Restaurants findById(long id);

    List<Restaurants> findAll();

    void create(Restaurants entity);

    Restaurants update(Restaurants entity);

    void delete(Restaurants entity);

    void deleteById(long entityId);
}
