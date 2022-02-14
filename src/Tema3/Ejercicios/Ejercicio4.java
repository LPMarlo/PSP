package Tema3.Ejercicios;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Ejercicio4 {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        try {
            url = new URL("http://www.idocentic.website/prueba.html");
            urlCon = url.openConnection();

            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

            PrintWriter pw = new PrintWriter(new FileWriter("ficheros\\prueba.txt"));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                pw.println(inputLine);
            }
            in.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}