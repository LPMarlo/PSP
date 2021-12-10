/**
 * 
 */
package Tema2.ExamenHilos.Apartado1;

/**
 * @author JESUS
 *
 */
public class ProcesoImpresion implements Runnable {
	ColaImpresion cola;
	String[] mensajeCompleto;
	
	/**
	 * 
	 */
	public ProcesoImpresion(String[] mensaje, ColaImpresion cola) {
		this.cola = cola;
		this.mensajeCompleto = mensaje;
	}

	@Override
	public void run() {
		// Se envia el mensaje a la  cola de impresion
		for (String s : mensajeCompleto) {
			cola.enviar(s);
		}

	}
}
