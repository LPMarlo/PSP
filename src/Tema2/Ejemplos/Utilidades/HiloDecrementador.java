/**
 * 
 */
package Tema2.Ejemplos.Utilidades;

/**
 * @author JESUS
 *
 */
public class HiloDecrementador extends Thread {
	private Contador contador;

	public HiloDecrementador(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.decrementa(); // incrementa el contador
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}