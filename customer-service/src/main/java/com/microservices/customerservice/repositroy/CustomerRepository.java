package com.microservices.customerservice.repositroy;

import com.microservices.customerservice.entity.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer,String> {
}
