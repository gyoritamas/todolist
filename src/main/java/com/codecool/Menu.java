package com.codecool;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private static final Map<String, String> menuItems = new LinkedHashMap<>();
    private static final TaskManager taskManager = new TaskManager();

    public Menu() {
        menuItems.put("1", "Add task");
        menuItems.put("2", "List tasks");
        menuItems.put("3", "Mark task as done");
        menuItems.put("4", "Delete task");
        menuItems.put("5", "Exit");
    }

    public void display() {
        System.out.println();

        for (Map.Entry<String, String> entry : menuItems.entrySet()) {
            System.out.printf("%2s %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public void addTask(String description) {
        System.out.println("Description: ");
        taskManager.addTask(description);
    }

    public void listTasks() {
        if (taskManager.listTasks().isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            taskManager.listTasks()
                    .forEach(task -> System.out.printf("%-3d %-25s %s%n", task.getId(), task.getDescription(), task.isCompleted() ? "completed" : "incomplete"));
        }
    }

    public void markTaskDone(int taskId) {
        System.out.print("Task ID: ");
        try {
            taskManager.markTaskDone(taskId);
        } catch (NumberFormatException e) {
            System.out.printf("Error: task with the ID %d doesn't exist%n", taskId);
        }
    }

    public void deleteTask(int taskId) {
        System.out.print("Task ID: ");
        try {
            taskManager.removeTask(taskId);
        } catch (NumberFormatException e) {
            System.out.printf("Error: task with the ID %d doesn't exist%n", taskId);
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void displayErrorInvalidMenu(String input) {
        System.out.printf("Error: '%s' is not a valid menu choice. Please enter 1-%d%n", input, menuItems.size());
    }
}
