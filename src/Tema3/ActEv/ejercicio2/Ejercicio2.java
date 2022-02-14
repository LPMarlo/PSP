package Tema3.ActEv.ejercicio2;

import Tema3.ActEv.cliente.ClienteServicio;
import Tema3.ActEv.modelo.Pedido;
import Tema3.ActEv.modelo.Producto;
import Tema3.ActEv.modelo.Tienda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ClienteServicio cs = new ClienteServicio();
		Tienda tienda = new Tienda(cs, "A la carta");

		String registro = "N";
		System.out.println("Pizzería \"A la carta\"");
		do {
			registro = menu(cs, tienda, registro);
		} while (!registro.equalsIgnoreCase("S"));
	}

	private static String menu(ClienteServicio cs, Tienda tienda, String registro) {
		if (inputString("¿Desea registrar un pedido? (S)").equalsIgnoreCase("S")) {

			Pedido pedido = new Pedido();
			System.out.println("Iniciando su pedido");
			registrarProductos(cs, tienda, pedido);

			System.out.println("Pedido pendiente de registrar:");
			System.out.print(pedido);

			registro = inputString("\n¿Registrar pedido? (S/N)");
			if (registro.equalsIgnoreCase("S")) tienda.registraPedido(pedido);
		}
		return registro;
	}

	private static void registrarProductos(ClienteServicio cs, Tienda tienda, Pedido pedido) {
		do {
			Producto producto = obtenerArticulo(cs, tienda);
			pedido.addProducto(producto);
		} while (inputString("¿Finalizar pedido? (S/N)").equalsIgnoreCase("N"));
	}

	private static Producto obtenerArticulo(ClienteServicio cs, Tienda tienda) {
		int opcion = 0;
		Map<String, String> articulos  = cs.obtenerCodigoArticulos();
		Producto producto = null;
		Map<Integer, String> opciones = new HashMap<>();
		do {
			int contador = 1;
			for (Map.Entry<String, String> entry : articulos.entrySet()) {
				String k = entry.getKey();
				String v = entry.getValue();
				System.out.print(" " + contador + ". " + v);
				opciones.put(contador, k);
				contador++;
			}
			opcion = inputInt("\n¿Qué articulo desea?");
		} while (opcion < 1 || opcion > articulos.size());

		String codProducto = opciones.get(opcion);
		String nombreProducto = articulos.get(codProducto);
		producto = new Producto(codProducto, nombreProducto);

		return producto;
	}

	private static int inputInt(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	}

	private static String inputString(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
}
