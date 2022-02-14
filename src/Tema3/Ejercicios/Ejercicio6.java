package Tema3.Ejercicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Ejercicio6 {
    private static final String URL = "http://idocentic.website/servicios_para_explotar/suma_parametros.php";
    private static final String PARAM_A = "PARAM_A";
    private static final String PARAM_B = "PARAM_B";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("numero 1: ");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("numero 2: ");
        int num2 = Integer.parseInt(sc.nextLine());

        sumar(num1, num2);
    }

    private static void sumar(int num1, int num2) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(PARAM_A + "="+num1+"&" + PARAM_B + "="+num2))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (response != null) {
            System.out.println(response.body().replace("<resultado>", ""));
        }
    }
}
