
package Tema2.Ejercicios.EjercicioTaxi;

public class Cliente implements Runnable {
	String nombreCliente;
	int numKmCarrera;	
	private Taxi taxi;

	public Cliente(String nombreCliente, int numKmCarrera, Taxi taxi) {
		this.nombreCliente = nombreCliente;
		this.numKmCarrera = numKmCarrera;
		this.taxi = taxi;
	}

	@Override
	public void run() {
		taxi.iniciarTrayecto(this);
		taxi.finalizarTrayecto(this);

	}
}
