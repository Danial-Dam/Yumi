public class BusCostStrategy implements ICostCalculationStrategy {

    @Override
    public double calculateCost(TravelRequest request) {
        double baseRate = 0.1;
        double cost = request.getDistance() * baseRate;

        cost *= request.getPassengers();
        return cost;
    }
}