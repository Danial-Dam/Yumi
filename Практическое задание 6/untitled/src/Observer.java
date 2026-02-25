public interface Observer {
    String getName();
    void update(String stockSymbol, double price);
}