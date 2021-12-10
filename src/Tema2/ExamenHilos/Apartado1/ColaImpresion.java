/**
 * 
 */
package Tema2.ExamenHilos.Apartado1;

/**
 * @author JESUS
 *
 */
public class ColaImpresion{
	String mensaje;
	int lenght;
	private boolean ocupada = true;
	public ColaImpresion(int lenght) {
		this.lenght = lenght;
	}

	/**
	 * 
	 * @param s
	 */
	synchronized void enviar(String s) {
		// Mientras no está ocupada se puede recibir un mensaje de la cola de impresion, por lo tanto enviar() debe esperar.
		while (!ocupada) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		mensaje = s;
		ocupada = false;
		notifyAll();
	}
	
	/**
	 * 
	 * @return
	 */
	synchronized public String recibir() {
		// Mientras está ocupada se envia un mensaje a la cola de impresion, por lo tanto recibir() debe esperar.
		while (ocupada) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ocupada = true;
		notifyAll();
		return mensaje;
	}
}
