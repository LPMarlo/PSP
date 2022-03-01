package Tema1.Ejercicios;

import java.io.*;

public class Ejercicio06 {
    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("CMD /C DIR");
            InputStream is;
            int status = p.waitFor();

            if (status == 0) {
                is = p.getInputStream();
            } else {
                is = p.getErrorStream();
                System.out.println("Valor Error: " + status);
            }

            br = new BufferedReader(new InputStreamReader(is));
            pw = new PrintWriter(new FileWriter("log_err_ej6.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                pw.print(linea);
            }
        } catch (IOException | InterruptedException e) {
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