import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio10 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        List<String> comando = new ArrayList<String>();
        comando.add("CMD");
        comando.add("/C");
        comando.add("echo");
        comando.add("%MI_NOMBRE%");

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
