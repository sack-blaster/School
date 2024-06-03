/**
 *  Program 3a
 *  This program is used to create a class that holds financial information about a stock
 *  CS160-1001
 *  6/2/24
 *  @author  Jacob Archer
  */

public class Finances {
    private double PE;
    private double EPS;
    private boolean hasDiv;

    public Finances() {
        this.PE = 0.0;
        this.EPS = 0.0;
        this.hasDiv = false;
    }

    public Finances(double PE, double EPS, boolean hasDiv) {
        this.PE = PE;
        this.EPS = EPS;
        this.hasDiv = hasDiv;
    }

    public double getPE() {
        return this.PE;
    }

    public void setPE(double PE) {
        this.PE = PE;
    }

    public double getEPS() {
        return this.EPS;
    }

    public void setEPS(double EPS) {
        this.EPS = EPS;
    }

    public boolean hasDividends() {
        return this.hasDiv;
    }

    @Override
    public String toString() {
        return "Price/Earnings: " + this.PE + "; Earnings/Share: " + this.EPS + "; Dividends: " + this.hasDiv;
    }
}