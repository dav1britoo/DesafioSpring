package com.example.desafiofullstack.controller;

import com.example.desafiofullstack.model.Task;
import com.example.desafiofullstack.model.Status;
import com.example.desafiofullstack.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService repository;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll(){
        return taskService.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @PutMapping("{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestParam Status status){
        return repository.updateStatus(id, status);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id){
        taskService.delete(id);
    }

    @DeleteMapping
    public void clearAll() {
        taskService.clearAll();
    }

}
