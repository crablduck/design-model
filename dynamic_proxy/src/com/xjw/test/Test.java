package com.xjw.test;

import java.lang.reflect.Proxy;

import com.xjw.service.IUserService;
import com.xjw.service.impl.UserServiceImpl;
import com.xjw.transaction.Transaction;
import com.xjw.transaction.TransactionHandle;

public class Test {

	public static void main(String[] args) {
		//创建目标对象和增强
		IUserService userServiceImpl = new UserServiceImpl();
		Transaction transaction = new Transaction();
		
		//获取类加载器， 获取接口， 获取代理对象
		ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();
		Class<?>[] interfaces = userServiceImpl.getClass().getInterfaces();
		TransactionHandle transactionHandle = new TransactionHandle(transaction, userServiceImpl);
		
		//类代理进行操作
		IUserService userServiceProxy = (IUserService)Proxy.newProxyInstance(classLoader, interfaces, transactionHandle);
		userServiceProxy.add();
		
		
	}
}
