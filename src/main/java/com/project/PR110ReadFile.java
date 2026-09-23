package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
        try {
            // Contador per numerar les lineas
            int contador = 0;
            // Llegeis totes les lineas del fitxer
            List<String> linies = Files.readAllLines(Paths.get(camiFitxer), StandardCharsets.UTF_8);
            // Bucle per mostrar cada linea amb el seu numero corresponent
            for (String linia : linies) {
                // Es suma 1 al contador per numerar la linea
                contador += 1;
                // Es mostra per pantalla el numero de la linea i el seu contingut
                System.out.println(contador + ": " +linia);
            }
        } catch (IOException e) {
            // En cas de error, es mostra un missatge indicant que hi ha hagut un problema en llegir el fitxer
            System.out.println("Error al llegir el fitxer: " + e.getMessage());
        }

    }
}
