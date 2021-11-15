/**
 * 
 */
package Tema1.Soluciones;

import java.io.*;

public class Ejercicio3 {

	/**
	 * Crea una clase Java cuyo método main lance un proceso que liste los ficheros del directorio actual y los guarde en un fichero de texto
	 */
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		//String comandoLinux = "ls -help";
		String comando = "CMD /C DIR";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(rt.exec(comando).getInputStream()));
			 PrintWriter pw = new PrintWriter(new FileWriter("salida_comando_" + comando.replace('/',  '_')));) {
			String linea;
			while ((linea = br.readLine())!=null) {
				pw.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
