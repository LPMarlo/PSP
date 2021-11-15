
package Tema1.Soluciones;

import java.io.IOException;

public class Ejercicio7 {

	/**
	 * Crea una clase Java cuyo método main lance la aplicación de Firefox haciendo uso de ProcessBuilder y pasándole una URL como parámetro.
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comando = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		
		try {
			ProcessBuilder pb = new ProcessBuilder(comando, "iescristobaldemonroy.es");
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
