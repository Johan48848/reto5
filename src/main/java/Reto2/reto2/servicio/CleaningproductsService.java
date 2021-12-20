/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2.reto2.servicio;

import Reto2.reto2.modelo.Cleaningproducts;
import Reto2.reto2.repositorio.CleaningproductsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stive
 */
@Service
public class CleaningproductsService {
  @Autowired
    private CleaningproductsRepositorio clotheRepository;

    public List<Cleaningproducts> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Cleaningproducts> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Cleaningproducts create(Cleaningproducts accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Cleaningproducts update(Cleaningproducts accesory) {

        if (accesory.getReference() != null) {
            Optional<Cleaningproducts> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
    
    public List<Cleaningproducts> getByPrice(double price){
        return clotheRepository.getByPrice(price);
    }
    
     public List<Cleaningproducts> getByDescriptionContains(String description){
        return clotheRepository.getByDescriptionContains(description);
    }
}
