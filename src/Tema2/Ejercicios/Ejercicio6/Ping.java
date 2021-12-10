package Tema2.Ejercicios.Ejercicio6;

public class Ping extends Thread {
    private Object object;
    public Ping(Object object) {
        this.object = object;
    }

    synchronized public void run() {
        synchronized (object) {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("PING");
            }
        }

    }
}
