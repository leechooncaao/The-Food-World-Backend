package com.thefoodworld.service.account_role;

import com.thefoodworld.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService{
    @Autowired
    private AccountRoleRepository accountRoleRepository;
}
