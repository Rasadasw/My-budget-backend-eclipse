package com.example.MyBudget.Model;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class TransactionData {
	 @JacksonXmlProperty(localName = "Description")
	    private String description;

	    @JacksonXmlProperty(localName = "Amount")
	    private AmountData amount;

	    // Getters and Setters
	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public AmountData getAmount() {
	        return amount;
	    }

	    public void setAmount(AmountData amount) {
	        this.amount = amount;
	    }
	}
