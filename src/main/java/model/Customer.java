package model;


import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;
	
	public Customer(String name)  {
		this.name = name;
		this.rentals = new java.util.ArrayList<Rental>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addRental(Rental aRental) {
		rentals.add(aRental);
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String result = "model.Rental Record for " + getName() + "\n";
		for (Rental each : rentals) {
			double thisAmount = each.getChargesFor();	
			
				frequentRenterPoints += each.getFrequentRenterPointsFor();
				
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		
		result = createFooter(totalAmount, frequentRenterPoints, result);
		return result;
	}

	private String createFooter(double totalAmount, int frequentRenterPoints, String result) {
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}
	
	public double getTotalCharges()  {
		
		double totalBill = 0;
		
		for (Rental each : rentals) {
			double thisAmount = each.getChargesFor();
			totalBill += thisAmount;
			System.out.println(each.getMovie().getTitle() + " this amount = " + thisAmount);
			}
		System.out.println("Ran getTotalCharges() " + totalBill);
		
		return totalBill;		
	}
	
	public int getFrequentRenterPoints()  {
		int frequentRenterPoints = 0;
		for (Rental each : rentals) {
			double renterPoints = each.getFrequentRenterPointsFor();
			
			frequentRenterPoints += renterPoints;
			}
		
		
		return frequentRenterPoints;
	}

}
