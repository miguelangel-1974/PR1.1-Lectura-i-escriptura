package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al final del fitxer amb UTF-8; cada línia acaba amb un salt de línia
    public static void afegirFrases(String camiFitxer) {
        // Agafem la ruta
        Path fitxer = Paths.get(camiFitxer);
        try {
            // Afegim al fitxer de la ruta les dues frases
            Files.write(fitxer, List.of("I can only show you the door", "You're the one that has to walk through it"), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) { 
            // Excepcio per si trenca
            e.printStackTrace();
        }
    }
}
