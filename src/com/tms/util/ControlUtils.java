package com.tms.util;

import com.tms.model.Task.Priority;
import com.tms.model.Task.Status;

public class ControlUtils {
    public static Priority parsePriority(String priority) {
        try {
            return Priority.valueOf(priority.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority, defaulting to LOW.");
            return Priority.LOW;
        }
    }

    public static Status parseStatus(String status) {
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status, defaulting to PENDING.");
            return Status.PENDING;
        }
    }

    public static String readInput(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'readInput'");
    }
}
