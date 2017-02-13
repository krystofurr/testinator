/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




/**
 *
 * @author krystofurr
 */
@Entity
@Table(name="restaurants")
public @Getter @Setter @ToString(callSuper=true, includeFieldNames=true)
    class Restaurants 
        extends BaseModel<Integer> {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column (name="restname")
    private String restName;
    
    @Column (name="cityname")
    private String cityName; 
}

    
