package com.codecool;

public class Task {
    private final int id;
    private final String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-25s %s", getId(), getDescription(), isCompleted() ? "completed" : "incomplete");
    }
}
