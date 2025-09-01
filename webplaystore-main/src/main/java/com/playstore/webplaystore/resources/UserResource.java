package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.User;
import com.playstore.webplaystore.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // rota: /users
public class UserResource {

    private final UserRepository repo;

    // injeção pelo construtor (pode usar @Autowired no campo se preferir)
    public UserResource(UserRepository repo) {
        this.repo = repo;
    }

    // GET /users  -> lista todos (busca no banco via JPA)
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = repo.findAll();
        return ResponseEntity.ok(list);
    }

    // GET /users/{id} -> busca por id
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /users -> cria um usuário (manda JSON no corpo)
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User u) {
        User saved = repo.save(u);
        return ResponseEntity.ok(saved);
    }
}
