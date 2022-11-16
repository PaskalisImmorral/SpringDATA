package com.example.introtospringdata.service;

import com.example.introtospringdata.models.Account;
import com.example.introtospringdata.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    private  final AccountRepository accountRepository;
@Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, long id) {
        Optional<Account> account = this.accountRepository.findById(id);
        if (account.isEmpty()) {
            throw new RuntimeException("Account does not exist");
        }
        BigDecimal balance = account.get().getBalance();
        if (money.compareTo(balance) > 0) {
            throw new RuntimeException("Cannot withdraw!");
        }

            account.get().setBalance(balance.subtract(money));
        this.accountRepository.save(account.get());
        }

    @Override
    public void transferMoney(BigDecimal money, long id) {
   Account account =  this.accountRepository.findById(id).orElseThrow(() -> new RuntimeException
           ("Sorry, no account"));
   BigDecimal balance = account.getBalance();
   BigDecimal add = balance.add(money);
   account.setBalance(add);

   this.accountRepository.save(account);
    }
}
