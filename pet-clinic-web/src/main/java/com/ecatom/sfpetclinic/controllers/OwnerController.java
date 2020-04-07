package com.ecatom.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Little trick to map the whole class to /owners
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"/" , "" , "/index" , "/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}
