package com.tms.controller;

import com.tms.model.Task;
import com.tms.service.TaskService;
import com.tms.util.ControlUtils;

import java.util.Scanner;

public class TaskController {
    private TaskService taskService;
    private Scanner scanner;

    public TaskController(Scanner scanner) {
        this.scanner = scanner;
        this.taskService = new TaskService();
    }

    public void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        taskService.registerUser(username, password);
        System.out.println("User registered successfully!");
    }

    public void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (taskService.loginUser(username, password)) {
            System.out.println("Login successful!");
            handleUserMenu(username);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void handleUserMenu(String username) {
        while (true) {
            System.out.println("Welcome, " + username + "!");
            System.out.println("1. Create Task");
            System.out.println("2. View My Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (option) {
                case 1:
                    createTask(username);
                    break;
                case 2:
                    viewTasks(username);
                    break;
                case 3:
                    updateTaskStatus(username);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void createTask(String username) {
        System.out.print("Enter Task Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Task Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Due Date (yyyy-mm-dd): ");
        String dueDate = scanner.nextLine();
        System.out.print("Select Priority (LOW, MEDIUM, HIGH, CRITICAL): ");
        String priority = scanner.nextLine();

        Task task = new Task(title, description, dueDate, ControlUtils.parsePriority(priority));
        taskService.addTask(username, task);
        System.out.println("Task created successfully!");
    }

    private void viewTasks(String username) {
        System.out.println("===== Your Tasks =====");
        taskService.getUserTasks(username).forEach(System.out::println);
    }

    private void updateTaskStatus(String username) {
        System.out.print("Enter Task ID to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new status (PENDING, IN_PROGRESS, COMPLETED): ");
        String status = scanner.nextLine();
        taskService.updateTaskStatus(username, taskId, ControlUtils.parseStatus(status));
        System.out.println("Task status updated successfully!");
    }
}
