/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.pe.cjsigouin.testinator.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
public @Getter @Setter @ToString abstract class BaseModel<ID extends Serializable> {

    public abstract ID getId();

    public abstract void setId(ID id);

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
                return false;

        if (obj instanceof BaseModel<?>) {
                return ((BaseModel<?>) obj).getId().equals(getId());
        } else
                return super.equals(obj);
    }
}
