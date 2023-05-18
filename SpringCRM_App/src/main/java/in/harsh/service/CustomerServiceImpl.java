package in.harsh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.harsh.dao.ICustomerDao;
import in.harsh.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public List<Customer> getCustomers() {
		Iterable<Customer> customerList = customerDao.findAll();
		return (List<Customer>) customerList;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> optional = customerDao.findById(id);
		Customer customer = optional.get();
		return customer;
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDao.deleteById(id);
	}

}
