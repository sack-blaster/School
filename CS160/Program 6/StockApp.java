/**
 *  Program 6
 *  This program is a stock broker app that allows users to create accounts, add stocks to accounts, remove stocks from accounts,
 *  update the number of shares in a stock, and remove accounts. The program uses a StockAccount class to represent accounts and a Stock 
 *  CS160-1001
 *  6/13/24
 *  @author  Jacob Archer
  */

import java.util.ArrayList;
import java.util.Scanner;

public class StockApp {
    public static int totalAccounts = 0;
    private static ArrayList<StockAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stock Broker App!");

        while (true) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Select the account type: \n1. Institutional\n2. Retail");
                    int accountType = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    if (accountType == 1) {
                        System.out.println("Enter the institution's name: ");
                        String institutionName = scanner.nextLine();
                        System.out.println("Enter the manager's name: ");
                        String managerName = scanner.nextLine();
                        Institutional institutionalAccount = new Institutional(managerName, institutionName);
                        accounts.add(institutionalAccount);
                    } else if (accountType == 2) {
                        System.out.println("Enter your name: ");
                        String retailName = scanner.nextLine();
                        Retail retailAccount = new Retail(retailName);
                        accounts.add(retailAccount);
                    } else {
                        System.out.println("Invalid. Returning to main menu.");
                    }
                    break;
                case 2:
                    System.out.println("Enter your account ID: ");
                    int removeID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    accounts.removeIf(account -> account.getID() == removeID);
                    break;
                case 3:
                    System.out.println("Enter your account ID: ");
                    int accountID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    StockAccount account = findAccountByID(accountID);
                    if (account == null) {
                        System.out.println("No account with given ID exists.");
                        break;
                    }

                    System.out.println("Enter the name: ");
                    String stockName = scanner.nextLine();
                    System.out.println("Enter the ticker: ");
                    String ticker = scanner.nextLine();
                    System.out.println("Enter number of shares: ");
                    int numShares = scanner.nextInt();
                    System.out.println("Enter current value: ");
                    double currValue = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Stock newStock = new Stock(ticker, stockName, numShares, currValue);
                    boolean stockAdded = account.addStock(newStock);
                    if (stockAdded) {
                        System.out.println("Stock added successfully.");
                    } else {
                        System.out.println("Stock already exists.");
                    }
                    break;
                case 4:
                    System.out.println("Enter your account ID: ");
                    int removeStockID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    StockAccount acc = findAccountByID(removeStockID);
                    if (acc == null) {
                        System.out.println("No account with given ID exists.");
                        break;
                    }

                    System.out.println("Enter the ticker: ");
                    String stockTicker = scanner.nextLine();

                    Stock stockToRemove = findStockByTicker(acc, stockTicker);
                    if (stockToRemove == null) {
                        System.out.println("Ticker does not exist");
                    } else {
                        boolean stockRemoved = acc.removeStock(stockToRemove);
                        if (stockRemoved) {
                            System.out.println("Stock removed successfully.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter your account ID: ");
                    int updateStockID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    StockAccount accountToUpdate = findAccountByID(updateStockID);
                    if (accountToUpdate == null) {
                        System.out.println("No account with given ID exists.");
                        break;
                    }

                    System.out.println("Enter the ticker: ");
                    String tickerToUpdate = scanner.nextLine();
                    Stock stockToUpdate = findStockByTicker(accountToUpdate, tickerToUpdate);
                    if (stockToUpdate == null) {
                        System.out.println("Ticker does not exist");
                        break;
                    }

                    System.out.println("1. Buy shares\n2. Sell shares");
                    int action = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    if (action == 1) {
                        System.out.println("Enter number of shares to buy:");
                        int sharesToBuy = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        stockToUpdate.buyShares(sharesToBuy);
                    } else if (action == 2) {
                        System.out.println("Enter number of shares to sell:");
                        int sharesToSell = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        stockToUpdate.sellShares(sharesToSell);
                    } else {
                        System.out.println("Invalid option entered.");
                    }
                    break;
                case 0:
                    System.out.println("Thanks for using Stock App. Exiting!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option entered.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Create a new account.");
        System.out.println("2. Remove an existing account.");
        System.out.println("3. Add a new stock to an existing account.");
        System.out.println("4. Remove an existing stock from an account.");
        System.out.println("5. Update number of shares in a stock for an account");
        System.out.println("0. Exit");
    }

    private static StockAccount findAccountByID(int id) {
        for (StockAccount account : accounts) {
            if (account.getID() == id) {
                return account;
            }
        }
        return null;
    }

    private static Stock findStockByTicker(StockAccount account, String ticker) {
        for (Stock stock : account.getStocksOwned()) {
            if (stock.getTicker().equals(ticker)) {
                return stock;
            }
        }
        return null;
    }
}
