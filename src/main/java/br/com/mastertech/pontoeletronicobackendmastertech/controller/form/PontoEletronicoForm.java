package br.com.mastertech.pontoeletronicobackendmastertech.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mastertech.pontoeletronicobackendmastertech.model.PontoEletronico;
import br.com.mastertech.pontoeletronicobackendmastertech.model.StatusBatidaPonto;
import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;
import br.com.mastertech.pontoeletronicobackendmastertech.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

public class PontoEletronicoForm {
  
  @NotNull @NotBlank
  @Getter @Setter private String statusPonto;

  public PontoEletronico cadastrar(Long id, UsuarioRepository usuarioRepository, Usuario usuario) {
    PontoEletronico pontoEletronico = new PontoEletronico();
    pontoEletronico.setUsuario(usuario);

    if("SAIDA".equals(this.statusPonto)){
      pontoEletronico.setStatus(StatusBatidaPonto.SAIDA);
    }else{
      pontoEletronico.setStatus(StatusBatidaPonto.ENTRADA);
    }
    return pontoEletronico;
  }
  
}
