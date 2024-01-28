package com.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.dto.OrderRequest;
import com.db.dto.OrderResponse;
import com.db.model.Customer;
import com.db.repository.CustomerRepository;
import com.db.repository.ProductRepository;
import com.db.service.CustomerService;


@RestController
//@RequiredArgsConstructor
public class CustomerController {

	@Autowired
    private  CustomerService customerService;
	@Autowired
    private  ProductRepository productRepository;
	@Autowired
    private  CustomerRepository customertRepository;
	
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerService.saveOrder(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findOrders(){
        return customerService.findAllOrders();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerService.getJoinInformation();
    }
    
    @DeleteMapping("/delPdt/{id}")
    public void deleteProduct(@PathVariable int id)
    {
    	 productRepository.deleteById(id);
    }
    
    @DeleteMapping("/delCust/{id}")
    public void deleteCustomer(@PathVariable int id)
    {
    	//deletes associated product first then it deletes the customer
    	customertRepository.deleteById(id);
    }
}
