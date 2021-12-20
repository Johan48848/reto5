package Reto2.reto2;

import Reto2.reto2.interfaces.InterfaceCleaningproducts;
import Reto2.reto2.interfaces.InterfaceOrder;
import Reto2.reto2.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner{
    @Autowired
    private InterfaceCleaningproducts interfaceCleaningproducts;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder orderInterface;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}
         @Override
    public void run(String... args) throws Exception {
        interfaceCleaningproducts.deleteAll();
        interfaceUser.deleteAll();
        orderInterface.deleteAll();
    }
        
}
