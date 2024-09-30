package com.Security.JWT.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Security.JWT.Entity.Expenses;
import com.Security.JWT.Repositories.ExpenseRepository;


@Service
public class ExpenseService {

	
	   @Autowired
	    private ExpenseRepository expenseRepository;

	    public List<Expenses> getAllExpensesByUser(String userId) {
	        return expenseRepository.getAllByUserId(userId);
	    }

	    public Optional<Expenses> getExpenseById(Long id) {
	        return expenseRepository.findById(id);
	    }

	    public Expenses createExpense(Expenses expense) {
	        return expenseRepository.save(expense);
	    }

	    public Expenses updateExpense(Long id, Expenses expenseDetails) {
	        Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
	        expense.setExpenseName(expenseDetails.getExpenseName());
	        expense.setAmount(expenseDetails.getAmount());
	        expense.setDate(expenseDetails.getDate());
	        expense.setDescription(expenseDetails.getDescription());
	        return expenseRepository.save(expense);
	    }

	    public void deleteExpense(Long id) {
	        expenseRepository.deleteById(id);
	    }
}
