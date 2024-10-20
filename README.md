# Stock Trading Platform

### Author Information
- **Name**: Lokesh Krishna R
- **Company**: CodeAlpha
- **ID**: CA/O3/42169
- **Domain**: Java Programming
- **Duration**: October 1 to 30

---

## Table of Contents
- [Features](#features)
- [How to Run](#how-to-run)
- [Code Explanation](#code-explanation)
- [Example Output](#example-output)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Market Management**: A set of predefined stocks (e.g., AAPL, GOOGL, AMZN) with their prices.
- **Portfolio Management**: Ability to buy and sell stocks, track holdings, and monitor balance.
- **Stock Updates**: Prices are updated when stocks are bought or sold.
- **Display Stocks**: Shows the list of available stocks and their prices.
- **Balance Tracking**: Keeps track of the user's available balance.

## How to Run

1. Ensure you have Java installed by running:
   ```bash
   java -version
   ```
2. Clone this repository:
   ```bash
   git clone https://github.com/your-username/stock-trading-platform.git
   ```
3. Navigate to the project directory:
   ```bash
   cd stock-trading-platform
   ```
4. Compile the program:
   ```bash
   javac StockTradingPlatform.java
   ```
5. Run the program:
   ```bash
   java StockTradingPlatform
   ```

## Code Explanation

### 1. **Stock Class**
The `Stock` class represents individual stocks with two attributes: `symbol` and `price`. It provides methods to retrieve and update these values.

```java
class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) { ... }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
```

### 2. **Market Class**
The `Market` class maintains a collection of stocks. It allows adding new stocks, updating prices, and displaying the available stocks.

```java
class Market {
    private Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) { ... }
    public Stock getStock(String symbol) { ... }
    public void updatePrice(String symbol, double price) { ... }
    public void displayStocks() { ... }
}
```

### 3. **Portfolio Class**
The `Portfolio` class holds the user's stock investments and available balance. It supports buying and selling stocks and displays current holdings.

```java
class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private double balance;

    public Portfolio(double balance) { ... }
    public void buyStock(String symbol, int quantity, double price) { ... }
    public void sellStock(String symbol, int quantity, double price) { ... }
    public void displayPortfolio() { ... }
}
```

### 4. **TradingEngine Class**
This class facilitates stock transactions between the user's portfolio and the market.

```java
class TradingEngine {
    private Market market;
    private Portfolio portfolio;

    public TradingEngine(Market market, Portfolio portfolio) { ... }
    public void buyStock(String symbol, int quantity) { ... }
    public void sellStock(String symbol, int quantity) { ... }
}
```

### 5. **StockTradingPlatform (Main Class)**
The `StockTradingPlatform` class is the entry point, offering a console-based menu for users to interact with the program.

```java
public class StockTradingPlatform {
    public static void main(String[] args) { ... }
}
```

## Example Output

```
Menu: 1) Buy 2) Sell 3) Market 4) Portfolio 5) Exit
1
Enter stock symbol to buy: AAPL
Enter quantity: 10
Bought 10 shares of AAPL

Menu: 1) Buy 2) Sell 3) Market 4) Portfolio 5) Exit
3
Market Stocks:
AAPL: $150.0
GOOGL: $2800.0
AMZN: $3400.0

Menu: 1) Buy 2) Sell 3) Market 4) Portfolio 5) Exit
4
Balance: $8500.0
Portfolio Holdings:
AAPL: 10 shares
```

## Contributing

If you'd like to contribute to this project, feel free to submit a pull request or open an issue.

## License

This project is open-source and available under the [MIT License](LICENSE).
