package com.akashcodez.controllers;

import com.akashcodez.entity.Task;
import com.akashcodez.entity.User;
import com.akashcodez.service.TaskService;
import com.akashcodez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userService.getAll();
    }


    @GetMapping("/getAllTasks")
    public List<Task> getTasks(){
        return taskService.getAll();
    }

    @PostMapping("/create")
    public Task createAndAssignTask(@RequestBody Task task, HttpServletResponse response) throws IOException {

        int assignedTo = task.getassigned();
        if(userService.getById(assignedTo).isPresent()){
            return taskService.createTask(task);
        }
        response.sendError(404,"User Not Found");
        return task;
    }

    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable("id")int id){
        taskService.deleteTask(id);
    }



    //==================================================================================



    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable("id") int id){
        Optional<User> byId = userService.getById(id);
        User user = byId.get();
        return "**Welcome to ADMIN Dashboard Page** \n ADMIN Name = "+user.getUserName()+" \n ADMIN email = "+user.getUserEmail();
    }


    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable("id") int id){
        Optional<User> byId = userService.getById(id);
        User user = byId.get();
        return "**Welcome to Profile Page** \n ADMIN Name = "+user.getUserName()+" \n ADMIN email = "+user.getUserEmail();
    }

}
