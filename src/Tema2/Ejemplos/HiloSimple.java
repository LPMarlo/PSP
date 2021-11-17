package Tema2.Ejemplos;

public class HiloSimple extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2500);
            System.out.println("Ejecuto");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
