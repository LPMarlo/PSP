/**
 * 
 */
package Tema2.Ejemplos.Utilidades;

/**
 * @author JESUS
 *
 */
public class Ejemplo2Runnable implements Runnable {
	private int x;
	
	public Ejemplo2Runnable(int x) {
		this.x = x;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < x; i++) {
			System.out.println("En el Hilo... " + i);
		}
	}	
}