public class Passenger {
    private String name;
    private int numberOfBags;
    private Flight flight;
    private int seat;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.seat = -1;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
