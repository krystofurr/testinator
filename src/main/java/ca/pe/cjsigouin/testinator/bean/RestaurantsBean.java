/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author krystofurr
 */
public @Getter @Setter @ToString(callSuper=true, includeFieldNames=true)
    class RestaurantsBean 
        extends BaseBean {
    
    private String restName;
    private String cityName; 

}
