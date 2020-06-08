package br.com.mastertech.pontoeletronicobackendmastertech.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;
import lombok.Getter;

/**
 * UsuarioDto
 */
public class UsuarioDto {

  @Getter private Long id;
  @Getter private String nome;
  @Getter private String email;
  @Getter private LocalDateTime dataCadastro;

  public UsuarioDto(Usuario usuario){
    this.id = usuario.getId();
    this.nome = usuario.getNome();
    this.email = usuario.getEmail();
    this.dataCadastro = usuario.getDataCadastro();
  }

  public static List<UsuarioDto> convertList(List<Usuario> usuarios) {
    return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
  }
}