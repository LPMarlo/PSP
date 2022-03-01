package Tema1.Ejercicios;

public class LineaComandos {
    public static void main(String[] args) {
        System.out.println("He sido llamado con " + args.length + " argumentos.");

        for (int i = 0; i < args.length; i++) {
            System.out.println("- El " + (i+1) + "º argumento es: " + args[i]);
        }
    }
}
