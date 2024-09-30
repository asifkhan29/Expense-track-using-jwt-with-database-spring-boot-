package com.Security.JWT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.JWT.Entity.Expenses;
import com.Security.JWT.Service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {
	
	   @Autowired
	    private ExpenseService expenseService;

	    @GetMapping("all/{userId}")
	    public List<Expenses> getAllExpenses(@PathVariable String userId) {
	        return expenseService.getAllExpensesByUser(userId);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Expenses> getExpenseById(@PathVariable Long id) {
	        return expenseService.getExpenseById(id)
	                .map(expense -> ResponseEntity.ok(expense))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping("/add")
	    public Expenses createExpense(@RequestBody Expenses expense) {
	        return expenseService.createExpense(expense);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Expenses> updateExpense(@PathVariable Long id, @RequestBody Expenses expenseDetails) {
	        return ResponseEntity.ok(expenseService.updateExpense(id, expenseDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
	        expenseService.deleteExpense(id);
	        return ResponseEntity.noContent().build();
	    }

}
