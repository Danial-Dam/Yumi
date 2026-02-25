public class Trader implements Observer {

    private String name;
    private double minPriceFilter;

    public Trader(String name, double minPriceFilter) {
        this.name = name;
        this.minPriceFilter = minPriceFilter;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        if (price >= minPriceFilter) {
            System.out.println("[TRADER " + name + "] "
                    + stockSymbol + " = " + price);
        }
    }
}