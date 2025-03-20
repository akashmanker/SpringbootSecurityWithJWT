package com.akashcodez.dao;

import com.akashcodez.entity.Task;
import com.akashcodez.repos.TaskRepository;
import com.akashcodez.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskDao implements TaskService {

    @Autowired
    TaskRepository taskRepository;



    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }


    public List<Task> getAllByUserId(int id){
        return taskRepository.findAllByAssigned(id);
    }

    @Override
    public Optional<Task> getById(int id) {
        return taskRepository.findById(id);
    }
}
