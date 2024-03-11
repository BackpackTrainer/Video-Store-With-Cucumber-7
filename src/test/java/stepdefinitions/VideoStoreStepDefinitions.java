package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Customer;
import model.Movie;
import model.Rental;
import org.junit.jupiter.api.Assertions;


public class VideoStoreStepDefinitions {
	Customer customer;
	double rentalAmount;

	
	@Given("I am an existing customer named {string}")
	public void i_am_an_existing_customer_named(String name) throws Throwable {
		customer = new Customer(name);
	}

	@When("I rent no movies")
	public void i_rent_no_movies() throws Throwable {	
	}
	
	@When("I rent {string} of {string} for {int}")
	public void i_rent_of_for(String movieName, String movieType, int days) throws Throwable {
		int type = Movie.getCode(movieType);
	    Rental rental = new Rental(new Movie(movieName, type), days);
	    customer.addRental(rental);
	}

	@Then("my bill is {double}")
	public void my_bill_is(double amount) throws Throwable {

		Assertions.assertEquals(amount, customer.getTotalCharges(), .01);
	}

	@Then("^I earn Frequent Renter (\\d+)$")
	public void i_earn_Frequent_Renter_Points(int points) throws Throwable {

		Assertions.assertEquals(points, customer.getFrequentRenterPoints());
	}
}
