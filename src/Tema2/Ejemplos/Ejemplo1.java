package Tema2.Ejemplos;

public class Ejemplo1 extends Thread{
    private int c;
    private int hilo;

    /**
     *
     * @param hilo
     */
    public Ejemplo1(int hilo) {
        this.hilo = hilo;
        System.out.println("CREANDO HILO:" + hilo);
    }

    @Override
    public void run() {
        c=0;
        while (c<=5) {
            System.out.println("Hilo:" + hilo + " C = " + c);
            c++;
        }
    }

    public static void main(String[] args) {
        Ejemplo1 h = null;
        for (int i = 0; i < 3; i++) {
            h = new Ejemplo1(i+1);
            h.start();
        }
        System.out.println("3 HILOS CREADOS...");
    }
}
