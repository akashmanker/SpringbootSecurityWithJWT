package com.akashcodez.controllers;

import com.akashcodez.entity.Task;
import com.akashcodez.entity.User;
import com.akashcodez.service.TaskService;
import com.akashcodez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize(value = "hasAuthority('USER')")
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

//  @PreAuthorize(value = "hasAuthority('USER')")
    @GetMapping("/getAllTasks/{id}")
    public List<Task> getAllTasksByUserId(@PathVariable("id") int id) {
        return taskService.getAllByUserId(id);
    }



//  @PreAuthorize(value = "hasAuthority('USER')")
    @PostMapping("/updateStatus/{id}")
    public Task updateStatus(@PathVariable("id") int id){
        Optional<Task> byId = taskService.getById(id);
        Task task = byId.get();
        task.setStatus("COMPLETED");
        return taskService.createTask(task);
    }


    //----------------------------------------------------------------------


//  @PreAuthorize(value = "hasAuthority('USER')")
    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable("id") int id){
        Optional<User> byId = userService.getById(id);
        User user = byId.get();
        return "**Welcome to user Dashboard Page** \n User Name = "+user.getUserName()+" \n User email = "+user.getUserEmail();
    }


//  @PreAuthorize(value = "hasAuthority('USER')")
    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable("id") int id){
        Optional<User> byId = userService.getById(id);
        User user = byId.get();
        return "**Welcome to Profile Page** \n User Name = "+user.getUserName()+" \n User email = "+user.getUserEmail();
    }

}
