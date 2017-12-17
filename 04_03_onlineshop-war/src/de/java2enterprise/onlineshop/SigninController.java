package de.java2enterprise.onlineshop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import de.java2enterprise.onlineshop.model.Customer;

@Named
@SessionScoped
public class SigninController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Customer customer;
	
	private String signedIn;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getSignedIn() {
		return signedIn;
	}

	public void setSignedIn(String signedIn) {
		this.signedIn = signedIn;
	}
	
	public void showCustomer() {
		RequestContext.getCurrentInstance().openDialog("customer");
	}

	public void signout() {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.invalidateSession();
		
		FacesMessage m =
				new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Gratulation!",
					"Sie haben sich abgemeldet!");
		
		RequestContext.getCurrentInstance().showMessageInDialog(m);
	}
	
	public void find() {
		if( 
				customer != null && 
				customer.getEmail() != null &&
				customer.getPassword() != null &&
				customer.getEmail().equals("admin") &&
				customer.getPassword().equals("admin")) {
			FacesMessage m =
					new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Erfolgreich angemeldet!",
							"Sie haben sich erfolgreich angemeldet!");
			FacesContext
				.getCurrentInstance()
				.addMessage(null, m);
			
			signedIn = "Angemeldet!";
		} else {
			signedIn = "Nicht angemeldet!";
		}
	}

}
