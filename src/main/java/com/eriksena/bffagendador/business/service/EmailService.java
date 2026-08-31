package com.eriksena.bffagendador.business.service;

import com.eriksena.bffagendador.business.dtos.request.TarefasDTORequest;
import com.eriksena.bffagendador.business.dtos.response.TarefasDTOResponse;
import com.eriksena.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse tarefasDTO) {
        emailClient.enviarEmail(tarefasDTO);
    }


}
