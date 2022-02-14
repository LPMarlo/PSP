package Tema3.Ejercicios;

import java.util.Scanner;


/*
La siguiente p�gina muestra mapas de la luz solar en la Tierra para una fecha y hora dadas:
https://www.timeanddate.com/worldclock/sunearth.html
Investigando un poco en el c�digo HTML de la p�gina mostrada al hacer una consulta
(�int�ntalo t�!), se puede averiguar que la imagen para una fecha y hora determinadas se
puede obtener con el URL
https://www.timeanddate.com/scripts/sunmap.php?iso=AAAAMMDDTHHMM
La parte variable del URL se muestra en cursiva, siendo AAAA el a�o, MM el mes, DD el d�a, HH
la hora y MM los minutos.
Crea un programa que, dada una fecha en formato AAAAMMDD, y una hora en formato
HHMM, pasados por l�nea de comandos, descargue un fichero con el mapa de la luz solar en la
Tierra para la fecha y hora dadas. En el nombre del fichero deben aparecer la fecha y hora, y su
extensi�n debe ser la apropiada para el tipo de fichero de imagen obtenido.
Obt�n un fichero para los dos solsticios y para los dos equinoccios, y comenta las semejanzas y
diferencias entre ellos.
 */
public class Ejercicio8 {

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce la fecha en formato AAAAMMDD: ");
        String fecha = sc.nextLine();

        System.out.println("Introduce la hora en formato HHMM: ");
        String hora = sc.nextLine();

        String url = "https://www.timeanddate.com/scripts/sunmap.php?iso=" + fecha + hora;

    }
}
