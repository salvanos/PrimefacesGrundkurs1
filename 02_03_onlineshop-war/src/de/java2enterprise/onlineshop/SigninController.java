package de.java2enterprise.onlineshop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.java2enterprise.onlineshop.model.Customer;

@Named
@SessionScoped
public class SigninController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
