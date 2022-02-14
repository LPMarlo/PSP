package Tema3.Ejercicios;

import java.net.UnknownHostException;

/*
Se ha publicado un servicio que nos permite averiguar nuestra dirección IP pública. Ese servicio
está alojado en el endpoint http://idocentic.website/. El site donde está alojado es
/servicios_para_explotar y el nombre del servicio en sí es obtener_ip.php. Implementa una
clase Java que, a partir del servicio, obtenga tu ip pública. Averigua la información relevante de
la misma mediante el uso de un objeto InetAddress (Ejercicio 1). Compara tus resultados con
los de tus compañeros, ¿Te llaman la atención?
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            System.out.println("Mi IP pública es: " + java.net.InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
