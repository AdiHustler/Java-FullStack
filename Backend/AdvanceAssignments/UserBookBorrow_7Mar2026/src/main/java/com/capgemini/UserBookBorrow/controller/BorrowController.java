package com.capgemini.UserBookBorrow.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.UserBookBorrow.entity.BorrowRecord;
import com.capgemini.UserBookBorrow.service.BorrowService;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@Tag(name = "Borrow Records", description = "Borrow and return book endpoints")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    @Operation(summary = "Borrow a book")
    @ApiResponse(responseCode = "200", description = "Book borrowed successfully")
    @ApiResponse(responseCode = "400", description = "Book not available or user/book not found")
    public ResponseEntity<BorrowRecord> borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        BorrowRecord record = borrowService.borrowBook(userId, bookId);
        if (record == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(record);
    }

    @PutMapping("/return/{recordId}")
    @Operation(summary = "Return a borrowed book")
    @ApiResponse(responseCode = "200", description = "Book returned successfully")
    @ApiResponse(responseCode = "400", description = "Record not found or already returned")
    public ResponseEntity<BorrowRecord> returnBook(@PathVariable Long recordId) {
        BorrowRecord record = borrowService.returnBook(recordId);
        if (record == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(record);
    }

    @GetMapping
    @Operation(summary = "Get all borrow records")
    @ApiResponse(responseCode = "200", description = "List of all borrow records")
    public ResponseEntity<List<BorrowRecord>> getAllBorrowRecords() {
        return ResponseEntity.ok(borrowService.getAllBorrowRecords());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get borrow record by ID")
    @ApiResponse(responseCode = "200", description = "Borrow record found")
    @ApiResponse(responseCode = "404", description = "Borrow record not found")
    public ResponseEntity<BorrowRecord> getBorrowRecordById(@PathVariable Long id) {
        BorrowRecord record = borrowService.getBorrowRecordById(id);
        if (record == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(record);
    }
}
