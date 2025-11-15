package es.daw.springpurchasesapirest.controllers;

import es.daw.springpurchasesapirest.dtos.PurchaseDTO;
import es.daw.springpurchasesapirest.services.PurchaseService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
@Validated

public class PurchaseController {

    private final PurchaseService purchaseService;



    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> findAll() {
        return ResponseEntity.of(purchaseService.findAll());
    }

}
