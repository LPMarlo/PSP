package Tema2.ExamenHilos.Apartado2;
/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class Semaforo {
	
	/**
	 * Pinta por pantalla cu�l es el veh�culo que entra en el carril.
	 * @param c
	 */
	public void cerrarCarril(CocheThread c) {
		System.out.println("Coche " + c.getName() + " sale del carril tras " + c.getSegundos() + " segundos.");
	}
	
	/**
	 * Pinta por pantalla el veh�culo que sale y el tiempo que ha dormido
	 * @param c
	 */
	public void abrirCarril(CocheThread c) {
		System.out.println("Coche " + c.getName() + " entra en el carril.");
	}
}