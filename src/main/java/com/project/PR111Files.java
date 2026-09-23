package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PR111Files {

    public static void main(String[] args) {
        String camiDirectori = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiDirectori);
    }

    // Rep la ruta del directori on cal crear la carpeta myFiles
    public static void gestionarArxius(String camiDirectori) {
        Path dir = Paths.get(camiDirectori + "/myFiles");
        Path f1 = dir.resolve("file1.txt");
        Path f2 = dir.resolve("file2.txt");

        try {
            // Crear el directori myFiles dins del directori especificat
            Files.createDirectories(dir);
            // Crear dos fitxers dins del directori myFiles
            Files.createFile(f1);
            Files.createFile(f2);
            try (Stream<Path> fills = Files.list(dir)) { // llista el contingut (cal tancar el Stream)
                System.out.println("Els arxius de la carpeta són:");
                // Mostra el contingut del directori myFiles
                fills.forEach(fitxer -> System.out.println(fitxer.getFileName()));
            }
            // Cambiar el nom del fitxer file2.txt a renamedFile.txt
            Files.move(f2, dir.resolve("renamedFile.txt"));
            // Eliminar el fitxer file1.txt
            Files.delete(f1);
            try (Stream<Path> fills = Files.list(dir)) { // llista el contingut (cal tancar el Stream)
                System.out.println("Els arxius de la carpeta són:");
                // Mostra el contingut del directori myFiles
                fills.forEach(fitxer -> System.out.println(fitxer.getFileName()));
            }
        } catch (IOException e) {
            // En cas d'error, es mostra un missatge personalitzat
            System.out.println("Error: " + e.getMessage());
        }
    }
}
