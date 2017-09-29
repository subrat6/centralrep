package com.don.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.don.beans.LoanPlaner;

public class DONTest {

	public static void main(String[] args) throws Exception {
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("com/don/common/application-context.xml"));
		LoanPlaner lplaner=factory.getBean("loanPlaner",LoanPlaner.class);
		lplaner.getTotalRate(1000, 20, "kolkata");
		
		
	}

}
