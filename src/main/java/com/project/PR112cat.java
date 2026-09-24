package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        Path dir = Paths.get(rutaArxiu);
        // En cas de que la ruta sigui d'un directory no fa res i diu que es una carpeta 
        if (Files.isDirectory(dir)) {
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
        // En cas de que la ruta sigui d'un fitxer, agafa el contingut i el mostra
        } else if (Files.isRegularFile(dir)) {
            try {
                String contingut = Files.readString(dir, StandardCharsets.UTF_8);
                System.out.println(contingut);
            } catch (IOException e) {
                // Excepcio per si falla
                System.out.println("El fitxer no existeix o no és accessible.");
            }
        } else {
            // En cas de que no fasi ninguna de les anteriors parts imprimeix que el fitxer no existeix o no es accesible.
            System.out.println("El fitxer no existeix o no és accessible.");
        }
    }
}
