package com.ecatom.sfpetclinic.services;

import com.ecatom.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner , Long>{

    Owner findByLastName(String lastName);
}
