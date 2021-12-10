/**
 * 
 */
package Tema2.Ejemplos.Utilidades;

/**
 * @author JESUS
 *
 */
public class Ejemplo1Thread extends Thread {
	private int c; // contador de cada hilo
	private int hilo;

	// constructor
	public Ejemplo1Thread(int hilo) {
		this.hilo = hilo;
		System.out.println("CREANDO HILO:" + hilo);
	}

	// método run
	public void run() {
		c = 0;
		while (c <= 5) {
			System.out.println("Hilo:" + hilo + " C = " + c);
			c++;
		}
	}//
}
