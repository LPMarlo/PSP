package SolucionesEjerciciosTema1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ejercicio10 {

	public static void main(String[] args) {
		List<String> lCommand = new ArrayList<>();
		lCommand.add("CMD");
		lCommand.add("/C");
		lCommand.add("echo");
		lCommand.add("%MI_NOMBRE%");

		ProcessBuilder pb = new ProcessBuilder(lCommand);
		
		Map<String, String> vEnt = pb.environment();		
		vEnt.put("MI_NOMBRE", "JESUS");
				
		pb.inheritIO();
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
