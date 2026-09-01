package com.eriksena.bffagendador.business.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginDTORequest {

    private String email;
    private String senha;

}
