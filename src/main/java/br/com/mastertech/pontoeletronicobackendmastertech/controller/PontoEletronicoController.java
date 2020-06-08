package br.com.mastertech.pontoeletronicobackendmastertech.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import br.com.mastertech.pontoeletronicobackendmastertech.repository.PontoEletronicoRepository;
import br.com.mastertech.pontoeletronicobackendmastertech.repository.UsuarioRepository;
import br.com.mastertech.pontoeletronicobackendmastertech.controller.dto.PontoEletronicoDto;
import br.com.mastertech.pontoeletronicobackendmastertech.controller.form.PontoEletronicoForm;
import br.com.mastertech.pontoeletronicobackendmastertech.model.PontoEletronico;
import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;

@RestController
@RequestMapping("/pontoEletronico")
public class PontoEletronicoController {
 
  @Autowired
  PontoEletronicoRepository pontoEletronicoRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @GetMapping
  public List<PontoEletronicoDto> listar() {
    List<PontoEletronico> pontosEletronicos = pontoEletronicoRepository.findAll();
    return PontoEletronicoDto.convertList(pontosEletronicos);
  }
  
  @PostMapping("/idUsuario/{id}")
  public ResponseEntity<PontoEletronicoDto> cadastrar(@PathVariable Long id, @RequestBody @Valid PontoEletronicoForm form, UriComponentsBuilder uriBuilder){
    Optional<Usuario> optional = usuarioRepository.findById(id);
    if(optional.isPresent()){
      PontoEletronico pontoEletronico = form.cadastrar(id, usuarioRepository, optional.get());
      pontoEletronicoRepository.save(pontoEletronico);
      URI location = uriBuilder.path("/pontoEletronico/{id}").buildAndExpand(pontoEletronico.getId()).toUri();
      return ResponseEntity.created(location).body(new PontoEletronicoDto(pontoEletronico));
    }
    return ResponseEntity.notFound().build();
  }

}