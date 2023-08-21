package com.github.b4yerl.ui;

import java.util.Scanner;

public abstract class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }
}
