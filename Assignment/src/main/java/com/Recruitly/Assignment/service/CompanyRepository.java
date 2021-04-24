package com.Recruitly.Assignment.service;

import com.Recruitly.Assignment.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,Integer> {
}
