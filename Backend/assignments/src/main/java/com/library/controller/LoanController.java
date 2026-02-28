package com.library.controller;

import com.library.entity.Loan;
import com.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/issue")
    public Loan issueBook(@RequestParam Long memberId,
                          @RequestParam Long bookId,
                          @RequestParam String dueDate) {

        return loanService.issueBook(
                memberId,
                bookId,
                LocalDate.parse(dueDate)
        );
    }

    @PutMapping("/{loanId}/return")
    public Loan returnBook(@PathVariable Long loanId) {
        return loanService.returnBook(loanId);
    }

    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable Long loanId) {
        return loanService.getLoanById(loanId);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/members/{memberId}")
    public List<Loan> getLoansByMember(@PathVariable Long memberId) {
        return loanService.getLoansByMember(memberId);
    }
}