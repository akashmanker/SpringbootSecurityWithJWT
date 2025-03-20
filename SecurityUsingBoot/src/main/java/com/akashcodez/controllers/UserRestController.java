package com.akashcodez.controllers;

import com.akashcodez.entity.Task;
import com.akashcodez.entity.User;
import com.akashcodez.service.TaskService;
import com.akashcodez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    @GetMapping("/getAllTasks/{id}")
    public List<Task> getAllTasksByUserId(@PathVariable("id") int id) {
        return taskService.getAllByUserId(id);
    }

    @PostMapping("/updateStatus/{id}")
    public Task updateStatus(@PathVariable("id") int id){
        Optional<Task> byId = taskService.getById(id);
        Task task = byId.get();
        task.setStatus("COMPLETED");
        return taskService.createTask(task);
    }


    //----------------------------------------------------------------------



    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable("id") int id){
        Optional<User> byId = userService.getById(id);
        User user = byId.get();
        return "**Welcome to user Dashboard Page** \n User Name = "+user.getUserName()+" \n User email = "+user.getUserEmail();
    }


    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable("id") int id){
        Optional<User> byId = userService.getById(id);
        User user = byId.get();
        return "**Welcome to Profile Page** \n User Name = "+user.getUserName()+" \n User email = "+user.getUserEmail();
    }






}
