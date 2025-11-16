package es.daw.springpurchasesapirest.mappers;

import es.daw.springpurchasesapirest.dtos.PurchaseDTO;
import es.daw.springpurchasesapirest.entities.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {


    PurchaseDTO toPurchaseDTO(Purchase purchase);

    @Mapping(target = "products", ignore = true)
    Purchase toPurchaseEntity(PurchaseDTO purchaseDTO);

    List<PurchaseDTO> toPurchaseDTOList(List<Purchase> purchases);
}
