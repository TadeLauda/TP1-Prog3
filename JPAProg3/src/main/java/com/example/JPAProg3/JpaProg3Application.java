package com.example.JPAProg3;

import com.example.JPAProg3.entities.*;
import com.example.JPAProg3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaProg3Application {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ConfiguracionGeneralRepository configuracionGeneralRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaProg3Application.class, args);
		System.out.println("Funcionando");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, ConfiguracionGeneralRepository configuracionGeneralRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, RubroRepository rubroRepository, UsuarioRepository usuarioRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO-------------");

// El método builder() se genera automáticamente por Lombok y te permite crear una instancia de Persona.Builder.
// Luego, puedes encadenar llamadas a los métodos setters generados automáticamente para establecer los valores de los atributos de la clase.
// Finalmente, build() crea la instancia de la clase Persona con los valores proporcionados.

			// Crear instancia de Cliente1
			Cliente c1 = Cliente.builder()
					.nombre("Juan")
					.apellido("Perez")
					.telefono("2616172678")
					.email("juanPerez1995@email.com")
					.build();
			clienteRepository.save(c1);

			// Crear instancia de Cliente2
			Cliente c2 = Cliente.builder()
					.nombre("Matias")
					.apellido("Dominguez")
					.telefono("2612239366")
					.email("Mati.Dominguez@email.com")
					.build();
			clienteRepository.save(c2);


			Cliente c3 = C

			// Crea instancia de Domicilio1
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Belgrano")
					.numero("1702")
					.localidad("Dorrego")
					.cliente(c1)
					.build();
			domicilioRepository.save(domicilio1);

			// Crea instancia de Domicilio2
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Los Tordos")
					.numero("4550")
					.localidad("Guaymallen")
					.cliente(c2)
					.build();
			domicilioRepository.save(domicilio2);

			// Crea instancia de Domicilio3
			Domicilio domicilio3 = Domicilio.builder()
					.calle("Dalvian")
					.numero("2351")
					.localidad("Las Heras")
					.cliente(c1)
					.build();
			domicilioRepository.save(domicilio3);

			// Crear instancia de Usuario1
			Usuario user1 = Usuario.builder()
					.nombre("Juampi")
					.password("123456")
					.rol("Cliente")
					.build();
			usuarioRepository.save(user1);

			// Crear instancia de Usuario2
			Usuario user2 = Usuario.builder()
					.nombre("Mati")
					.password("25314")
					.rol("Cliente")
					.build();
			usuarioRepository.save(user2);

			//Crear instancia de la Configuracion General
			ConfiguracionGeneral conf1 = ConfiguracionGeneral.builder()
					.cantidadCocineros(6)
					.emailEmpresa("El.Buen.Sabor@email.com")
					.tokenMercadoPago("buenos.sabores.2023")
					.build();
			configuracionGeneralRepository.save(conf1);

			// Creando una instancia de Producto1
			Producto p1 = Producto.builder()
					.tipo(Producto.tipoP.MANUFACTURADO)
					.tiempoEstimadoCocina(4)
					.denominacion("Doble Cheddar")
					.precioVenta(1399.99)
					.precioCompra(669.38)
					.stockActual(110)
					.stockMinimo(25)
					.unidadMedida("Unidad")
					.receta("Carne de hamburguesa x2, Pan, Queso Cheddar, Lechuga, Tomate, Cebolla")
					.foto("imagen.png")
					.build();
			productoRepository.save(p1);

			// Creando una instancia de Producto2
			Producto p2 = Producto.builder()
					.tipo(Producto.tipoP.MANUFACTURADO)
					.tiempoEstimadoCocina(6)
					.denominacion("Monstruosa")
					.precioVenta(1720.0)
					.precioCompra(967.21)
					.stockActual(97)
					.stockMinimo(32)
					.unidadMedida("Unidad")
					.receta("Carne de hamburguesa x4, Pan, Salsa cheddar, Lechuga, Tomate, Cebolla, Wakamole, Aji molido")
					.foto("imagen2.png")
					.build();
			productoRepository.save(p2);

			// Creando una instancia de Producto3
			Producto p3 = Producto.builder()
					.tipo(Producto.tipoP.INSUMO)
					.tiempoEstimadoCocina(7)
					.denominacion("Especial de la Casa")
					.precioVenta(1541.42)
					.precioCompra(768.91)
					.stockActual(39)
					.stockMinimo(35)
					.unidadMedida("Unidad")
					.receta("Carne de Res x2, Pan, Salsa BBQ, Lechuga, Jitomate, ")
					.foto("imagen3.png")
					.build();
			productoRepository.save(p3);

			// Creando instancia de Rubro
			Rubro rubro = Rubro.builder()
					.denominacion("Gastronomico")
					.build();
			rubro.agregarProducto(p1);
			rubro.agregarProducto(p2);
			rubro.agregarProducto(p3);
			rubroRepository.save(rubro);

			// Creando la instancia de Factura1
			Factura factura1 = Factura.builder()
					.fecha("2023-09-21")
					.numero(571)
					.descuento(259.9)
					.formaPago(Factura.formaPago.EFECTIVO)
					.total(p1.getPrecioVenta()-259.9)
					.build();
			facturaRepository.save(factura1);

			// Creando la instancia de Factura2
			Factura factura2 = Factura.builder()
					.fecha("2023-09-21")
					.numero(162)
					.descuento(140.5)
					.formaPago(Factura.formaPago.ETC)
					.total(p2.getPrecioVenta()-140.5)
					.build();
			facturaRepository.save(factura2);

			// Creando la instancia de Factura3
			Factura factura3 = Factura.builder()
					.fecha("2023-09-21")
					.numero(722)
					.descuento(220)
					.formaPago(Factura.formaPago.EFECTIVO)
					.total(p3.getPrecioVenta()-220)
					.build();
			facturaRepository.save(factura3);

			// Creando la instancia de DetallePedido1
			DetallePedido dtp1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(2*p1.getPrecioVenta())
					.producto(p1)
					.build();
			detallePedidoRepository.save(dtp1);

			// Creando la instancia de DetallePedido2
			DetallePedido dtp2 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(4*p2.getPrecioVenta())
					.producto(p2)
					.build();
			detallePedidoRepository.save(dtp2);

			// Creando la instancia de DetallePedido3
			DetallePedido dtp3 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1*p3.getPrecioVenta())
					.producto(p3)
					.build();
			detallePedidoRepository.save(dtp3);

			// Creando la instancia pedido1
			Pedido pedido1 = Pedido.builder()
					.fecha("21:12")
					.estado(Pedido.EstadoPedido.INICIANDO)
					.horaEstimadaEntrega("+15min")
					.tipoEnvio(Pedido.tipoEnvio.DELIVERY)
					.total(dtp1.getSubtotal())
					.factura(factura1)
					.build();
			pedido1.agregarDetallePedido(dtp1);

			domicilio1.agregarPedidos(pedido1);
			pedido1.agregarDetallePedido(dtp1);
			pedidoRepository.save(pedido1);

			// Creando la instancia pedido2
			Pedido pedido2 = Pedido.builder()
					.fecha("21:35")
					.estado(Pedido.EstadoPedido.PREPARACION)
					.horaEstimadaEntrega("+7min")
					.tipoEnvio(Pedido.tipoEnvio.RETIRA)
					.total(dtp2.getSubtotal())
					.factura(factura2)
					.build();
			pedido2.agregarDetallePedido(dtp2);

			domicilio2.agregarPedidos(pedido2);
			pedido2.agregarDetallePedido(dtp2);
			pedidoRepository.save(pedido2);

			// Creando la instancia pedido
			Pedido pedido3 = Pedido.builder()
					.fecha("21:42")
					.estado(Pedido.EstadoPedido.INICIANDO)
					.horaEstimadaEntrega("+17min")
					.tipoEnvio(Pedido.tipoEnvio.DELIVERY)
					.total(dtp3.getSubtotal())
					.factura(factura3)
					.build();
			pedido3.agregarDetallePedido(dtp3);

			domicilio3.agregarPedidos(pedido3);
			pedido3.agregarDetallePedido(dtp3);
			pedidoRepository.save(pedido3);

			user1.agregarPedidoUsuario(pedido1);
			user2.agregarPedidoUsuario(pedido2);
			user1.agregarPedidoUsuario(pedido3);

			usuarioRepository.save(user1);
			usuarioRepository.save(user2);

			domicilio1.agregarPedidoDomicilio(pedido1);
			domicilio2.agregarPedidoDomicilio(pedido2);
			domicilio3.agregarPedidoDomicilio(pedido3);

			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);

		};
	}
}
