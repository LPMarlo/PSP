package Tema4.Ejercicios;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio1 {
    public static void main(String[] args) {
        int puerto = 2022;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(puerto);

            System.out.println(serverSocket.getLocalPort());

            Socket socket1 = serverSocket.accept();
            Socket socket2  = serverSocket.accept();

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
