
package Tema2.Ejercicios.EjercicioProductor;

public class Ejemplo5 {

	public static void main(String[] args) {
		Informacion info = new Informacion();
		
		Productor p = new Productor(info);
		Thread tProductor = new Thread(p);
		
		Consumidor c = new Consumidor(info);
		Thread tConsumidor = new Thread(c);
		
		tProductor.start();
		tConsumidor.start();
	}
}
