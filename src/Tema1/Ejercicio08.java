package Tema1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio08 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        HashMap<String, String> vbles = (HashMap<String, String>) pb.environment();

        for (Map.Entry<String, String> entry :
             vbles.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        String comando = "CMD /C DIR /w";
        ProcessBuilder pb2 = new ProcessBuilder();

        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new FileReader("d"));
            pw = new PrintWriter(new FileWriter("log_err_ej6.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null && pw != null) {
                try {
                    br.close();
                    pw.close();
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}