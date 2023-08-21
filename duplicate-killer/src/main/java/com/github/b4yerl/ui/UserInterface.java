package com.github.b4yerl.ui;

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
}
