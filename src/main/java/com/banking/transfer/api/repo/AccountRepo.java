package com.banking.transfer.api.repo;


import com.banking.transfer.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<Account,Long> {
}
