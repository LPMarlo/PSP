package Tema2.Ejemplos;

public class UsaHilo {

    public static void main(String[] args) {
        HiloSimple hs = new HiloSimple();
        Thread t = new Thread(hs);
        t.start();
        for (int i=0; i<5; i++)
            System.out.println("Fuera del hilo ...");
    }
}
