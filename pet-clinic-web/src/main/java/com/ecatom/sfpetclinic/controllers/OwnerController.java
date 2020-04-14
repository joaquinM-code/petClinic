package com.ecatom.sfpetclinic.controllers;

import com.ecatom.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Little trick to map the whole class to /owners
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    //Constructor injection from SF5 don't need to call @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/" , "" , "/index" , "/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners" , ownerService.findAll());
        return "owners/index";
    }
}
