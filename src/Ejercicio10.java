import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio10 {
    public static void main(String[] args) {
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