package com.darkross.adminsecurityservice.dto.request;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;
}
