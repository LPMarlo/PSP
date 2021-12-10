package Tema2.ExamenHilos.Apartado3;

import java.util.ArrayList;
import java.util.List;

public class Probador {

    /**
     * Se muestra por pantalla toda la ropa que se va a probar.
     * @param c
     */
    synchronized public void pasoPorProbador(Cliente c) {
        System.out.println(c.getNombre() + " accede al probador. Los articulos que se prueba son: ");
        List<String> lista = c.getListaRopa();

        // Se muestra toda la ropa que se muestra
        for (String s : lista) {
            System.out.println(s);
        }
    }
}
