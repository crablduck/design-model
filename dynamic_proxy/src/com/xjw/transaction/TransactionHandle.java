package com.xjw.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandle implements InvocationHandler{

	private Transaction transaction;
	private Object object;
	
	public TransactionHandle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionHandle(Transaction transaction, Object object) {
		super();
		this.transaction = transaction;
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		transaction.beginTra();
		Object invoke = method.invoke(object, args);
		transaction.endTra();
		return invoke;
	}

}
