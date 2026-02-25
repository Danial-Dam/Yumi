public class TravelBookingContext {

    private ICostCalculationStrategy strategy;

    public void setStrategy(ICostCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(TravelRequest request) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not selected!");
        }
        return strategy.calculateCost(request);
    }
}