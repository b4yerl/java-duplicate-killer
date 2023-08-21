package com.github.b4yerl.file;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class PathValidator {
    public static boolean isValidPath(String path) {
        // Normaliza o caminho para o sistema atual e checa a existência
        String normalizedPath = FilenameUtils.separatorsToSystem(path);
        boolean exists = new File(normalizedPath).isDirectory();
        return exists;
    }
}
