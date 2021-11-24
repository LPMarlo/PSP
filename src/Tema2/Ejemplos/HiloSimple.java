package Tema2.Ejemplos;

public class HiloSimple implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("En el Hilo... ");

    }
}
