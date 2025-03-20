package com.akashcodez.service;

import com.akashcodez.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public Task createTask(Task task);

    public void deleteTask(int id);

    public List<Task> getAll();

    public List<Task> getAllByUserId(int id);

    public Optional<Task> getById(int id);


}
