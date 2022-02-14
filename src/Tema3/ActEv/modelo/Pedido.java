package Tema3.ActEv.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class Pedido {
	private List<Producto> productosPedido;

	public Pedido() {
		this.productosPedido = new ArrayList<>();
	}

	public List<Producto> getProductosPedido() {
		return productosPedido;
	}

	public void setProductosPedido(List<Producto> productosPedido) {
		this.productosPedido = productosPedido;
	}

	public void addProducto(Producto p) {
		productosPedido.add(p);
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder("Productos -> ");
		for (Producto p : productosPedido) {
			cadena.append("\n").append(p);
		}
		return cadena.toString();
	}
}