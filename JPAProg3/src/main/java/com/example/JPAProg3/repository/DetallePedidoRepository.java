package com.example.JPAProg3.repository;

import com.example.JPAProg3.entities.Cliente;
import com.example.JPAProg3.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
