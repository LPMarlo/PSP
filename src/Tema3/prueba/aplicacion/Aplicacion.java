

package Tema3.prueba.aplicacion;

import Tema3.prueba.cliente.ManagerAplicacionUsuarios;
import Tema3.prueba.modelo.Usuario;

import java.util.Scanner;



public class Aplicacion {

	private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int opcion;
		ManagerAplicacionUsuarios manager = new ManagerAplicacionUsuarios();
		
		do {
			// SCANNER MODIFICADO
			muestraMenu();
			opcion = Integer.parseInt(sc.nextLine());
			if (opcion==1) {
				altaUsuario(manager);
			}
			if (opcion==2) {
				bajaUsuario(manager);
			}
			if (opcion==3) {
				consultaDatosUsuario(manager);
			}
		}while(opcion!=4);
		
		System.out.println("Hasta la próxima");
	}
	
	public static void muestraMenu() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Dar de alta usuario.");
		System.out.println("2. Borrar usuario.");
		System.out.println("3. Consultar datos de usuario.");
		System.out.println("4. Salir.");
	}
	
	/**
	 * Solicitará los datos del usuario a registrar y lo registrará.
	 * @param manager
	 */
	public static void altaUsuario(ManagerAplicacionUsuarios manager) {

		// Solicitud de datos
		String nombre = inputString("Nombre: ");
		String apellido1 = inputString("Primer apellido: ");
		String apellido2 = inputString("Segundo apellido: ");
		String usuario = inputString("Usuario: ");
		String password = inputString("Password: ");

		// Utilicación del cliente
		boolean registrado = manager.insertaUsuario(nombre, apellido1, apellido2, usuario, password);

		// Mostrar resultado
		if (registrado) System.out.println("Registrado correctamente.");
		else System.out.println("El usuario ya existe.");
	}
	
	/**
	 * Solicitará el usuario a borrar y lo borrará.
	 * Pintará "Usuario eliminado con éxito" en caso de existir."
	 * Pintará "El usuario insertado no existe para ser eliminado."
	 * @param manager
	 */
	public static void bajaUsuario(ManagerAplicacionUsuarios manager) {

		// Solicitud de datos
		String usuario = inputString("Usuario: ");
		String password = inputString("Password: ");

		// Utilicación del cliente
		boolean borrado = manager.borraUsuario(usuario, password);

		// Mostrar resultado
		if (borrado) System.out.println("Usuario eliminado con éxito.");
		else System.out.println("El usuario insertado no existe para ser eliminado.");
	}
	
	/**
	 * 1. Solicitará al usuario por línea de comandos usuario y password a consultar, 
	 * 2. Creará un objeto de tipo usuario mediante la llamada al servicio correspondiente.
	 * 3. Pintará los datos del objeto por pantalla (observa toString de Usuario)
	 * 
	 * @param manager
	 */
	public static void consultaDatosUsuario(ManagerAplicacionUsuarios manager) {

		// Solicitud de datos
		String usuario = inputString("Usuario: ");
		String password = inputString("Password: ");

		// Utilicación del cliente
		Usuario user = manager.generaUsuario(usuario, password);

		// Mostrar resultado
		if (user != null) System.out.println(user);
		else System.out.println("No existe el usuario.");
	}

	/**
	 * Muestra el String pasado por parámetro y retorna la solicitud del scanner
	 * @param msg
	 * @return datos solicitado
	 */
	public static String inputString(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
}
