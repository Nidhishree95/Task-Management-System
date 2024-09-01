package com.tms.service;

import com.tms.dao.TaskDAO;
import com.tms.model.Task;

import java.util.List;

public class TaskService {
    private TaskDAO taskDAO;

    public TaskService() {
        this.taskDAO = new TaskDAO();
    }

    public void registerUser(String username, String password) {
        taskDAO.createUser(username, password);
    }

    public boolean loginUser(String username, String password) {
        return taskDAO.validateUser(username, password);
    }

    public void addTask(String username, Task task) {
        taskDAO.addTask(username, task);
    }

    public List<Task> getUserTasks(String username) {
        return taskDAO.getTasksByUsername(username);
    }

    public void updateTaskStatus(String username, int taskId, Task.Status status) {
        taskDAO.updateTaskStatus(username, taskId, status);
    }
}

