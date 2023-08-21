package com.github.b4yerl.ui;

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

        boolean isValid = false;
        while(!isValid) {
            System.out.print("Input: ");
            String path = InputHandler.getInput();
            isValid = PathValidator.isValidPath(path);
            if(!isValid) System.out.println("*************\\\\INVALID PATH//*************");
            else System.out.println("Everything worked fine for path " + path);
        }

        // FileScanner.scan(path)
    }
}
