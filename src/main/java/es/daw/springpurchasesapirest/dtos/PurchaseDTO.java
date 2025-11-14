package es.daw.springpurchasesapirest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @NotBlank(message = "customer name is obligatory")
    @Size(min = 3, max = 20, message = "customer name between three and " +
            "twenty characters")
    private String customer;
    private LocalDateTime date;
    @DecimalMin(value = "400", message ="Minimum price is 400" )
    private double total;


}
