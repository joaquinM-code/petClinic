package com.ecatom.sfpetclinic.bootstrap;

import com.ecatom.sfpetclinic.model.Owner;
import com.ecatom.sfpetclinic.model.Vet;
import com.ecatom.sfpetclinic.services.OwnerService;
import com.ecatom.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component//By declaring it as a component, becomes a Spring bean and gets registered into the context
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    //Spring IoC Container will implement the methods
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    //When the app is completely up everything inside this method will run
    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mike");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Laura");
        owner2.setLastName("O'Brian");

        ownerService.save(owner2);

        System.out.println("Loaded owners.........");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("John");
        vet1.setLastName("Charleston");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sandra");
        vet2.setLastName("Redstone");

        vetService.save(vet2);

        System.out.println("Loaded vets.........");


    }
}
