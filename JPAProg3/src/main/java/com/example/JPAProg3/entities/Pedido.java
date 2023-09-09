package com.example.JPAProg3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido implements Serializable {
    public enum EstadoPedido {
        INICIANDO,
        PREPARACION,
        ENTREGADO
    }

    public enum tipoEnvio {
        DELIVERY,
        RETIRA,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    private String horaEstimadaEntrega;

    @Enumerated(EnumType.STRING)
    private tipoEnvio tipoEnvio;

    private Double total;

    @OneToOne (cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "pedido")
    private Factura factura;

    @OneToMany (cascade = CascadeType.MERGE,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "detalle")
    @Builder.Default
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public void agregarDetalle(DetallePedido detallePedido){
        this.detallePedido.add(detallePedido);
    }

    public void agregarDetallePedido(DetallePedido dtp){
        this.detallePedido.add(dtp);
    }

}
