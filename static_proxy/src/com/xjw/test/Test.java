package com.xjw.test;

import com.xjw.manager.Manager;
import com.xjw.proxy.CustomerProxy;
import com.xjw.service.impl.Customer;

public class Test {
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		Customer customer = new Customer();
		CustomerProxy customerProxy = new CustomerProxy(customer, manager);
		customerProxy.bought();
	}
}
