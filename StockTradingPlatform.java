import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
+
class Market {
    private Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) { stocks.put(stock.getSymbol(), stock); }
    public Stock getStock(String symbol) { return stocks.get(symbol); }

    public void updatePrice(String symbol, double price) {
        Stock stock = stocks.get(symbol);
        if (stock != null) stock.setPrice(price);
    }

    public void displayStocks() {
        System.out.println("Market Stocks:");
        for (Stock stock : stocks.values()) {
            System.out.println(stock.getSymbol() + ": $" + stock.getPrice());
        }
    }
}

class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private double balance;

    public Portfolio(double balance) { this.balance = balance; }

    public double getBalance() { return balance; }

    public void buyStock(String symbol, int quantity, double price) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
        balance -= price * quantity;
    }

    public void sellStock(String symbol, int quantity, double price) {
        if (holdings.containsKey(symbol) && holdings.get(symbol) >= quantity) {
            holdings.put(symbol, holdings.get(symbol) - quantity);
            balance += price * quantity;
        } else {
            System.out.println("Insufficient shares to sell.");
        }
    }

    public void displayPortfolio() {
        System.out.println("Balance: $" + balance);
        System.out.println("Portfolio Holdings:");
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
        }
    }
}

class TradingEngine {
    private Market market;
    private Portfolio portfolio;

    public TradingEngine(Market market, Portfolio portfolio) {
        this.market = market;
        this.portfolio = portfolio;
    }

    public void buyStock(String symbol, int quantity) {
        Stock stock = market.getStock(symbol);
        if (stock != null) {
            portfolio.buyStock(symbol, quantity, stock.getPrice());
            System.out.println("Bought " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Stock not found.");
        }
    }

    public void sellStock(String symbol, int quantity) {
        Stock stock = market.getStock(symbol);
        if (stock != null) {
            portfolio.sellStock(symbol, quantity, stock.getPrice());
            System.out.println("Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Stock not found.");
        }
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Market market = new Market();
        market.addStock(new Stock("AAPL", 150.0));
        market.addStock(new Stock("GOOGL", 2800.0));
        market.addStock(new Stock("AMZN", 3400.0));

        Portfolio portfolio = new Portfolio(10000.0);
        TradingEngine engine = new TradingEngine(market, portfolio);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu: 1) Buy 2) Sell 3) Market 4) Portfolio 5) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();
                    engine.buyStock(buySymbol, buyQuantity);
                    break;

                case 2:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    engine.sellStock(sellSymbol, sellQuantity);
                    break;

                case 3:
                    market.displayStocks();
                    break;

                case 4:
                    portfolio.displayPortfolio();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}

