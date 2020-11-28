package com.softpager.emedicare.services;

import com.softpager.emedicare.entities.Account;
import com.softpager.emedicare.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Object create(Account account);
    Optional<Account> getAccount(long theId);
    List<Account> getAccounts();
    void delete(long id);
    long countAccount();
}
