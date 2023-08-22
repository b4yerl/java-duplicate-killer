package com.github.b4yerl.ui;

import com.github.b4yerl.file.DuplicateFileRemover;
import com.github.b4yerl.file.FileScanner;
import com.github.b4yerl.file.PathValidator;

public class UserInterface {
    public UserInterface() {
        mainMenu();
    }

    public void mainMenu() {
        String menu = """
                 ------------------------------------------
                |             DUPLICATE KILLER             |
                 ------------------------------------------
                |                                          |
                |                                          |
                |   Please insert the initial path below   |
                 ------------------------------------------
                """;
        System.out.println(menu);

        while(true) {
            System.out.print("Input: ");
            String path = InputHandler.getInput();
            boolean isValid = PathValidator.isValidPath(path);
            if(!isValid) System.out.println("*************\\\\INVALID PATH//*************");
            else { FileScanner.scanDirectory(path); break; }
        }
    }
    public static void removeUI(String pathToKill, String originalPath) {
        String alert = """
                 
                 ------------------------------------------
                |       !!! A DUPLICATE WAS FOUND !!!      |
                 ------------------------------------------
                """;
        System.out.println(alert);

        System.out.println(pathToKill);
        System.out.println("IS A DUPLICATE OF " + originalPath);
        System.out.println();

        System.out.println("Type No or N if you want to save your file, anything else and I will kill it: ");
        String answer = InputHandler.getInput();
        if(answer.equalsIgnoreCase("No") || answer.equalsIgnoreCase("N")) return;
        DuplicateFileRemover.killIt(pathToKill);
    }
}
