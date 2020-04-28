package com.ecatom.sfpetclinic.services.map;

import com.ecatom.sfpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        // Here we mimic dependency injection,
        // normally Spring creates it for us in the app, for testing purposes we have to create it manually
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        //Initialize MapService and add one owner to it
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName("TestSubject").build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void savePassingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNotPassedId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        assertNotNull(savedOwner.getPets());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner ownerLastName = ownerServiceMap.findByLastName("TestSubject");
        assertEquals("TestSubject" , ownerLastName.getLastName());
        assertEquals(ownerId , ownerLastName.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerLastName = ownerServiceMap.findByLastName("NoTestSubject");
        assertNull(ownerLastName);
    }
}