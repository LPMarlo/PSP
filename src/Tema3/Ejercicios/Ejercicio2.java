package Tema3.Ejercicios;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            URL direccion = new URL("https://docs.oracle.com/javase/8/docs/api/");
            System.out.println("El protocolo utilizado es: " + direccion.getProtocol());
            System.out.println("El host es: " + direccion.getHost());
            System.out.println("El puerto es: " + direccion.getPort());
            System.out.println("El fichero es: " + direccion.getFile());
        } catch (MalformedURLException e) {
            System.out.println("Error en la construccion de la URL");
        }
    }
}
