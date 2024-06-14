/**
 *  Program 6
 *  This program is a stock broker app that allows users to create accounts, add stocks to accounts, remove stocks from accounts,
 *  update the number of shares in a stock, and remove accounts. The program uses a StockAccount class to represent accounts and a Stock 
 *  CS160-1001
 *  6/13/24
 *  @author  Jacob Archer
  */

public class Stock {
	
	private String name;
	private String ticker;
	private int numShares;
	private double currValue;
	private double totValue;
	private Finances quarFinancials;
	private Finances annFinancials;
	
	public Stock(String ticker, String name, int numShares, double currValue) {
		this.name = name;
		this.ticker = ticker;
		this.numShares = numShares;
		this.currValue = currValue;
		this.totValue = numShares * currValue;
	}
	
	public void buyShares(int shares) {
		numShares += shares;
		totValue = numShares * currValue;
	}
	
	public void sellShares(int shares) { 
		if (shares <= numShares) 
			numShares -= shares;
		totValue = numShares * currValue;
	}
	
	public void setFinancials(Finances financial, String option) {
		if (option.equals("quarter"))
			quarFinancials = financial;
		else if (option.equals("annual"))
			annFinancials = financial;
		else 
			System.out.println("Error: Wrong Option");
	}
	
	public String getFinancials(String option) {
		if (option.equals("quarter"))
		   return quarFinancials.toString();
		else if (option.equals("annual"))
			return annFinancials.toString();
		else 
			return "Error: Wrong Option";
	}
	
	public String getInfo() {
		return "Program 6, Jacob Archer";
	}
	
	public String getStockInfo() {
		return name + " (" + ticker + "); Total Shares Owned: " + numShares + "; Total Value: " +  totValue;
	}
	
	public int getShares() {
		return numShares;
	}
	
	public String getTicker() {
		return ticker;
	}
}

