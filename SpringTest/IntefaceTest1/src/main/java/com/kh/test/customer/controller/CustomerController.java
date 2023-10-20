package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("inputCustomer")
	public String inputCustomer(String inputName, String inputTel, String inputAddress, Model model ) {
		
		int result = service.inputCustomer(inputName, inputTel, inputAddress);
		
		if(result >0) {
			return "result";
		}
		return null;
	}
}
