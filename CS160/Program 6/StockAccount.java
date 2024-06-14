/**
 *  Program 6
 *  This program is a stock broker app that allows users to create accounts, add stocks to accounts, remove stocks from accounts,
 *  update the number of shares in a stock, and remove accounts. The program uses a StockAccount class to represent accounts and a Stock 
 *  CS160-1001
 *  6/13/24
 *  @author  Jacob Archer
  */

import java.util.ArrayList;

public interface StockAccount {
    void setName(String name);
    String getName();
    void setCategory(String category);
    String getCategory();
    int getID();
    ArrayList<Stock> getStocksOwned();
    boolean addStock(Stock stock);
    boolean removeStock(Stock stock);
}
