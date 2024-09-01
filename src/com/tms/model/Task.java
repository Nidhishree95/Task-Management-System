package com.tms.model;

public class Task implements Serializable{
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private Priority priority;
    private Status status;

    public Task(String title, String description, String dueDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = Status.PENDING;
    }

    public enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\nTitle: " + title + "\nDescription: " + description +
               "\nDue Date: " + dueDate + "\nPriority: " + priority + "\nStatus: " + status + "\n";
    }
}
