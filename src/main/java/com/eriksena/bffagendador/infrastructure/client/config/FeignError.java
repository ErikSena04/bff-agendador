package com.eriksena.bffagendador.infrastructure.client.config;

import com.eriksena.bffagendador.infrastructure.exceptions.BusinessException;
import com.eriksena.bffagendador.infrastructure.exceptions.ConflictException;
import com.eriksena.bffagendador.infrastructure.exceptions.ResourceNotFoundException;
import com.eriksena.bffagendador.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;


public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch(response.status()){
            case 409:
                return new ConflictException("Erro atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
