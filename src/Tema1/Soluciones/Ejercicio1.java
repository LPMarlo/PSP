
package Tema1.Soluciones;

import java.io.IOException;

public class Ejercicio1 {

	/**
	 * Crea una clase Java cuyo método main lance la aplicación de Firefox.
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comando = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe iescristobaldemonroy.es";
		try {
			rt.exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
