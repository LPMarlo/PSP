/**
 * 
 */
package Tema2.ExamenHilos.Apartado1;

/**
 * @author JESUS
 *
 */
public class Impresora implements Runnable{

	ColaImpresion cola; 
	
	public Impresora (ColaImpresion cola) {
		this.cola = cola;
	}

	@Override
	public void run() {
		// Recibe la palabra de la cola de impreción para mostrarla
		for (int i = 0; i < cola.lenght; i++) {
			System.out.print(cola.recibir());

			// Sleep de 1s con " ... " para saber cuando se hace
			try {
				System.out.print(" ... ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
