package br.com.mastertech.pontoeletronicobackendmastertech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mastertech.pontoeletronicobackendmastertech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

} 