package br.com.mastertech.pontoeletronicobackendmastertech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mastertech.pontoeletronicobackendmastertech.model.PontoEletronico;

public interface PontoEletronicoRepository extends JpaRepository<PontoEletronico, Long>{
  
}