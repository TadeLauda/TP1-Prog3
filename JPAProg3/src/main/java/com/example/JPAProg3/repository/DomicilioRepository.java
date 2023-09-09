package com.example.JPAProg3.repository;

import com.example.JPAProg3.entities.Cliente;
import com.example.JPAProg3.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
