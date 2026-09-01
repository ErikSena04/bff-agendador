package com.eriksena.bffagendador.business.service;

import com.eriksena.bffagendador.business.dtos.request.LoginDTORequest;
import com.eriksena.bffagendador.business.dtos.response.TarefasDTOResponse;
import com.eriksena.bffagendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void BuscaTarefasProximaHora(){
        String token = login(converterParaDTORequest());
        log.info("Busca de tarefas iniciada com sucesso");
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);
        List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendandorPorPeriodo(
                horaFutura, horaFuturaMaisCinco, token);
        log.info("Tarefas encontradas " + listaTarefas);
        listaTarefas.forEach(tarefas -> {emailService.enviaEmail(tarefas);
            log.info("Email enviado com sucesso para " + tarefas.getEmailUsuario());
            tarefasService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefas.getId(), token);});
        log.info("Finalizada a busca e notificação de tarefas");
    }

    public String login(LoginDTORequest loginDTORequest){
        return usuarioService.loginUsuario(loginDTORequest);
    }

    public LoginDTORequest converterParaDTORequest(){
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
