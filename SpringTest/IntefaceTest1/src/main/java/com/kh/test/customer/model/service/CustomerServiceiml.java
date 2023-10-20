package com.kh.test.customer.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.mapper.CustomerMapper;

@Service
public class CustomerServiceiml implements CustomerService {

	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public int inputCustomer(String inputName, String inputTel, String inputAddress) {
	
		Map<String, Object> map = new HashMap<>();
		map.put("inputName", inputName);
		map.put("inputTel", inputTel);
		map.put("inputAddress", inputAddress);
		
		return mapper.inputCustomer(map);
	}
}
