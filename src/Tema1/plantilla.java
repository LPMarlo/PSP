package Tema1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class plantilla {
    public static void main(String[] args) {
        ficheroLogYSalida();
    }

    public static void lanzarAppRT() {
        Runtime rt = Runtime.getRuntime();
        String comando = "";

        try {
            rt.exec(comando);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lanzarAppPB() {
        String comando = "";
        String web = "";

        try {
            ProcessBuilder pb = new ProcessBuilder(comando, web);
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lanzarProcesoCMD_RT() {
        Runtime rt = Runtime.getRuntime();
        String comando = "CMD /C DIR";

        try {
            Process p = rt.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lanzarProcesoCMD_PB() {
        ProcessBuilder pEnv = new ProcessBuilder();
        Map<String, String> vbles = pEnv.environment();

        List<String> comando = new ArrayList<String>();
        comando.add("CMD");
        comando.add("/C");
        comando.add("DIRR");
        ProcessBuilder pb = new ProcessBuilder(comando);

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ficheroLogYSalida() {
        List<String> lCommand = new ArrayList<String>();
        lCommand.add("CMD");
        lCommand.add("/C");
        lCommand.add("DIR");

        ProcessBuilder pb = new ProcessBuilder(lCommand);
        File fOut = new File("salida_ejercicio9.txt");
        File fErr = new File("log_ejercicio9.txt");

        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        //pb.wait(); 1- Error, 0- Salida
        try {
            Process p = pb.start();
            int status = p.waitFor();
            System.out.println(status);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addNuevaVariableDeEntorno() {
        List<String> comando = new ArrayList<>();
        comando.add("CMD");
        comando.add("/C");
        //comando.add("set");
        comando.add("echo");
        comando.add("%MI_NOMBRE%");

        ProcessBuilder pb = new ProcessBuilder(comando);
        HashMap<String, String> vbles = (HashMap<String, String>) pb.environment();
        vbles.put("MI_NOMBRE", "MARLO");

        for (Map.Entry cad : vbles.entrySet()) {
            System.out.println(cad);
        }

        pb.inheritIO();

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
