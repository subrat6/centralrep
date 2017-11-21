package com.msas.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msas.bo.CustomersBo;
import com.msas.dao.CustomersDao;



public class NPJTTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/msas/common/application-context.xml");
		CustomersDao cdao=context.getBean("cd", CustomersDao.class);
		CustomersBo cbo=new CustomersBo();
		cbo.setFirst_nm("sweta");
		cbo.setLast_nm("m");
		cbo.setEmail_addr("sweta@gmail.com");
		cbo.setMobile_no("9937575071");
		int irecords=cdao.save(cbo);
		System.out.println(irecords);
		
	}

}
