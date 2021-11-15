
package Tema1.Soluciones;

public class Ejercicio4 {

	/**
	 * Crea una clase Java cuyo método main lance un comando que provoque errores y pinta por pantalla el valor devuelto por el error.
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comando = "CMD /C DIRRRR";

		try {
			Process p = rt.exec(comando);
			int status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
