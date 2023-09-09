package com.example.JPAProg3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.MERGE,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedidoCliente(Pedido pedido){
        this.pedidos.add(pedido);
    }

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}
