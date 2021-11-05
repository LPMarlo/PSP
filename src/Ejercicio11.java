import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Ejercicio11 {
    public static void main(String[] args) {

        String p = Ejercicio10.class.getCanonicalName();
        String classpath = Objects.requireNonNull(Ejercicio10.class.getClassLoader().getResource("")).getPath();

        List<String> comando = new ArrayList<>();
        comando.add("java");
        comando.add(p);

        ProcessBuilder pb = new ProcessBuilder(comando);

        HashMap<String, String> vbles = (HashMap<String, String>) pb.environment();
        vbles.put("CLASSPATH", classpath);

        pb.inheritIO();
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
