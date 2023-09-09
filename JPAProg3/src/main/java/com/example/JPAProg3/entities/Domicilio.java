package com.example.JPAProg3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "domicilio")
    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_pedido")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedidoDomicilio(Pedido pedido){
        this.pedidos.add(pedido);
    }


    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_cliente")
    private Cliente cliente;

    public void agregarPedidos(Pedido pedidos){
        this.pedidos.add(pedidos);
    }

}
