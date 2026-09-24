package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDesti);

        if (Files.exists(destino)) {
            System.out.println("ADVERTENCIA! El fichero de destino existe y se sobreescribira.");
        }

        if (Files.exists(origen) && Files.isRegularFile(origen)) {
            try {
                String contingut = Files.readString(origen, StandardCharsets.UTF_8);
                Files.writeString(destino, contingut, StandardCharsets.UTF_8);
                System.out.println("Se ha copiado el contenido correctamente.");
            } catch (IOException e) {
                System.out.println("Ha habido un error al copiar el contenido, error: " + e.getMessage());
            }
        } else {
            System.out.println("El fichero de origen no existe.");
        }
    }
}
