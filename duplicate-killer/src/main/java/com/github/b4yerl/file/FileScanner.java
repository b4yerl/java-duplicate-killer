package com.github.b4yerl.file;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileScanner {

    private static final Map<byte[], String> uniqueFiles;

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
            try {
                byte[] fileBytes = Files.readAllBytes(Paths.get(f.getPath()));
                if(!uniqueFiles.containsKey(fileBytes)) uniqueFiles.put(fileBytes, f.getAbsolutePath());
                else System.out.println("IM CALLING THE KIRA FOR YOU " + f.getPath());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
