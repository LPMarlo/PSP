/**
 * 
 */
package Tema3.ActEv.ejercicio1;

import Tema3.ActEv.cliente.ClienteServicio;
import Tema3.ActEv.modelo.Pedido;
import Tema3.ActEv.modelo.Producto;
import Tema3.ActEv.modelo.Tienda;

public class Ejercicio1 {

	public static void main(String[] args) {
		/*
		Para testear el cliente prepararemos una clase Ejercicio1.java cuyo main:
		a) Creará tres establecimientos de nombres “Establecimiento uno”, “Establecimiento
		dos” y “Establecimiento tres”.
		*/
		ClienteServicio clienteServicio = new ClienteServicio();
		Tienda tienda1 = new Tienda(clienteServicio, "Establecimientouno");
		Tienda tienda2 = new Tienda(clienteServicio, "Establecimientodos");
		Tienda tienda3 = new Tienda(clienteServicio, "Establecimientotres");

		/*
		b) En el “Establecimiento uno” registraremos dos pedidos: el primero de ellos constará
		de tres carbonaras, dos barbacoas y una de la casa. En el segundo pedido una
		margarita.
		*/
		Pedido pedido1 = new Pedido();
		pedido1.addProducto(new Producto("CARBONARA","Carbonara"));
		pedido1.addProducto(new Producto("CARBONARA","Carbonara"));
		pedido1.addProducto(new Producto("CARBONARA","Carbonara"));
		pedido1.addProducto(new Producto("BARBACOA","Barbacoa"));
		pedido1.addProducto(new Producto("BARBACOA","Barbacoa"));
		pedido1.addProducto(new Producto("CASA","De la casa"));
		tienda1.registraPedido(pedido1);

		Pedido pedido2 = new Pedido();
		pedido2.addProducto(new Producto("MARGARITA","Margarita"));
		tienda1.registraPedido(pedido2);

		/*
		c) En el “Establecimiento dos” registraremos un pedido de una extra de queso y una
		cuatro estaciones.
		*/
		Pedido pedido3 = new Pedido();
		pedido3.addProducto(new Producto("EXTRAQUESO","Extradequeso"));
		pedido3.addProducto(new Producto("4ESTACION","Cuatro estaciones"));
		tienda2.registraPedido(pedido3);
		/*
		d) El tercer pedido se quedará sin productos añadidos.
		 */
		Pedido pedido4 = new Pedido();
		tienda3.registraPedido(pedido4);

		System.out.println("Realizado correctamente.");
	}
}