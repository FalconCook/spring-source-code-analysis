package com.cracker.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cracker.bean.Person;

public class IOCTest {
	
	@Test
	public void test() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

		System.out.println("容器启动完成....");
		Person bean = (Person) ioc.getBean("person01");
		System.out.print(bean);

	}

}
