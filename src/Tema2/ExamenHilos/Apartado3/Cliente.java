package Tema2.ExamenHilos.Apartado3;

import java.util.List;

public class Cliente implements Runnable {

    private String nombre;
    private List<String> listaRopa;
    private Probador probador;

    public Cliente(String nombre, List<String> listaRopa, Probador probador) {
        this.listaRopa = listaRopa;
        this.nombre = nombre;
        this.probador = probador;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getListaRopa() {
        return listaRopa;
    }

    @Override
    public void run() {

        probador.pasoPorProbador(this);
    }
}
