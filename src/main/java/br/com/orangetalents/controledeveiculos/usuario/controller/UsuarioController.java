package br.com.orangetalents.controledeveiculos.usuario.controller;

import br.com.orangetalents.controledeveiculos.usuario.controller.request.UsuarioRequest;
import br.com.orangetalents.controledeveiculos.usuario.model.Usuario;
import br.com.orangetalents.controledeveiculos.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastra(@RequestBody @Valid UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioRequest.converter();
        usuarioRepository.save(usuario);

        URI uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
}