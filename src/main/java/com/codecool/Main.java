package com.codecool;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            menu.display();
            String inputForMenu = readUserInput();
            switch (inputForMenu) {
                case "1" -> {
                    System.out.print("Task: ");
                    menu.addTask(readUserInput());
                }
                case "2" -> menu.listTasks();
                case "3" -> {
                    System.out.print("Task ID: ");
                    menu.markTaskDone(readTaskId());
                }
                case "4" -> {
                    System.out.print("Task ID: ");
                    menu.deleteTask(readTaskId());
                }
                case "5" -> menu.exit();
                default -> menu.printErrorInvalidMenu(inputForMenu);
            }
        } while (true);
    }

    private static int readTaskId() {
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.printf("Error: task with the ID '%s' doesn't exist%n", userInput);
            return -1;
        }
    }

    private static String readUserInput() {
        return scanner.nextLine();
    }

}