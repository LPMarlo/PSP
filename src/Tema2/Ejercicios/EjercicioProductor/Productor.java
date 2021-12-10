
package Tema2.Ejercicios.EjercicioProductor;

import java.util.Random;

public class Productor implements Runnable {
	public static String[] caracteres = 
		{"palabra a", "palabra b", "palabra c", "palabra d", "palabra e", "palabra f", "palabra g", "palabra h", "palabra j", "palabra i"};
	public Random r = new Random();
	
	public Informacion info;
	
	public Productor(Informacion info){
		this.info = info;
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			int indice = r.nextInt(10);
			String infoProducida = caracteres[indice];
			info.setInfo(infoProducida);
			
			System.out.println(i + " He producido " + infoProducida);
		}
	}	
}
