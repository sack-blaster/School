/**
 *  Program 6
 *  This program is a stock broker app that allows users to create accounts, add stocks to accounts, remove stocks from accounts,
 *  update the number of shares in a stock, and remove accounts. The program uses a StockAccount class to represent accounts and a Stock 
 *  CS160-1001
 *  6/13/24
 *  @author  Jacob Archer
  */

import java.util.ArrayList;

public class Retail implements StockAccount {
    private int ID;
    private String name;
    private String category;
    private ArrayList<Stock> stocksOwned;

    public Retail() {
        this.ID = StockApp.totalAccounts++;
        this.name = "Retail" + ID;
        this.category = "Retail";
        this.stocksOwned = new ArrayList<>();
    }

    public Retail(String name) {
        this.ID = StockApp.totalAccounts++;
        this.name = name;
        this.category = "Retail";
        this.stocksOwned = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public ArrayList<Stock> getStocksOwned() {
        return stocksOwned;
    }

    @Override
    public boolean addStock(Stock stock) {
        if (stocksOwned.size() >= 10) {
            return false;
        }
        for (Stock s : stocksOwned) {
            if (s.getTicker().equals(stock.getTicker())) {
                return false;
            }
        }
        stocksOwned.add(stock);
        return true;
    }

    @Override
    public boolean removeStock(Stock stock) {
        if (stock.getShares() == 0) {
            return stocksOwned.remove(stock);
        }
        return false;
    }
}
