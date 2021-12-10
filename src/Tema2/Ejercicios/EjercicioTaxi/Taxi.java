/**
 * 
 */
package Tema2.Ejercicios.EjercicioTaxi;

/**
 * @author JESUS
 *
 */
public class Taxi {
	private double precioKmCarrera = 2.5;
	private double importeCarrera = 0;
	private int numKmCarrera = 0;
	private boolean disponible = true;

	public double getPrecioKmCarrera() {
		return precioKmCarrera;
	}

	public void setPrecioKmCarrera(double precioKmCarrera) {
		this.precioKmCarrera = precioKmCarrera;
	}

	public double getImporteCarrera() {
		return importeCarrera;
	}

	public void setImporteCarrera(double importeCarrera) {
		this.importeCarrera = importeCarrera;
	}

	public int getNumKmCarrera() {
		return numKmCarrera;
	}

	public void setNumKmCarrera(int numKmCarrera) {
		this.numKmCarrera = numKmCarrera;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	synchronized void iniciarTrayecto(Cliente c) {
		System.out.println(c.nombreCliente + " toma el taxi.");

		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		disponible = false;
	}

	synchronized void finalizarTrayecto(Cliente c) {
		System.out.println("Finaliza el trayecto de: "+c.nombreCliente + "(" + c.numKmCarrera + " km): "+(c.numKmCarrera*getPrecioKmCarrera()) + " euros.");
		disponible = true;
		notifyAll();
	}
}
