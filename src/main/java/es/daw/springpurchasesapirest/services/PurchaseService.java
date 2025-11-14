package es.daw.springpurchasesapirest.services;

import es.daw.springpurchasesapirest.dtos.PurchaseDTO;
import es.daw.springpurchasesapirest.entities.Purchase;
import es.daw.springpurchasesapirest.mappers.PurchaseMapper;
import es.daw.springpurchasesapirest.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;


    public Optional<List<PurchaseDTO>> findAll() {
        List<Purchase> purchasesEntities = purchaseRepository.findAll();
        return Optional.ofNullable(purchaseMapper.toPurchaseDTOList(purchasesEntities));
    }


}
