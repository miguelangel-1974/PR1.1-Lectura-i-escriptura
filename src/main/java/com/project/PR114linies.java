package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        // Ponemos la ruta dentro de un objeto Path llamado fitxer
        Path fitxer = Paths.get(camiFitxer);
        // Generamos un objeto random
        Random numero = new Random();
        // Generamos una variable int donde pondremos los numeros aleatorios
        int numero_aleatorio = 0;
        // Generamos una variable String donde iremos añadiendo los numeros aleatorios
        String numeros = "";
        // Bucle, mientras i < 10 (10 numeros empezando de 0)
        for (int i = 0; i < 10; i++) {
            // Genera un numero aleatorio del 0 al 100 (100 porque el ultimo numero no se cuenta entonces 0-99)
            numero_aleatorio = numero.nextInt(0, 100);
            // En caso de que el numero generado sea el ultimo no añadimos el salto de linea al final
            if (i == 9) {
                numeros += numero_aleatorio;
            } else {
                // Encaso contrario si añadimos el salto de linea al final
                numeros += numero_aleatorio + "\n";
            }
        }
        try {
            // Escribimos en el fichero todos los numeros que tenemos en el String
            Files.writeString(fitxer, numeros, StandardCharsets.UTF_8);
        } catch (IOException e) {
            // Expeccion por si falla algo al escribir
            e.printStackTrace();
        }
    }
}
