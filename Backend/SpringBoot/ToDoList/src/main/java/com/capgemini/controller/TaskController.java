package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.entity.Task;
import com.capgemini.service.TaskService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public String listTasks(Model model) {

        model.addAttribute("taskList", service.getAllTasks());

        return "task-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {

        model.addAttribute("task", new Task());

        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute Task task,
                           BindingResult result,
                           @RequestParam("imageFile") MultipartFile file) {

        if(result.hasErrors())
            return "task-form";

        service.saveTask(task, file);

        return "redirect:/tasks";
    }

    @GetMapping("/toggle/{id}")
    public String toggleStatus(@PathVariable Long id) {

        service.toggleStatus(id);

        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {

        service.deleteTask(id);

        return "redirect:/tasks";
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {

        Task task = service.getTask(id);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(task.getImageType()))
                .body(task.getImageData());
    }
}