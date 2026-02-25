public class TravelRequest {

    private double distance;
    private int passengers;
    private String serviceClass; // economy / business
    private boolean hasLuggage;
    private boolean isChild;
    private boolean isPensioner;

    public TravelRequest(double distance, int passengers, String serviceClass,
                         boolean hasLuggage, boolean isChild, boolean isPensioner) {
        this.distance = distance;
        this.passengers = passengers;
        this.serviceClass = serviceClass;
        this.hasLuggage = hasLuggage;
        this.isChild = isChild;
        this.isPensioner = isPensioner;
    }

    public double getDistance() { return distance; }
    public int getPassengers() { return passengers; }
    public String getServiceClass() { return serviceClass; }
    public boolean hasLuggage() { return hasLuggage; }
    public boolean isChild() { return isChild; }
    public boolean isPensioner() { return isPensioner; }
}