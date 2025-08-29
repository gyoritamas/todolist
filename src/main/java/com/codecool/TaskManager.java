package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        return task;
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public Task completeTask(int id) {
        Task task = findById(id);
        if (task != null) task.setCompleted();
        return task;
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    private Task findById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) return task;
        }
        return null;
    }
}
