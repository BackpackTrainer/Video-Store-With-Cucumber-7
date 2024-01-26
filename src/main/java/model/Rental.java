package model;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	double getChargesFor() {
		double charge = 0.0;
		
		//determine amounts for each line
		switch (getMovie().getPriceCode())  {
		case 2:
			charge +=2.0;
			if(getDaysRented() > 2) {
				charge +=(getDaysRented() - 2) * 1.5;
			}
			//System.out.println("Regular model.Movie");
			break;
			
		case 3:
			charge += (getDaysRented() * 3);
			//System.out.println("New Release model.Movie");
			break;
			
		case 1:
			charge += 1.5;
			if(getDaysRented() > 3) {
				charge += (getDaysRented() - 3) * 1.5;
			}
			//System.out.println("Childrens model.Movie");
			break;
		}
		return charge;
	}

	public int getFrequentRenterPointsFor() {
		
		int basePoints = 1;
		int bonusPoints = calculateBonusPoints();
		
		return (basePoints + bonusPoints);
		
	}
		
	private int calculateBonusPoints()  {
			int bonus = 0;
		
		if((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			bonus = 1;
		}
			return bonus;
	}
}
