package com.tms.dao;

import com.tms.model.Task;

import java.util.*;

public class TaskDAO {
    private Map<String, String> users = new HashMap<>();
    private Map<String, List<Task>> tasks = new HashMap<>();
    private int taskIdCounter = 1;

    public void createUser(String username, String password) {
        users.put(username, password);
    }

    public boolean validateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void addTask(String username, Task task) {
        task.setId(taskIdCounter++);
        tasks.computeIfAbsent(username, k -> new ArrayList<>()).add(task);
    }

    public List<Task> getTasksByUsername(String username) {
        return tasks.getOrDefault(username, new ArrayList<>());
    }

    public void updateTaskStatus(String username, int taskId, Task.Status status) {
        List<Task> userTasks = tasks.get(username);
        if (userTasks != null) {
            for (Task task : userTasks) {
                if (task.getId() == taskId) {
                    task.setStatus(status);
                    break;
                }
            }
        }
    }
}
