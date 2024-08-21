package com.example.MyBudget.Service;

import com.example.MyBudget.Model.Account;
import com.example.MyBudget.Model.AccountData;
import com.example.MyBudget.Model.AccountDataWrapper;
import com.example.MyBudget.Model.Transaction;
import com.example.MyBudget.Model.TransactionData;
import com.example.MyBudget.Repository.AccountRepository;
import com.example.MyBudget.Repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;


import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Component
public class DataLoader {
	  @Autowired
	    private AccountRepository accountRepository;

	    @Autowired
	    private TransactionRepository transactionRepository;

	    @PostConstruct
	    public void loadInitialData() {
	        try {
	            // Create JAXBContext for AccountDataWrapper
	            JAXBContext jaxbContext = JAXBContext.newInstance(AccountDataWrapper.class);
	            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

	            // Read the XML file from resources
	            InputStream inputStream = getClass().getResourceAsStream("/my_budget_data.xml");
	            if (inputStream == null) {
	                throw new RuntimeException("Resource not found: /my_budget_data.xml");
	            }

	            // Unmarshal XML to AccountDataWrapper
	            AccountDataWrapper accountsDataWrapper = (AccountDataWrapper) unmarshaller.unmarshal(inputStream);

	            // Process the loaded data
	            for (AccountData accountData : accountsDataWrapper.getAccounts()) {
	                Account account = new Account();
	                account.setName(accountData.getName());
	                account.setCurrency(accountData.getCurrency());
	                account.setBalance(accountData.getBalance());

	                // Save the account first and use the returned object
	                account = accountRepository.save(account);

	                if (accountData.getTransactions() != null) {
	                    for (TransactionData transactionData : accountData.getTransactions()) {
	                        Transaction transaction = new Transaction();
	                        transaction.setDescription(transactionData.getDescription());
	                        transaction.setAmount(transactionData.getAmount().getValue());
	                        transaction.setCurrency(transactionData.getAmount().getCurrency());
	                        transaction.setAccount(account); // Set the persisted account

	                        transactionRepository.save(transaction);
	                    }
	                }
	            }
	        } catch (JAXBException e) {
	            e.printStackTrace();
	            // Handle the exception properly
	        }
	    }
	}
