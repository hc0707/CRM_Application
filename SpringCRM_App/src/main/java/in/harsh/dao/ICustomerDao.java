package in.harsh.dao;

import org.springframework.data.repository.CrudRepository;

import in.harsh.model.Customer;

public interface ICustomerDao extends CrudRepository<Customer, Integer> {

}
