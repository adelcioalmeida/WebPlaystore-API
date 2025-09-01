package com.playstore.webplaystore.repositories;

import com.playstore.webplaystore.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}