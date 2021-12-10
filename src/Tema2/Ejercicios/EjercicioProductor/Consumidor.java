
package Tema2.Ejercicios.EjercicioProductor;

public class Consumidor implements Runnable {
	public Informacion info;
	
	public Consumidor(Informacion info){
		this.info = info;
	}

	public String infoConsumida;
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			String infoConsumida = info.getInfo();
			System.out.println(i + " He consumido " + infoConsumida);
		}		
	}
}
