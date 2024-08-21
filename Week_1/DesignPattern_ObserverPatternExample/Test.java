package ObserverPatternExample;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Create the stock market (subject)
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price and notify observers
        stockMarket.setStockPrice(150.75);
        stockMarket.setStockPrice(155.30);

        // Deregister an observer and change stock price again
        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(160.00);
    }
}


interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}


class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void setStockPrice(double price) {
        this.stockPrice = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}


interface Observer {
    void update(double stockPrice);
}


class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("MobileApp: Stock price updated to $" + stockPrice);
    }
}


class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("WebApp: Stock price updated to $" + stockPrice);
    }
}

