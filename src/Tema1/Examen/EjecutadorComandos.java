package Tema1.Examen; /**
 * 
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class EjecutadorComandos {	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		ejecutaComando("ping", "www.iescristobaldemonroy.es");
		ejecutaComando("pong", "direccion.inventada");
		ejecutaComando("echo", "%PATH%");
	}
	
	public static void ejecutaComando(String comando, String argumento) {
		System.out.println("Comenzando la ejecución del comando: " + comando + " " + argumento);
		System.out.println("Por favor, espere.");
		//Lista con el comando para ejecutar el proceso en el CMD
		List<String> lCommand = new ArrayList<>();
		lCommand.add("CMD"); //Para ir a la terminal
		lCommand.add("/C"); //Ejecutar el comando al finalizar la escritura
		lCommand.add(comando); // comando que se desea ejecutar en la terminal
		lCommand.add(argumento); // argumento del comando anterior

		ProcessBuilder pb = new ProcessBuilder(lCommand);

		//Fichero en caso de error
		pb.redirectError(new File(comando + ".err"));

		//Fichero en caso de ir bien
		pb.redirectOutput(new File(comando + ".log"));

		try {
			Process p = pb.start();
			if (p.waitFor() !=0 ) {
				System.out.println("La ejecución ha resultado satisfactoria, puedes consultar el estado de la ejecución en el archivo " + comando + ".err");
			} else {
				System.out.println("La ejecución ha resultado satisfactoria, puedes consultar el estado de la ejecución en el archivo " + comando + ".log");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}