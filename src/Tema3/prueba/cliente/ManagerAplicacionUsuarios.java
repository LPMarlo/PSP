/**
 * 
 */
package Tema3.prueba.cliente;

import Tema3.prueba.modelo.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ManagerAplicacionUsuarios {
	// Atributos de la clase
	// Define aquí los atributos que vayas a usar en la clase
	private static final String PROVEEDOR = "http://idocentic.website/servicios_para_explotar/aplicacion_usuarios/";

	private static final String SERVICIO_BORRAR_USUARIO = "borraUsuario.php?";
	private static final String SERVICIO_COMPROBAR_USUARIO = "compruebaUsuario.php?";
	private static final String SERVICIO_INSERTAR_USUARIO = "insertaUsuario.php?";

	private static final String PARAMETRO_USUARIO = "USUARIO=";
	private static final String PARAMETRO_NOMBRE_USUARIO = "NOMBRE=";
	private static final String PARAMETRO_APELLIDO1_USUARIO = "APELLIDO1=";
	private static final String PARAMETRO_APELLIDO2_USUARIO = "APELLIDO2=";
	private static final String PARAMETRO_PASSWORD_USUARIO = "PASSWORD=";
	public static final String UNION = "&";


	// Métodos de la clase
	// Completa los métodos solicitados y aquellos que consideres necesarios.
	/**
	 * Llamará al servicio correspondiente para insertar un usuario en el sistema 
	 * con los datos pasados como parámetro.
	 * 
	 * @param nombre - del usuario a insertar
	 * @param apellido1 - del usuario a insertar
	 * @param apellido2 - del usuario a insertar
	 * @param usuario - del usuario a insertar
	 * @param password - del usuario a insertar
	 * @return
	 */
	public boolean insertaUsuario(String nombre, String apellido1, String apellido2, String usuario, String password) {
		boolean resultado = false;

		try {
			URL url = new URL((PROVEEDOR
							+ SERVICIO_INSERTAR_USUARIO
							+ PARAMETRO_NOMBRE_USUARIO + nombre
							+ UNION + PARAMETRO_APELLIDO1_USUARIO + apellido1
							+ UNION + PARAMETRO_APELLIDO2_USUARIO + apellido2
							+ UNION + PARAMETRO_USUARIO + usuario
							+ UNION + PARAMETRO_PASSWORD_USUARIO + password)
					.replace(" ", "%20")
			);

			URLConnection con = url.openConnection();
			InputStream inputStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			if (in.readLine().equals("OK")) resultado = true;

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/**
	 * Devolverá true si existe en el sistema un usuario con usuario y password 
	 * iguales a los pasados como parámetros.
	 * @param usuario
	 * @param password
	 * @return
	 */
	public boolean compruebaUsuario(String usuario, String password) {
		boolean resultado = true;

		try {
			URL url = new URL(
					(PROVEEDOR
							+ SERVICIO_COMPROBAR_USUARIO
							+ PARAMETRO_USUARIO + usuario
							+ UNION + PARAMETRO_PASSWORD_USUARIO + password
					).replace(" ", "%20")
			);

			URLConnection con = url.openConnection();
			InputStream inputStream = con.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			if (in.readLine().equals("KO")) resultado = false;

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/** Comprobará si existe un usuario con el usuario y password pasados como parámetro. 
	 * En caso de existir, lo borrará y devolverá true.
	 * Si por el contrario, el usuario no existe, devolverá false.
	 * 
	 * @param usuario
	 * @param password
	 * @return
	 */
	public boolean borraUsuario(String usuario, String password) {

		boolean existeUsuario = compruebaUsuario(usuario, password);

		if (existeUsuario) {
			try {
				URL url = new URL(
						(PROVEEDOR
								+ SERVICIO_BORRAR_USUARIO
								+ PARAMETRO_USUARIO + usuario
								+ UNION + PARAMETRO_PASSWORD_USUARIO + password
						).replace(" ", "%20")
				);

				URLConnection con = url.openConnection();
				con.getInputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return existeUsuario;
	}	
	 
	/**
	 * Devolverá un objeto de tipo Usuario con los valores del usuario obtenido
	 * mediante usuario y password
	 * 
	 * @param usuario
	 * @param password
	 * @return
	 */
	public Usuario generaUsuario(String usuario, String password) {
		Usuario usuario1 = null;

		if (compruebaUsuario(usuario, password)) {
			try {
				URL url = new URL(
						(PROVEEDOR
								+ SERVICIO_COMPROBAR_USUARIO
								+ PARAMETRO_USUARIO + usuario
								+ UNION + PARAMETRO_PASSWORD_USUARIO + password
						).replace(" ", "%20")
				);

				URLConnection con = url.openConnection();
				InputStream inputStream = con.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

				String linea;
				int contador = 0;
				String[] datos = new String[5];

				while ((linea = in.readLine()) != null) {
					datos[contador] = linea.split("=")[1];
					contador++;
				}
				usuario1 = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4]);

				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return usuario1;
	}
}
