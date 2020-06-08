package br.com.mastertech.pontoeletronicobackendmastertech.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;
import br.com.mastertech.pontoeletronicobackendmastertech.repository.UsuarioRepository;
import br.com.mastertech.pontoeletronicobackendmastertech.controller.dto.UsuarioDto;
import br.com.mastertech.pontoeletronicobackendmastertech.controller.form.UsuarioForm;

/**
 * UsuarioController
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping
  public List<UsuarioDto> listar() {
    List<Usuario> usuarios = usuarioRepository.findAll();
    return UsuarioDto.convertList(usuarios);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
    Usuario usuario = form.converter();
    usuarioRepository.save(usuario);
    URI location = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
    
    return ResponseEntity.created(location).body(new UsuarioDto(usuario));
  } 

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDto> buscar(@PathVariable Long id) {
    Optional<Usuario> optional = usuarioRepository.findById(id);
    if(optional.isPresent()){
      return ResponseEntity.ok(new UsuarioDto(optional.get()));
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioForm form){
    Optional<Usuario> optional = usuarioRepository.findById(id);
    if(optional.isPresent()){
      Usuario usuario = form.atualizar(id, usuarioRepository);
      return ResponseEntity.ok(new UsuarioDto(usuario));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("{id}")
  @Transactional
  public ResponseEntity<?> remover(@PathVariable Long id){

    Optional<Usuario> optional = usuarioRepository.findById(id);
    if(optional.isPresent()){
      usuarioRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

}