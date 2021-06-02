package br.com.orangetalents.controledeveiculos.usuario.repository;

import br.com.orangetalents.controledeveiculos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
