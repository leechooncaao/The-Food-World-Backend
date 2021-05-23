package com.thefoodworld.service.account;

import com.thefoodworld.model.Account;
import com.thefoodworld.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account findAccountById(Integer accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }
}
