package com.example.desafiofullstack.service;

import com.example.desafiofullstack.model.Status;
import com.example.desafiofullstack.model.Task;
import com.example.desafiofullstack.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        task.setStatus(Status.TO_DO);
        return taskRepository.save(task);
    }

    public Task updateStatus(Long id, Status status) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public void clearAll() {
        taskRepository.deleteAll();
    }
}
