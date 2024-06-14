/**
 *  Program 6
 *  This program is a stock broker app that allows users to create accounts, add stocks to accounts, remove stocks from accounts,
 *  update the number of shares in a stock, and remove accounts. The program uses a StockAccount class to represent accounts and a Stock 
 *  CS160-1001
 *  6/13/24
 *  @author  Jacob Archer
  */

import java.util.ArrayList;

public class Institutional implements StockAccount {
    private int ID;
    private String manager;
    private String name;
    private String category;
    private ArrayList<Stock> stocksOwned;

    public Institutional() {
        this.ID = StockApp.totalAccounts++;
        this.manager = "Manager" + ID;
        this.name = "Institutional" + ID;
        this.category = "Institutional";
        this.stocksOwned = new ArrayList<>();
    }

    public Institutional(String manager, String name) {
        this.ID = StockApp.totalAccounts++;
        this.manager = manager;
        this.name = name;
        this.category = "Institutional";
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
