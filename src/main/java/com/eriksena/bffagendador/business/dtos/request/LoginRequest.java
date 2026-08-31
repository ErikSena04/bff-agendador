package com.eriksena.bffagendador.business.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginRequest {

    private String email;
    private String senha;

}
