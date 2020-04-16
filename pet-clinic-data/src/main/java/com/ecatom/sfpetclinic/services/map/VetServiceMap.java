package com.ecatom.sfpetclinic.services.map;

import com.ecatom.sfpetclinic.model.Vet;
import com.ecatom.sfpetclinic.services.SpecialtyService;
import com.ecatom.sfpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialties() != null){
                object.getSpecialties().forEach(specialty -> {
                    if(specialty.getId() == null){
                        specialtyService.save(specialty);
                    }
                });
                return super.save(object);
            }else{
                throw new RuntimeException("The specialties can not be null");
            }
        }else{
            return null;
        }

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
