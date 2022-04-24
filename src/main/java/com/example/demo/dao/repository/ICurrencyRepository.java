package com.example.demo.dao.repository;

import com.example.demo.dao.entity.CurrencyRepositoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends CrudRepository<CurrencyRepositoryEntity, String> {

}
