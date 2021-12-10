package Tema2.ExamenHilos.Apartado2;
/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class CocheThread extends Thread {

	/**
	 * Estos son los atributos de la clase CocheThread.
	 * NO ES NECESARIO A�ADIR NINGUNO M�S.
	 */
	private Semaforo semaforo;
	private int segundos;

    public CocheThread(String s, int i, Semaforo sem) {
		this.segundos = i;
		setName(s); // Herencia del atributo name de la clase Thread
		this.semaforo = sem;
    }

	public int getSegundos() {
		return segundos;
	}

	@Override
	public void run() {

		// Se sincroniza el carril para que el coche entre y salga sin que otro pueda hacerlo
		synchronized (semaforo) {
			semaforo.abrirCarril(this);

			// Sleep según lo introducido
			try {
				Thread.sleep(segundos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semaforo.cerrarCarril(this);
		}

	}
}
