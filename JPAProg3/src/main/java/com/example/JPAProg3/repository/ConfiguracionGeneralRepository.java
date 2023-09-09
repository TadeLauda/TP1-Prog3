package com.example.JPAProg3.repository;

import com.example.JPAProg3.entities.Cliente;
import com.example.JPAProg3.entities.ConfiguracionGeneral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracionGeneralRepository extends JpaRepository<ConfiguracionGeneral, Long> {
}
