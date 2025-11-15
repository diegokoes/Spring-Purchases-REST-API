package es.daw.springpurchasesapirest.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "La constraseña es obligatoria")
    private String password;
    //private String email;

    // PENDIENTE!!! y si queremos indicar varios roles?????
    private String role; // opcional. Rol del usuario nuevo...

    //private List<String> roles = new ArrayList<>();

//    {
//        "username": "pepito",
//        "password": "1234",
//        "roles": ["ADMIN","editor","ROLE_USER"]
//    }


}