package SolucionesEjerciciosTema1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Realiza una clase Java cuyo método main lance un proceso ejecutando la clase del Ejercicio10.
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		List<String> lCommand = new ArrayList<>();
		lCommand.add("java");
		lCommand.add("PSP.UD01.progmultiproceso.Ejercicio10");
		
		ProcessBuilder pb = new ProcessBuilder(lCommand);
		
		String classpath = "/home/profesor/git/PSP/PSP_jesusrodenas/bin";
		pb.environment().put("CLASSPATH", classpath);

		pb.inheritIO();
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
