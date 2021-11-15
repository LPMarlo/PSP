package Tema1.Examen; /**
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class LanzaContador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> comando = new ArrayList<>();
		comando.add("java");
		comando.add("-cp");
		comando.add(Contador.class.getClassLoader().getResource("").getPath()); //CLASSPATH de Contador
		comando.add(Contador.class.getCanonicalName()); //Canonical Name de Contador

		ProcessBuilder pb = new ProcessBuilder(comando);

		pb.inheritIO(); //Pintar por pantalla
		try {
			Process p = pb.start();
			System.out.println("El PID del proceso es. " + p.pid());

			//Tambien se puede obtener el pid con el ProcessHandle
			//ProcessHandle ph = p.toHandle();
			//System.out.println(ph.pid());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}