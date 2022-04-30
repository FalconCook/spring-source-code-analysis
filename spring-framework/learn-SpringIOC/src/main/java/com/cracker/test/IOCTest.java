package com.cracker.test;

import com.cracker.app.AppConfig;
import com.cracker.bean.IndexDao;
import com.cracker.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	
	@Test
	public void test() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

		System.out.println("容器启动完成....");
		Person bean = (Person) ioc.getBean("person01");
		System.out.print(bean);

	}

	@Test
	public void test2() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		IndexDao dao = annotationConfigApplicationContext.getBean(IndexDao.class);
		dao.query();
	}
}
