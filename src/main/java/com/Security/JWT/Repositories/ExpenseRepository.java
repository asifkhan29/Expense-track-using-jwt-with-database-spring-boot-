package com.Security.JWT.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security.JWT.Entity.Expenses;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long>{
	
	List<Expenses> getAllByUserId(String userId);

}
