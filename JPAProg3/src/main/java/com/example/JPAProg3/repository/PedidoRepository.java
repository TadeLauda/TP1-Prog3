package com.example.JPAProg3.repository;

import com.example.JPAProg3.entities.Cliente;
import com.example.JPAProg3.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
