package es.daw.springpurchasesapirest.controllers;

import es.daw.springpurchasesapirest.dtos.PurchaseDTO;
import es.daw.springpurchasesapirest.services.PurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

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
