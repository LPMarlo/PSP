package Tema3.ActEv.cliente;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JESUS
 *
 */
public class ClienteServicio {
	// ACTUALIZA AQUÍ EL CÓDIGO DE AUTOR.
	public static final String CODIGO_AUTOR = "MLEBPAR2002";

	public static final String PROVEEDOR = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/";

	public static final String SERVICIO_INICIALIZAR_PIZZERIA = "inicializaPizzeria.php?";
	public static final String SERVICIO_INSERTA_PEDIDO = "insertaPedido.php?";
	public static final String SERVICIO_INSERTA_PRODUCTO = "insertaProductoPedido.php?";
	public static final String SERVICIO_CONSULTA_PRODUCTO = "consultaProductos.php";

	public static final String PARAMETRO_CODIGO_AUTOR = "COD_AUTOR=";
	public static final String PARAMETRO_NOMBRE_TIENDA = "NOMBRE_TIENDA=";
	public static final String PARAMETRO_ID_TIENDA = "ID_TIENDA=";
	public static final String PARAMETRO_ID_PEDIDO = "ID_PEDIDO=";
	public static final String PARAMETRO_CODIGO_PRODUCTO = "COD_PRODUCTO=";

	public static final String UNION = "&";

	public ClienteServicio() {
	}

	public Integer nuevoEstablecimiento(String nombreEstablecimiento) {

		int idEstablecimiento = -1;
		try {
			URL url = new URL(
					(PROVEEDOR
							+ SERVICIO_INICIALIZAR_PIZZERIA
							+ PARAMETRO_CODIGO_AUTOR + CODIGO_AUTOR
							+ UNION + PARAMETRO_NOMBRE_TIENDA + nombreEstablecimiento
					).replace(" ", "%20")
			);

			URLConnection con = url.openConnection();
			InputStream inputStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			idEstablecimiento = Integer.parseInt(in.readLine());

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return idEstablecimiento;
	}

	public Integer nuevoPedido(Integer idTienda) {
		int idPedido = 0;
		try {
			URL url = new URL(
					(PROVEEDOR
							+ SERVICIO_INSERTA_PEDIDO
							+ PARAMETRO_CODIGO_AUTOR + CODIGO_AUTOR
							+ UNION + PARAMETRO_ID_TIENDA + idTienda
					).replace(" ", "%20")
			);

			URLConnection con = url.openConnection();
			InputStream inputStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			idPedido = Integer.parseInt(in.readLine());

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idPedido;
	}

	public boolean anadirProducto(Integer idTienda, Integer idPedido, String codProducto) {
		boolean resultado = false;
		try {
			URL url = new URL(
					(PROVEEDOR
							+ SERVICIO_INSERTA_PRODUCTO
							+ PARAMETRO_CODIGO_AUTOR + CODIGO_AUTOR
							+ UNION + PARAMETRO_ID_TIENDA + idTienda
							+ UNION + PARAMETRO_CODIGO_PRODUCTO + codProducto
							+ UNION + PARAMETRO_ID_PEDIDO + idPedido
					).replace(" ", "%20")
			);

			URLConnection con = url.openConnection();
			InputStream inputStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			if (in.readLine().equals("OK")) resultado = true;

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public Map<String, String> obtenerCodigoArticulos() {
		Map<String, String> articulos = new HashMap<>();
		try {
			URL url = new URL(PROVEEDOR + SERVICIO_CONSULTA_PRODUCTO);

			URLConnection con = url.openConnection();
			InputStream inputStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			String linea;
			while ((linea = in.readLine()) != null) {
				String[] claveValor = linea.split("=");
				articulos.put(claveValor[0], claveValor[1]);
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articulos;
	}
}