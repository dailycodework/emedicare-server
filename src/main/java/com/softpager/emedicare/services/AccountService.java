package com.softpager.emedicare.services;

import com.softpager.emedicare.dao.IGenericDao;
import com.softpager.emedicare.entities.Account;
import com.softpager.emedicare.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("accountService")
public class AccountService implements IAccountService {

    private IGenericDao<Account> account;

    @Autowired
    public void setDoctor(IGenericDao<Account> account) {
        this.account = account;
        this.account.setClazz(Account.class);
    }

    @Override
    @Transactional
    public Object create(Account acct) {
        Contact contact = new Contact(
                acct.getContact().getMobile(),
                acct.getContact().getEmail());
        acct.setContact(contact);
        return account.addNew(acct);
    }

    @Override
    public Optional<Account> getAccount(long theId) {
        return account.getOne(theId);
    }

    @Override
    public List<Account> getAccounts() {
        return account.getAll();
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public long countAccount() {
        return 0;
    }
}
