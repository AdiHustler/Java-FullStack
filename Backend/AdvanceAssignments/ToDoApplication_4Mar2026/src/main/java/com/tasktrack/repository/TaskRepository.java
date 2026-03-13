package com.tasktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasktrack.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
