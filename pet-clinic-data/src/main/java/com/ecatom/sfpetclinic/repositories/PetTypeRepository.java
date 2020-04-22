package com.ecatom.sfpetclinic.repositories;

import com.ecatom.sfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType , Long> {
}
