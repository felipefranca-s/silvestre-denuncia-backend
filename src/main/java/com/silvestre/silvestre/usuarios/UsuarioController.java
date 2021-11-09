package com.silvestre.silvestre.usuarios;

import java.util.List;
import java.util.Optional;

import com.silvestre.silvestre.usuarios.Usuario;
import com.silvestre.silvestre.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/retornaTodos")
    List<Usuario> todosUsuarios(){
        return repository.findAll();
    }

    @PostMapping("/novo")
    Usuario novoUsuario(@RequestBody Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    @GetMapping("/{id}")
    Optional<Usuario> retornaUsuario(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Usuario atualizaUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {

        usuario.setId(id);
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    @DeleteMapping("/deleta/{id}")
    void deletaUsuario(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean>
    validarSenha(@RequestParam String login, @RequestParam String senha){

        Optional<Usuario> optionalUsuario = repository.findByLogin(login);
        if(optionalUsuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optionalUsuario.get();

        boolean valido = encoder.matches(senha, usuario.getSenha());

        HttpStatus status = (valido) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valido);
    }
}