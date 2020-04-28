package com.ecatom.sfpetclinic.services.springdatajpa;

import com.ecatom.sfpetclinic.model.Owner;
import com.ecatom.sfpetclinic.repositories.OwnerRepository;
import com.ecatom.sfpetclinic.repositories.PetRepository;
import com.ecatom.sfpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String OWNER_LASTNAME = "TestSubject";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner testOwner;

    @BeforeEach
    void setUp() {
        testOwner = Owner.builder().id(1L).lastName(OWNER_LASTNAME).build();
    }

    @Test
    void findByLastName() {

        //Mock setup
        when(ownerRepository.findByLastName(any())).thenReturn(testOwner);

        //Test
        Owner foundOwner = service.findByLastName(OWNER_LASTNAME);
        assertEquals(OWNER_LASTNAME , foundOwner.getLastName());

        //Verify call to mock
        verify(ownerRepository).findByLastName(any());


    }

    @Test
    void findAll() {
        //Data Set Mock
        Set<Owner> foundOwners = new HashSet<>();
        foundOwners.add(testOwner);
        foundOwners.add(Owner.builder().id(3L).lastName("owner2").build());
        when(ownerRepository.findAll()).thenReturn(foundOwners);

        //Test
        Set<Owner> owners = service.findAll();
        assertEquals(2,owners.size());
        assertNotNull(owners);

    }

    @Test
    void findById() {
        //Mock setup
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(testOwner));

        //Test
        Owner owner = service.findById(1L);
        assertEquals(OWNER_LASTNAME , owner.getLastName());
    }

    @Test
    void save() {
        //Test setup
        Owner ownerToSave = Owner.builder().id(1L).lastName("saved").build();

        //Mock setup
        when(ownerRepository.save(any())).thenReturn(testOwner);
        //Test
        Owner owner = service.save(ownerToSave);
        assertNotNull(owner);
    }

    @Test
    void delete() {
        service.delete(testOwner);
        //We use verify instead of assert, because the method is void
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(testOwner.getId());
        verify(ownerRepository).deleteById(anyLong());
    }
}