package tn.esprit.spring.controller;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.services.ReclamationService;

@RequestMapping("Reclamation/")
@RestController
public class ReclamationController {
    @Autowired
    ReclamationService avServ;

    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation b) {
    	return avServ.addReclamation(b);
    }

    @DeleteMapping("/deleteReclamation/{id}")
    public String deletReclamation(@PathVariable String id) {
    	
       return avServ.deleteReclamation(Integer.parseInt(id));
    }

    @PutMapping("/updateReclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation b) {
        return avServ.updateidReclamation(b);
    }

    @GetMapping("/getReclamationList")
    public ArrayList<Object> getReclamationList() {
        return (ArrayList<Object>) avServ.retrieveAllReclamation();
    }

 
    @GetMapping("/getReclamation/{id}")
    public Reclamation getReclamationbyId(@PathVariable int id) {
        return avServ.retrieveidReclamation(id);
    }
/*
    @GetMapping("/getQuantity/{id}")
    public int getQuantity(@PathVariable int id) {
        return avServ.getQuantity(id);
    }*/

}