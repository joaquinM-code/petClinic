package com.ecatom.sfpetclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="owners")//Renames the table
public class Owner extends Person {

    private String address;
    private String city;
    private String phone;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "owner")//Specifies that if I delete owner the pets will also be deleted
    private Set<Pet> pets = new HashSet<>();

    @Builder//See bootstrap init for more info
    public Owner(Long id, String firstName, String lastName , String address , String city , String phone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
    }
}
