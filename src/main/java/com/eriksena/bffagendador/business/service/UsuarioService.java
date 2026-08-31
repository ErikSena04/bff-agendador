package com.eriksena.bffagendador.business.service;

import com.eriksena.bffagendador.business.dtos.request.EnderecoDTORequest;
import com.eriksena.bffagendador.business.dtos.request.LoginRequest;
import com.eriksena.bffagendador.business.dtos.request.TelefoneDTORequest;
import com.eriksena.bffagendador.business.dtos.request.UsuarioDTORequest;
import com.eriksena.bffagendador.business.dtos.response.EnderecoDTOResponse;
import com.eriksena.bffagendador.business.dtos.response.TelefoneDTOResponse;
import com.eriksena.bffagendador.business.dtos.response.UsuarioDTOResponse;
import com.eriksena.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequest usuarioDTO){
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest usuarioDTO) {
        return usuarioClient.atualizaDadosUsuario(usuarioDTO, token) ;
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token) {
        return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest enderecoDTO) {
        return usuarioClient.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest telefoneDTO) {
        return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }
}
