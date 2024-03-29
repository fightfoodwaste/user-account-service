package com.fightfoodwaste.useraccountservice.repository;

import com.fightfoodwaste.useraccountservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
