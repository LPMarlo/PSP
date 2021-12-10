
package Tema2.Ejemplos;

import Tema2.Ejemplos.Utilidades.Contador;
import Tema2.Ejemplos.Utilidades.HiloDecrementador;
import Tema2.Ejemplos.Utilidades.HiloIncrementador;

public class Ejemplo3 {
	
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloIncrementador a = new HiloIncrementador("HiloA", cont);
		HiloDecrementador b = new HiloDecrementador("HiloB", cont);
		a .start();
		b .start();

	}

}
