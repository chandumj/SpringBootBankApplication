package com.sathyabank.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sathyabank.model.SathyaBankDatabase;
@Repository
public interface BankRepo extends CrudRepository<SathyaBankDatabase, Long> {

}
