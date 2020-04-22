package com.ecatom.sfpetclinic.repositories;

import com.ecatom.sfpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit , Long> {
}
