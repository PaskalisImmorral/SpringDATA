package com.example.introtospringdata.repositories;

import com.example.introtospringdata.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
 Account findAccountById(long id);
}
