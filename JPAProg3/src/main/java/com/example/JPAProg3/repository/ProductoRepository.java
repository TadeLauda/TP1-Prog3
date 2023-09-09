package com.example.JPAProg3.repository;

import com.example.JPAProg3.entities.Cliente;
import com.example.JPAProg3.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
