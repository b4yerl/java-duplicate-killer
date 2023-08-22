package com.github.b4yerl.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DuplicateFileRemover {
    public static void killIt(String pathToKill) {
        try {
            Files.delete(Paths.get(pathToKill));
            System.out.println(pathToKill + " HAS BEEN SUCCESSFULLY KILLED");
        } catch(IOException e) {
            System.out.println("An error occurred while deleting the file: " + e.getMessage());
        }
    }
}
