package com.tasktrack.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tasktrack.model.Task;
import com.tasktrack.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                task.setImageData(file.getBytes());
                task.setImageName(file.getOriginalFilename());
                task.setImageType(file.getContentType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        task.setStatus("PENDING");
        taskRepository.save(task);
    }

    @Override
    public void toggleStatus(Long id) {
        Task task = taskRepository.findById(id).get();
        if (task.getStatus().equals("PENDING")) {
            task.setStatus("COMPLETE");
        } else {
            task.setStatus("PENDING");
        }
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public byte[] getTaskImage(Long id) {
        Task task = taskRepository.findById(id).get();
        return task.getImageData();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

}
