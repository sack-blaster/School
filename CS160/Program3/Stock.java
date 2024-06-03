/**
 *  Program 3a
 *  This program is used to create a class that holds financial information about a stock
 *  CS160-1001
 *  6/2/24
 *  @author  Jacob Archer
  */

public class Stock {
    private String ticker;
    private String name;
    private int numShares;
    private double currValue;
    private double totValue;
    private Finances quarFinances;
    private Finances annFinances;

    public Stock(String ticker, String name, int numShares, double currValue) {
        this.ticker = ticker;
        this.name = name;
        this.numShares = numShares;
        this.currValue = currValue;
        this.totValue = numShares * currValue;
    }

    public String getStockInfo() {
        return name + " (" + ticker + "); Total Shares Owned: " + numShares + "; Total Value: " + totValue;
    }

    public void buyShares(int shares) {
        numShares += shares;
        totValue = numShares * currValue;
    }

    public void sellShares(int shares) {
        if (shares <= numShares) {
            numShares -= shares;
            totValue = numShares * currValue;
        }
    }

    public void setFinances(Finances financial, String option) {
        if (option.equals("quarter")) {
            quarFinances = financial;
        } else if (option.equals("annual")) {
            annFinances = financial;
        } else {
            System.out.println("Error: Wrong Option");
        }
    }

    public String getFinances(String option) {
        if (option.equals("quarter")) {
            return quarFinances.toString();
        } else if (option.equals("annual")) {
            return annFinances.toString();
        } else {
            return "Error: Wrong Option";
        }
    }

    public String getInfo() {
        return "Program 3a, Jacob Archer";
      }
}
