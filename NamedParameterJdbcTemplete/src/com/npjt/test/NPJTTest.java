package com.npjt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npjt.beans.CustomersDao;
import com.npjt.bo.CustomersBo;

public class NPJTTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/npjt/common/application-context.xml");
		CustomersDao cdao=context.getBean("cd",CustomersDao.class);
		List<CustomersBo> customers=cdao.getAll("s");
		for (CustomersBo customersBo : customers) {
			System.out.println(customersBo);
		}
		/*CustomersBo cbo=new CustomersBo();
		cbo.setFirst_nm("sweta");
		cbo.setLast_nm("m");
		cbo.setEmail_addr("sweta@gmail.com");
		cbo.setMobile_no("9937575071");
		int irecords=cdao.insertACustomer(cbo);
		System.out.println(irecords);*/
		
	}

}
