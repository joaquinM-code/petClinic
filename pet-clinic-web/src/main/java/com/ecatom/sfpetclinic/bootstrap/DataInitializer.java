package com.ecatom.sfpetclinic.bootstrap;

import com.ecatom.sfpetclinic.model.Owner;
import com.ecatom.sfpetclinic.model.Pet;
import com.ecatom.sfpetclinic.model.PetType;
import com.ecatom.sfpetclinic.model.Vet;
import com.ecatom.sfpetclinic.services.OwnerService;
import com.ecatom.sfpetclinic.services.PetTypeService;
import com.ecatom.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component//By declaring it as a component, becomes a Spring bean and gets registered into the context
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //Spring IoC Container will implement the methods


    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    //When the app is completely up everything inside this method will run
    @Override
    public void run(String... args) throws Exception {

        //PetTypes
        //Results are saved in a variable to be reused latter
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types...........");

        //Owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Weston");
        owner1.setAddress("22 Main street");
        owner1.setCity("London");
        owner1.setPhone("568845466");
        //Pets for owner 1
        Pet mikePet = new Pet();
        mikePet.setName("Barks");
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner1);
        mikePet.setBirthDate(LocalDate.now());
        //Adding pet to the owner1 Set
        owner1.getPets().add(mikePet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Laura");
        owner2.setLastName("O'Brian");
        owner2.setAddress("1 King avenue");
        owner2.setCity("Edinburgh");
        owner2.setPhone("65984523");
        //Adding pets to owner2
        Pet lauraPet = new Pet();
        lauraPet.setName("Kitty");
        lauraPet.setPetType(savedCatPetType);
        lauraPet.setOwner(owner2);
        lauraPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(lauraPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners.........");

        //Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Charleston");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sandra");
        vet2.setLastName("Redstone");

        vetService.save(vet2);

        System.out.println("Loaded vets.........");


    }
}
