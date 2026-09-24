package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8; cada línia acaba amb un salt de línia
    public static void escriureFrases(String camiFitxer) {
        Path fitxer = Paths.get(camiFitxer);
        try {
            // Sobrescriu tot el fitxer sencer a unicament las lineas posadas en el writestring
            Files.writeString(fitxer, "I can only show you the door\nYou're the one that has to walk through it\n", StandardCharsets.UTF_8);
        } catch (IOException e) {
            // Excepcio per si trenca
            e.printStackTrace();
        }
    }
}
