
package Tema1.Soluciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {

	/**
	 * Realizar una clase Java cuyo método main cree un ProcessBuilder con un List de String realizando un listado del directorio src.
	 * Las salidas estándar y de error deben ser redirigidas a un fichero cuyo nombre sea salida_ejercicio9.txt y log_ejercicio9.txt respectivamente.
	 * Además, por pantalla debe indicarnos un mensaje sobre qué fichero consultar en función de si la ejecución del proceso ha sido o no errónea.
	 */
	public static void main(String[] args) {
		List<String> lCommand = new ArrayList<>();
		lCommand.add("CMD");
		lCommand.add("/C");
		lCommand.add("DIRR");
		
		ProcessBuilder pb = new ProcessBuilder(lCommand); 		
		File fOut = new File("salida_ejercicio9.txt");
		File fErr = new File("log_ejercicio9.txt");
		
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
