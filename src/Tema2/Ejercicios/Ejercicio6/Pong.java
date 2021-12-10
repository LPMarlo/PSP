package Tema2.Ejercicios.Ejercicio6;

public class Pong extends Thread {
    private Object object;
    public Pong(Object object) {
        this.object = object;
    }

    public void run() {
        synchronized (object){
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
                System.out.println("PONG");
            }
        }

    }
}
