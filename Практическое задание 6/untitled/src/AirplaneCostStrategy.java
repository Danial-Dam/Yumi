public class AirplaneCostStrategy implements ICostCalculationStrategy {

    @Override
    public double calculateCost(TravelRequest request) {
        double baseRate = 0.5; // цена за км
        double cost = request.getDistance() * baseRate;

        if (request.getServiceClass().equalsIgnoreCase("business")) {
            cost *= 1.8;
        }

        if (request.hasLuggage()) {
            cost += 50;
        }

        cost *= request.getPassengers();

        return cost;
    }
}