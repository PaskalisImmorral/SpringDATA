package com.example.introtospringdata;

import com.example.introtospringdata.service.AccountService;
import com.example.introtospringdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
private UserService userService;
private AccountService accountService;


@Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
       // this.userService.registerUser("first",20);
        this.accountService.transferMoney(BigDecimal.valueOf(200),1);

    }
}
