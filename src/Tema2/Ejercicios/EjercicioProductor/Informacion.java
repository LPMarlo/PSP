/**
 *
 */
package Tema2.Ejercicios.EjercicioProductor;

/**
 * @author JESUS
 *
 */
public class Informacion {
	public String info = null;	
	
	synchronized public void setInfo(String info) {
		this.info = info;
	}
	
	synchronized public String getInfo() {
		return info;
	}
	
//	public boolean hayInfo = false;
//	synchronized public void setInfo(String info) {
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		while (hayInfo) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		hayInfo = true;
//		this.info = info;
//		notifyAll();
//	}
//
//	synchronized public String getInfo() {
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		while (!hayInfo) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		hayInfo = false;
//		notifyAll();
//		return info;
//	}
}
