package in.harsh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.harsh.model.Customer;
import in.harsh.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CRMController {
	@Autowired
	private ICustomerService service;
	
	@GetMapping(value = "/list")
	public String listCustomers(Map<String, Object> model) {
		List<Customer> customerList = service.getCustomers();
		model.put("customers", customerList);
		return "list-customers";
	}
	
	@GetMapping(value = "/showForm")
	public String showCustomerForm(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer-form";
	}
	
	@PostMapping(value = "/saveCustomer")
	public String saveCustomer(Map<String, Object> model,@ModelAttribute("customer")Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping(value = "/showFormForUpdate")
	public String showUpdateForm(Map<String, Object> model,@RequestParam Integer customerId) {
		Customer customer = service.getCustomerById(customerId);
		model.put("customer", customer);
		return "customer-form";
	}
	
	@GetMapping(value = "/delete")
	public String showDeleteForm(Map<String, Object> model,@RequestParam Integer customerId) {
		service.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
}
