package Tema1.Examen; /**

 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class KillJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pid = args[0]; // ID del proceso a eliminar

		List<String> comando = new ArrayList<>();
		comando.add("CMD");
		comando.add("/C");
		comando.add("taskkill");
		comando.add("/F");
		comando.add("/PID");
		comando.add(pid);

		ProcessBuilder pb = new ProcessBuilder(comando);

		try {
			pb.start();
			System.out.println("Correcto: se terminó el proceso con PID " + pid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
