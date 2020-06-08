package br.com.mastertech.pontoeletronicobackendmastertech.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;
import br.com.mastertech.pontoeletronicobackendmastertech.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

public class UsuarioForm {

  @NotNull @NotBlank
  @Getter @Setter private String nome;
  
  @Email  @NotNull @NotBlank
  @Getter @Setter private String email;

  @NotNull @NotBlank
  @Getter @Setter private String senha;

  public Usuario converter() {
    return new Usuario(nome, email, senha);
  }

  public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
    Usuario usuario = usuarioRepository.getOne(id);
    usuario.setNome(this.nome);
    usuario.setEmail(this.email);
    usuario.setSenha(this.senha);
    return usuario;
  }

}
