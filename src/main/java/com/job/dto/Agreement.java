package com.job.dto;

import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.apache.commons.validator.GenericValidator;

public class Agreement {
	
	static Logger logger = Logger.getLogger(Agreement.class.getName());
	
	/**
	 * string that has the agreement name that it generates by rule "Agreement " + current date in format day/month/year.
	 */
	private String name;
	
	/**
	 * by - string with name of person who signed an agreement.
	 */
	private String signed;
	
	/**
	 *  - collection of products that are included into this agreement. 
				This collection should be having only products that are directly under agreement.
				Products that have parent product shouldn't be in this collection.
	 */
	private List<Product> products;

	public Agreement() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSigned() {
		return signed;
	}

	public void setSigned(String signed) {
		this.signed = signed;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Agreement [name=" + name + ", signed=" + signed + ", products=" + products + "]";
	}
	
	public static boolean validateAgreement(Agreement agreement) throws Exception{
		logger.info("validateAgreement() called with name: "+agreement.getName());
		return validateName(agreement.getName())&&validateProducts(agreement.getProducts());
	}

	private static boolean validateName(String name) {
		// TODO Auto-generated method stub
		StringTokenizer stk = new StringTokenizer(name, " ");
		return stk.nextToken().equals("Agreement")&&GenericValidator.isDate(stk.nextToken(), "dd/MM/yyyy", true);
	}
	
	private static boolean validateProducts(List<Product> products) {
		// TODO Auto-generated method stub
		for (Product product : products) {
			if(product.getObject()!=null)
				return false;
		}
		return true;
	}
	

}
