package cn.tuyucheng.taketoday.boot.unique.field.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.boot.unique.field.data.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {
    Optional<Company> findByEmail(String email);
}
