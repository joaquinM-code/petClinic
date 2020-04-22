package com.ecatom.sfpetclinic.repositories;

import com.ecatom.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
