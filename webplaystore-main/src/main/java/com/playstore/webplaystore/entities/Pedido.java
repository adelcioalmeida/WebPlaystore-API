package com.playstore.webplaystore.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataCompra;
    private String statusDaCompra;

    public Pedido() {
    }

    public Pedido(Long id, Date dataCompra, String statusDaCompra) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.statusDaCompra = statusDaCompra;
    }

    public Long getId() {
        return id;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getStatusDaCompra() {
        return statusDaCompra;
    }

    public void setStatusDaCompra(String statusDaCompra) {
        this.statusDaCompra = statusDaCompra;
    }

    // Método extra para calcular o total da compra
    public Double totalDaCompra(List<Product> prodList) {
        double soma = 0.0;
        for (Product p : prodList) {
            soma += p.getPreco();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
