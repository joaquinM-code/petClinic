package com.ecatom.sfpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends BaseEntity {

    @Column(name = "first_name")//Specifies the column name on the DB(By default converts camel to snake-case)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    

}
