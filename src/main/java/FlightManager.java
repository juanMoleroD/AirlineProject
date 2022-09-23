public class FlightManager {
    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getMaxBaggageWeightPerPassenger() {
        int weightCapacityForBaggage = flight.getPlane().getTotalWeight() / 2;
        return weightCapacityForBaggage / flight.getPlane().getCapacity();
    }

    public int getCurrentBaggageWeight() {
        return getMaxBaggageWeightPerPassenger() * flight.passengerCount();
    }

    public int getAvailableWeightForBaggage() {
        int weightCapacityForBaggage = flight.getPlane().getTotalWeight() / 2;
        return weightCapacityForBaggage - getCurrentBaggageWeight();
    }
}
