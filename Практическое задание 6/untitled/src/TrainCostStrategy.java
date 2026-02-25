public class TrainCostStrategy implements ICostCalculationStrategy {

    @Override
    public double calculateCost(TravelRequest request) {
        double baseRate = 0.2;
        double cost = request.getDistance() * baseRate;

        if (request.getServiceClass().equalsIgnoreCase("business")) {
            cost *= 1.3;
        }

        cost *= request.getPassengers();
        return cost;
    }
}