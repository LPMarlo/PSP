package Tema4.Ejercicios;

import Tema4.Ejercicios.Utilidades.User;

import java.io.*;
import java.net.Socket;

public class Ejercicio3 {

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int puerto = 2022;

        try {
            Socket client = new Socket(ip, puerto);

            InputStream is = client.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(is);

            User userInput = (User) objectInput.readObject();
            System.out.println("*Input*\nUsername: " + userInput.getUsername() + "\n Password: " + userInput.getPassword());

            userInput.setUsername("PSP");
            userInput.setPassword("PASSED");

            OutputStream os = client.getOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(os);

            objectOutput.writeObject(userInput);
            System.out.println("*Output*\nUsername: " + userInput.getUsername() + "\n Password: " + userInput.getPassword());

            objectInput.close();
            objectOutput.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}