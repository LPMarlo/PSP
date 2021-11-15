package Tema1.Examen; /**
 * 
 */

/**
 * @author JESUS
 *
 */
public class Contador {
	public static void main(String[] args) {
		int i = 1;
		while (true) {
			try {
				
				System.out.println("Instante : " + i + " ... ");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}

	}
}
