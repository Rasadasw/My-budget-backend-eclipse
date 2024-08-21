package com.example.MyBudget.Model;



import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transaction;
import jakarta.validation.constraints.NotBlank;

@Entity
@JacksonXmlRootElement(localName = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account name cannot be blank")
    @JacksonXmlProperty(localName = "name")
    private String name;

    @NotBlank(message = "Currency cannot be blank")
    @JacksonXmlProperty(localName = "currency")
    private String currency;

    @JacksonXmlProperty(localName = "balance")
    private Double balance; // Added balance field

    @JacksonXmlProperty(localName = "transactions")
    private List<Transaction> transactions; // Changed to List<Transaction> to handle multiple transactions

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}