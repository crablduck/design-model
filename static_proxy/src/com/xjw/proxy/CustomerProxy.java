package com.xjw.proxy;

import com.xjw.manager.Manager;
import com.xjw.service.ICustomer;
import com.xjw.service.impl.Customer;

public class CustomerProxy implements ICustomer{

	private Customer customer;
	private Manager manager;
	
	public CustomerProxy() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerProxy(Customer customer, Manager manager){
		this.customer = customer;
		this.manager = manager;
	}
	
	@Override
	public void bought() {
		// TODO Auto-generated method stub
		manager.beginTransaction();
		customer.bought();
		manager.endTransaction();
	}

}
