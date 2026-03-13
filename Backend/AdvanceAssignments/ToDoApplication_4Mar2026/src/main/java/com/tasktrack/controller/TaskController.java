package com.tasktrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tasktrack.model.Task;
import com.tasktrack.service.TaskService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> taskList = taskService.getAllTasks();
        model.addAttribute("taskList", taskList);
        return "task-list";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("priorities", List.of("LOW", "MEDIUM", "HIGH"));
        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@Valid Task task, BindingResult result, @RequestParam("imageFile") MultipartFile imageFile,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("priorities", List.of("LOW", "MEDIUM", "HIGH"));
            return "task-form";
        }
        taskService.saveTask(task, imageFile);
        return "redirect:/tasks";
    }

    @GetMapping("/toggle/{id}")
    public String toggleStatus(@PathVariable Long id) {
        taskService.toggleStatus(id);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getTaskImage(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task.getImageData() == null) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", task.getImageType());
        return new ResponseEntity<>(task.getImageData(), headers, HttpStatus.OK);
    }

}
