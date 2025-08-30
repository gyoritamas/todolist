package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    /**
     * Adds a new task to the list
     *
     * @param description the task description
     * @return the created Task with a generated ID
     */
    public Task addTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        return task;
    }

    /**
     * Returns all the tasks currently in the list
     *
     * @return a List including every Task
     */
    public List<Task> listTasks() {
        return tasks;
    }

    /**
     * Marks a task as completed
     *
     * @param id the identifier of the task
     * @return the Task with the given ID, marked as completed;
     * null if no task exists with the given ID
     */
    public Task markTaskDone(int id) {
        Task task = findById(id);
        if (task != null) task.setCompleted();
        return task;
    }

    /**
     * Removes a task by ID
     *
     * @param id the identifier of the task
     * @return true if the task was found and removed, false otherwise
     */
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
