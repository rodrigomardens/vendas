package br.com.marden.vendas.domain.repository;

import br.com.marden.vendas.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Usuarios extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);

}
