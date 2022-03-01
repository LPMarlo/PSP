package Tema4.Ejercicios;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Ejercicio2 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 2022;

        Socket cliente = null;

        try {
            cliente = new Socket(host, puerto);
            InetAddress ia = cliente.getInetAddress();

            System.out.println(cliente.getLocalPort());
            System.out.println(cliente.getPort());
            System.out.println(ia.getHostAddress());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
