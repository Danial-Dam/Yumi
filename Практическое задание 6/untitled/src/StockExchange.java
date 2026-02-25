import java.util.*;
import java.util.concurrent.*;

public class StockExchange implements Subject {

    private Map<String, Double> stocks = new HashMap<>();
    private Map<String, List<Observer>> subscribers = new HashMap<>();
    private Map<Observer, Integer> notificationStats = new HashMap<>();

    private ExecutorService executor = Executors.newCachedThreadPool();

    public void addStock(String symbol, double initialPrice) {
        stocks.put(symbol, initialPrice);
        subscribers.put(symbol, new ArrayList<>());
        System.out.println("[LOG] Акция " + symbol + " добавлена с ценой " + initialPrice);
    }

    @Override
    public void subscribe(String stockSymbol, Observer observer) {
        if (subscribers.containsKey(stockSymbol)) {
            subscribers.get(stockSymbol).add(observer);
            notificationStats.putIfAbsent(observer, 0);
            System.out.println("[LOG] " + observer.getName() + " подписался на " + stockSymbol);
        }
    }

    @Override
    public void unsubscribe(String stockSymbol, Observer observer) {
        if (subscribers.containsKey(stockSymbol)) {
            subscribers.get(stockSymbol).remove(observer);
            System.out.println("[LOG] " + observer.getName() + " отписался от " + stockSymbol);
        }
    }

    @Override
    public void setStockPrice(String stockSymbol, double newPrice) {
        if (!stocks.containsKey(stockSymbol)) return;

        stocks.put(stockSymbol, newPrice);
        System.out.println("\n[MARKET] " + stockSymbol + " новая цена: " + newPrice);

        for (Observer observer : subscribers.get(stockSymbol)) {
            executor.submit(() -> {
                observer.update(stockSymbol, newPrice);
                notificationStats.put(observer, notificationStats.get(observer) + 1);
            });
        }
    }

    public void generateReport() {
        System.out.println("\n===== ОТЧЕТ =====");
        for (Map.Entry<Observer, Integer> entry : notificationStats.entrySet()) {
            System.out.println(entry.getKey().getName() +
                    " получил уведомлений: " + entry.getValue());
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}