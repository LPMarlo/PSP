
package SolucionesEjerciciosTema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

	/**
	 * Crea una clase Java cuyo método main lance un proceso que liste los ficheros del directorio actual y los pinte por pantalla.
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comando = "CMD /C DIR";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(rt.exec(comando).getInputStream()))) {
			String linea;
			while ((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
