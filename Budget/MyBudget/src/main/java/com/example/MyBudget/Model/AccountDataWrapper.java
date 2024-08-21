package com.example.MyBudget.Model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AccountDataWrapper {
    @JacksonXmlElementWrapper(localName = "Accounts")
    @JacksonXmlProperty(localName = "Account")
    private List<AccountData> accounts;

    public List<AccountData> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountData> accounts) {
        this.accounts = accounts;
    }
}

