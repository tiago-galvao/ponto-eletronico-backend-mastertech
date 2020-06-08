package br.com.mastertech.pontoeletronicobackendmastertech.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mastertech.pontoeletronicobackendmastertech.model.PontoEletronico;
import br.com.mastertech.pontoeletronicobackendmastertech.model.StatusBatidaPonto;
import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;
import lombok.Getter;

public class PontoEletronicoDto {
  
  @Getter private Long id;
  @Getter private StatusBatidaPonto statusBatidaPonto;
  @Getter private LocalDateTime dataBatidaPonto;
  @Getter private Usuario usuario;

  public PontoEletronicoDto(PontoEletronico pontoEletronico){
    this.id = pontoEletronico.getId();
    this.statusBatidaPonto = pontoEletronico.getStatus();
    this.dataBatidaPonto = pontoEletronico.getDataBatidaPonto();
    this.usuario = pontoEletronico.getUsuario();
  }
  public static List<PontoEletronicoDto> convertList(List<PontoEletronico> pontosEletronicos) {
    return pontosEletronicos.stream().map(PontoEletronicoDto::new).collect(Collectors.toList());
  }
}