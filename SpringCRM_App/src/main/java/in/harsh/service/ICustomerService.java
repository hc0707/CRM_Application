package in.harsh.service;

import java.util.List;

import in.harsh.model.Customer;

public interface ICustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomerById(Integer id);
	public void deleteCustomer(Integer id);
}
