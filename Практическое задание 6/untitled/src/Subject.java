public interface Subject {
    void subscribe(String stockSymbol, Observer observer);
    void unsubscribe(String stockSymbol, Observer observer);
    void setStockPrice(String stockSymbol, double newPrice);
}