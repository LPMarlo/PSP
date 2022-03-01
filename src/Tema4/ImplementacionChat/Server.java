package Tema4.ImplementacionChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final Scanner sc = new Scanner(System.in);
    public static final int PORT = 5000;

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket clientSocket;
        BufferedReader in;
        PrintWriter out;

        try {
            serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(() -> {
                while (true) {
                    out.println(sc.nextLine());
                    out.flush();
                }
            });
            sender.start();

            Thread receive = new Thread(() -> {
                try {
                    String msg = in.readLine();
                    while (msg != null) {
                        System.out.println("Client: " + msg);
                        msg = in.readLine();
                    }

                    System.out.println("Client disconnected");

                    out.close();
                    clientSocket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receive.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}