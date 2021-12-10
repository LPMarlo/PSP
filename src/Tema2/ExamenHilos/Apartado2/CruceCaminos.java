package Tema2.ExamenHilos.Apartado2;
/**
 * 
 */

/**
 * @author JESUS
 *
 */
public class CruceCaminos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaforo sem = new Semaforo();
		
		CocheThread c1 = new CocheThread("Coche 1", 3, sem);
		CocheThread c2 = new CocheThread("Coche 2", 7, sem);
		CocheThread c3 = new CocheThread("Coche 3", 2, sem);
		
		c1.start();
		c2.start();
		c3.start();		
	}
}
