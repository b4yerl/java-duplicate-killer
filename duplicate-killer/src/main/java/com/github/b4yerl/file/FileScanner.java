package com.github.b4yerl.file;

import com.github.b4yerl.ui.UserInterface;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileScanner {

    private static final Map<String, String> uniqueFiles;

    static {
        uniqueFiles = new HashMap<>();
    }

    public static void scanDirectory(String path) {
        path = FilenameUtils.separatorsToSystem(path);
        File initialDirectory = new File(path);
        scan(initialDirectory.listFiles());
    }
    private static void scan(File[] files) {
        for(File f : files) {
            if(f.isDirectory()) scanDirectory(f.getPath());
            else {
                try {
                    byte[] fileBytes = Files.readAllBytes(Paths.get(f.getPath()));
                    String fileContent = new String(fileBytes);
                    if(!uniqueFiles.containsKey(fileContent)) uniqueFiles.put(fileContent, f.getAbsolutePath());
                    else UserInterface.removeUI(f.getAbsolutePath(), uniqueFiles.get(fileContent));
                } catch (IOException e) {
                    System.out.println("An error occurred while reading " + f.getPath());
                    System.out.println("Error message: " + e.getMessage());
                }
            }
        }
    }
}
