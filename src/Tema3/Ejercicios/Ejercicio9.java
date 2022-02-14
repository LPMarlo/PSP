package Tema3.Ejercicios;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class Ejercicio9 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Numero: ");
        int numero = Integer.parseInt(sc.nextLine());
        try {
            URL url = new URL("https://www.rfc-editor.org/pdfrfc/rfc"+numero+".txt.pdf");
            URLConnection con = url.openConnection();

            InputStream inputStream = con.getInputStream();
            // leer y escribir fichero binario
            FileOutputStream outputStream = new FileOutputStream("rfc"+numero+".pdf");
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
