package com.jqb.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jqb.beans.CustomerBo;
import com.jqb.beans.CustomerJobSheetBo;
import com.jqb.beans.CustomersDelegate;
import com.jqb.beans.JobsheetBo;

public class CDTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/jqb/common/application-context.xml");
		CustomersDelegate delegate=context.getBean("cd", CustomersDelegate.class);
		/*CustomerBo cbo=delegate.getCustomerByMobileNo("7683982270");
		System.out.println(cbo);*/
		/*List<CustomerBo> customers=delegate.getAll();
		for (CustomerBo customerBo : customers) {
			System.out.println(customerBo);
		}*/ 
		/*List<CustomerJobSheetBo> jbs=delegate.getAllRecords();
		for (CustomerJobSheetBo customerJobSheetBo : jbs) {
			System.out.println(customerJobSheetBo.getCustomer().getFirst_nm());
			for (JobsheetBo jobSheetBo : customerJobSheetBo.getJobsheets()) {
				System.out.println(jobSheetBo);
				
			}
		}*/
		List<JobsheetBo> jobsheets=delegate.getAll(2, 1);
		for (JobsheetBo jobsheetBo : jobsheets) {
			System.out.println(jobsheetBo);
		}
		/*CustomerBo cbo=new CustomerBo();
		cbo.setFirst_nm("beauty");
		cbo.setLast_nm("bm");
		cbo.setEmail_addr("beauty@gmail.com");
		cbo.setMobile_no("9937575071");
		Object keys=delegate.inset_getKeys(cbo);
		System.out.println("keys :"+keys);*/
		/*int nor=delegate.insertRecords();
		System.out.println(nor);*/
		

	}

}
