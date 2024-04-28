package edu.sdccd.cisc191.architectbankaccount.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findByUsername(String username);
}
