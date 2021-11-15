package Tema1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio09 {
    public static void main(String[] args) {
        String command = "CMD /C DIR src";
        List<String> comando = new ArrayList<String>();
        comando.add("CMD");
        comando.add("/C");
        comando.add("DIR");
        comando.add("src");

        ProcessBuilder pb = new ProcessBuilder(comando);
        File outFile = new File("out.txt");
        File errorFile = new File("log_err.txt");

        pb.redirectError(errorFile);
        pb.redirectOutput(outFile);

        try {
            Process p = pb.start();

            if (p.waitFor()!=0) {
                System.out.println("Error");
            } else {
                System.out.println("Correcto");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
