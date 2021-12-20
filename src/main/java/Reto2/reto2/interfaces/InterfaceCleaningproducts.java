/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2.reto2.interfaces;

import Reto2.reto2.modelo.Cleaningproducts;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;



/**
 *
 * @author stive
 */
public interface InterfaceCleaningproducts extends MongoRepository<Cleaningproducts, String> {
    public List<Cleaningproducts> findByPrice(double price);
    public List<Cleaningproducts> findByDescriptionContainingIgnoreCase(String description);
}
