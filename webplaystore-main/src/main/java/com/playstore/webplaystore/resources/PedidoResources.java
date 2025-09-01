package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.Pedido;
import com.playstore.webplaystore.repositories.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoResources {

    private final PedidoRepository repo;

    public PedidoResources(PedidoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Pedido> findAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido p) { return repo.save(p); }
}

