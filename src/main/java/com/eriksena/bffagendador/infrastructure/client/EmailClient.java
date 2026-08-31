package com.eriksena.bffagendador.infrastructure.client;

import com.eriksena.bffagendador.business.dtos.request.TarefasDTORequest;
import com.eriksena.bffagendador.business.dtos.response.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    void enviarEmail(@RequestBody TarefasDTOResponse tarefaDTO);
}

