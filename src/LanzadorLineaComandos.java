import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LanzadorLineaComandos {
    public static void main(String[] args) {
        String name = LineaComandos.class.getCanonicalName();
        String classpath = Objects.requireNonNull(LineaComandos.class.getClassLoader().getResource("")).getPath();

        List<String> comando = new ArrayList<>();
        comando.add("java");
        comando.add("-classpath");
        comando.add(classpath);
        comando.add(name);
        comando.add("a");

        ProcessBuilder pb = new ProcessBuilder(comando);

        pb.inheritIO();
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
