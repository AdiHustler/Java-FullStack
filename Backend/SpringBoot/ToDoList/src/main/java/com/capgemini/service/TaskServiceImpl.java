package com.capgemini.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.entity.Task;
import com.capgemini.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public void saveTask(Task task, MultipartFile file) {

        task.setStatus("PENDING");

        if(file != null && !file.isEmpty()) {
            try {
                task.setImageName(file.getOriginalFilename());
                task.setImageType(file.getContentType());
                task.setImageData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        repository.save(task);
    }

    @Override
    public void toggleStatus(Long id) {

        Task task = repository.findById(id).orElse(null);

        if(task != null) {

            if(task.getStatus().equals("PENDING"))
                task.setStatus("COMPLETE");
            else
                task.setStatus("PENDING");

            repository.save(task);
        }
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Task getTask(Long id) {
        return repository.findById(id).orElse(null);
    }
}