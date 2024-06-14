/**
 *  Program 6
 *  This program is a stock broker app that allows users to create accounts, add stocks to accounts, remove stocks from accounts,
 *  update the number of shares in a stock, and remove accounts. The program uses a StockAccount class to represent accounts and a Stock 
 *  CS160-1001
 *  6/13/24
 *  @author  Jacob Archer
  */
  
public class Finances {
	double PE;
	double EPS;
	boolean hasDiv;
	
	public Finances() {
		PE = 0.0;
		EPS = 0.0;
		hasDiv = false;
	}
	
	public Finances(double PE, double EPS, boolean hasDiv) {
		this.PE = PE;
		this.EPS = EPS;
		this.hasDiv = hasDiv;
	}

	public double getPE() {
		return PE;
	}

	public void setPE(double pE) {
		PE = pE;
	}

	public double getEPS() {
		return EPS;
	}

	public void setEPS(double ePS) {
		EPS = ePS;
	}

	public boolean hasDividends() {
		return this.hasDiv;
	}
	
	@Override
	public String toString() {
		return "Price/Earnings: " + PE + "; Earnings/Share: "  + EPS + "; Dividends: " + hasDiv;
	}
	
	
}
