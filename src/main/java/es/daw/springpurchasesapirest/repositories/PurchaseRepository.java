package es.daw.springpurchasesapirest.repositories;

import es.daw.springpurchasesapirest.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {


}



    