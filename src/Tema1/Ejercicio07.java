package Tema1;

import java.io.IOException;

public class Ejercicio07 {
    public static void main(String[] args) {
        String comando = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        try {
            ProcessBuilder pb = new ProcessBuilder(comando, "youtube.com");
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
