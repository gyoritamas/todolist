package com.codecool;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> SUBMENUS = Arrays.asList("Add task", "List tasks", "Mark task as done", "Delete task", "Exit");
    private static final TaskManager taskManager = new TaskManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            switch (readUserInput()) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    markTaskDone();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
            }
        }
    }

    private static int readUserInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid submenu");
            return -1;
        }
    }

    private static void addTask() {
        System.out.println("Description: ");
        String description = scanner.nextLine();
        taskManager.addTask(description);
    }

    private static void listTasks() {
        if (taskManager.listTasks().isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            taskManager.listTasks()
                    .forEach(task -> System.out.printf("%-3d %-25s %s%n", task.getId(), task.getDescription(), task.isCompleted() ? "completed" : "incomplete"));
        }
    }

    private static void markTaskDone() {
        System.out.print("Task ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            taskManager.markTaskDone(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    private static void deleteTask() {
        System.out.print("Task ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            taskManager.removeTask(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
    }

    private static void displayMenu() {
        System.out.println();
        for (int i = 0; i < SUBMENUS.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, SUBMENUS.get(i));
        }
        System.out.println();
    }

}