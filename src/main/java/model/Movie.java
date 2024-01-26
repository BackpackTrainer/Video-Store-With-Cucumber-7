package model;

public class Movie {
	public static final int CHILDRENS = 1;
	public static final int REGULAR = 2;
	public static final int NEW_RELEASE = 3;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode)  {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
	
	public static int getCode(String type)  {
		int code = 0;
		if (type.equals("Regular"))
			code = Movie.REGULAR;
		if (type.equals("Childrens"))
			code =  Movie.CHILDRENS;
		if (type.equals("New Release"))
			code =  Movie.NEW_RELEASE;
		return code;
	}
}



