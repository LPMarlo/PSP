package Tema3.Ejercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Ejercicio5 {
    private static final Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce una frase");
        String frase = sc.nextLine();
        frase = frase.replace(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;

        try {
            response = client.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://idocentic.website/mayusculas.php?FRASE="+frase))
                    .GET()
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (response != null) {
            String[] respuesta = response.body().split("<br/>");
            for (int i = 1; i < respuesta.length-1; i++) {
                System.out.print(respuesta[i] + " ");
            }
            System.out.print(respuesta[respuesta.length-1] + ". ");
            System.out.print("(La frase tiene " + respuesta[0] + " palabras)");
        }
    }
}
