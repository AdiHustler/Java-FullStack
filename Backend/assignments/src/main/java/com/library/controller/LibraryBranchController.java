package com.library.controller;

import com.library.entity.LibraryBranch;
import com.library.service.LibraryBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class LibraryBranchController {

    private final LibraryBranchService branchService;

    @PostMapping
    public LibraryBranch addBranch(@RequestBody LibraryBranch branch) {
        return branchService.addBranch(branch);
    }

    @GetMapping
    public List<LibraryBranch> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/{id}")
    public LibraryBranch getBranchById(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    @PutMapping("/{id}")
    public LibraryBranch updateBranch(@PathVariable Long id,
                                      @RequestBody LibraryBranch branch) {
        return branchService.updateBranch(id, branch);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }
}