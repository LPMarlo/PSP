
package ExamenPSP1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que creará un proceso de apertura del navegador Firefox 
 * accediendo a una página cualquiera
 */
public class ProcesoFirefox implements IProcesoJava {
	
	public static void main(String[] args) {	
		List<String> comando = new ArrayList<>();
		comando.add("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		comando.add("iescristobaldemonroy.es");
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
