package com.tms;

import com.tms.controller.TaskController;
import java.util.Scanner;

public class TaskManagementApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskController controller = new TaskController(scanner);
        
        while (true) {
            System.out.println("===== Task Management System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (option) {
                case 1:
                    controller.registerUser();
                    break;
                case 2:
                    controller.loginUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}

