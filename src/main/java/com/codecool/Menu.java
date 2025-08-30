package com.codecool;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private static final Map<String, String> MENU = new LinkedHashMap<>();

    public Menu() {
        MENU.put("1", "Add task");
        MENU.put("2", "List tasks");
        MENU.put("3", "Mark task as done");
        MENU.put("4", "Delete task");
        MENU.put("5", "Exit");
    }

    public void display() {
        System.out.println();

        for (Map.Entry<String, String> entry : MENU.entrySet()) {
            System.out.printf("%2s %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
