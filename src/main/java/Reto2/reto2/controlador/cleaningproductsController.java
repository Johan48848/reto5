/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2.reto2.controlador;

import Reto2.reto2.modelo.Cleaningproducts;
import Reto2.reto2.servicio.CleaningproductsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stive
 */
@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin("*")
public class cleaningproductsController {
     @Autowired
    private CleaningproductsService accessoryService;
      
     @GetMapping("/all")
    public List<Cleaningproducts> getAll() {
        return accessoryService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Cleaningproducts> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningproducts create(@RequestBody Cleaningproducts gadget) {
        return accessoryService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningproducts update(@RequestBody Cleaningproducts gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    } 
    
    @GetMapping("/price/{price}")
    public List<Cleaningproducts> getByPrice(@PathVariable("price") double price){
        return accessoryService.getByPrice(price);
    }
    
     @GetMapping("/description/{description}")
    public List<Cleaningproducts> getByDescriptionContains(@PathVariable("description") String description){
        return accessoryService.getByDescriptionContains(description);
    }
}
