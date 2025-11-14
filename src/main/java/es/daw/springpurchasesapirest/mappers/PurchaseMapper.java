package es.daw.springpurchasesapirest.mappers;

import es.daw.springpurchasesapirest.dtos.PurchaseDTO;
import es.daw.springpurchasesapirest.entities.Purchase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    List<PurchaseDTO> toPurchaseDTOList(List<Purchase> purchases);
}
