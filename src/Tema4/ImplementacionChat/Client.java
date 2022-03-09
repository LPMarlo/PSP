package Tema4.ImplementacionChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Marlo Lebrón Pareja
 */
public class Client {

    private static final Scanner sc = new Scanner(System.in);
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 5000;

    public static void main(String[] args) {

        Socket clientSocket;
        BufferedReader in;
        PrintWriter out;

        try {
            clientSocket = new Socket(HOST, PORT);
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(() -> {
                while (true) {
                    out.println(sc.nextLine());
                    out.flush();
                }
            });
            sender.start();

            Thread receiver = new Thread(() -> {
                try {
                    String msg = in.readLine();
                    while (msg != null) {
                        System.out.println("Server: " + msg);
                        msg = in.readLine();
                    }
                    System.out.println("Server out of service");
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}