/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2.reto2.repositorio;

import Reto2.reto2.interfaces.InterfaceCleaningproducts;
import Reto2.reto2.modelo.Cleaningproducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stive
 */
@Repository
public class CleaningproductsRepositorio {
    @Autowired
    private InterfaceCleaningproducts repository;

    public List<Cleaningproducts> getAll() {
        return repository.findAll();
    }

    public Optional<Cleaningproducts> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Cleaningproducts create(Cleaningproducts clothe) {
        return repository.save(clothe);
    }

    public void update(Cleaningproducts clothe) {
        repository.save(clothe);
    }
    
    public void delete(Cleaningproducts clothe) {
        repository.delete(clothe);
    }
    
    public List<Cleaningproducts> getByPrice(double price){
        return repository.findByPrice(price);
    }
    
     public List<Cleaningproducts> getByDescriptionContains(String description){
        return repository.findByDescriptionContainingIgnoreCase(description);
    }
}
