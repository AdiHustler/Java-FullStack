package com.library.service.impl;

import com.library.entity.LibraryBranch;
import com.library.repository.LibraryBranchRepository;
import com.library.service.LibraryBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryBranchServiceImpl implements LibraryBranchService {

    private final LibraryBranchRepository branchRepository;

    @Override
    public LibraryBranch addBranch(LibraryBranch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<LibraryBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public LibraryBranch getBranchById(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @Override
    public LibraryBranch updateBranch(Long id, LibraryBranch updated) {
        LibraryBranch branch = getBranchById(id);
        branch.setName(updated.getName());
        branch.setLocation(updated.getLocation());
        branch.setContactNumber(updated.getContactNumber());
        return branchRepository.save(branch);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}