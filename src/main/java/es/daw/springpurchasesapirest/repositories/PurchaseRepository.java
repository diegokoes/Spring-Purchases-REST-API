package es.daw.springpurchasesapirest.repositories;

import es.daw.springpurchasesapirest.dtos.PurchaseDTO;
import es.daw.springpurchasesapirest.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {


    Optional<PurchaseDTO> findByTotal(double total);
}



    