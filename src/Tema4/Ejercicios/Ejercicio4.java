package Tema4.Ejercicios;
import Tema4.Ejercicios.Utilidades.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio4 {

    public static void main(String[] args) {
        int puerto = 2022;

        try {
            ServerSocket server = new ServerSocket(puerto);
            Socket client = server.accept();

            OutputStream os = client.getOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(os);

            User userOutput = new User("Username", "Password");
            objectOutput.writeObject(userOutput);
            System.out.println("*Output*\nUsername: " + userOutput.getUsername() +"\nPassword: "+ userOutput.getPassword());

            InputStream is = client.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(is);
            User userInput = (User) objectInput.readObject();

            System.out.println("*Input*\nUsername: "+userInput.getUsername()+"\nPassword: "+userInput.getPassword());

            objectOutput.close();
            objectInput.close();
            client.close ();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}