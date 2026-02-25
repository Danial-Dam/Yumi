public class TradingRobot implements Observer {

    private String name;
    private double buyThreshold;
    private double sellThreshold;

    public TradingRobot(String name, double buyThreshold, double sellThreshold) {
        this.name = name;
        this.buyThreshold = buyThreshold;
        this.sellThreshold = sellThreshold;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String stockSymbol, double price) {

        if (price <= buyThreshold) {
            System.out.println("[ROBOT " + name + "] ПОКУПКА "
                    + stockSymbol + " по " + price);
        } else if (price >= sellThreshold) {
            System.out.println("[ROBOT " + name + "] ПРОДАЖА "
                    + stockSymbol + " по " + price);
        }
    }
}