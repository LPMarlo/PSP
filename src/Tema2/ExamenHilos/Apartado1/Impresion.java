/**
 * 
 */
package Tema2.ExamenHilos.Apartado1;

/**
 * @author JESUS
 *
 */
public class Impresion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] mensaje = {"En", " un", " lugar", " de", " la", " mancha", 
				"\nde", " cuyo", " nombre", " no", " quiero", " acordarme"};
		
		ColaImpresion cola = new ColaImpresion(mensaje.length);
		ProcesoImpresion pi = new ProcesoImpresion(mensaje, cola);
		Impresora impresora = new Impresora(cola);
		
		Thread tProceso = new Thread(pi);
		Thread tImpresora = new Thread(impresora);
		
		tProceso.start();
		tImpresora.start();
	}
}