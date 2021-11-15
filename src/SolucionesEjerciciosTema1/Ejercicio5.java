
package SolucionesEjerciciosTema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio5 {

	/**  
	 * Crea una clase Java cuyo método main lance un comando que provoque errores y pinte por pantalla la descripción del error.
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comando = "CMD /C DIRRRR";
		Process p = null;
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		BufferedReader br = null;
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);	
			System.out.println("La salida ha sido: ");

			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String linea ;
			while ((linea = br.readLine()) != null){
				System.out.println(linea);
			}
		}catch(InterruptedException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				assert br != null;
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
