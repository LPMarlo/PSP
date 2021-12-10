package Tema2.Ejercicios.Ejercicio6;


public class Ejercicio6 {
    public static void main(String[] args) {
        Object object = new Object();
        Ping p1 = new Ping(object);
        p1.start();
        Pong p2 = new Pong(object);
        p2.start();
    }
}
