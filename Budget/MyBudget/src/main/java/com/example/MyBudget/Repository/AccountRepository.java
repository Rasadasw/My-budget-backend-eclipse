package com.example.MyBudget.Repository;

import com.example.MyBudget.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}