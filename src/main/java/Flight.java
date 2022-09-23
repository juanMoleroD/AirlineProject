import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Flight {

    private Pilot pilot;
    private List<CabinCrewMember> crew;
    private List<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private LocalDateTime departureTime;

    public Flight(Pilot pilot, Plane plane, String flightNumber, String destination, String departureAirport, LocalDateTime departureTime) {
        this.pilot = pilot;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.crew = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void addCrewMember(CabinCrewMember crewMember) {
        crew.add(crewMember);
    }

    public int crewCount() {
        return crew.size();
    }

    public int passengerCount() {
        return passengers.size();
    }

    public void addPassenger(Passenger passenger) throws Exception {
        passenger.setSeat(getRandomAvailableSeat());
        passenger.setFlight(this);
        passengers.add(passenger);
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getSeatsAvailable() {
        return plane.getCapacity() - passengerCount();
    }

    public CabinCrewMember getCrewMember() {
        return crew.get(0);
    }

    public Passenger getPassenger() {
        return passengers.get(0);
    }

    public List<Integer> getAllocatedSeats() {
        return passengers.stream().map(passenger -> passenger.getSeat()).collect(Collectors.toList());
    }

    public int getRandomAvailableSeat() throws Exception {
        int capacity = getPlane().getCapacity();
        List<Integer> allocated = getAllocatedSeats();
        if (allocated.size() == capacity) throw new Exception("No more Seats available");
        Random random = new Random();
        int number = random.nextInt(1, capacity);
        while (allocated.contains(number) || allocated.size() == capacity) {
            number = random.nextInt(1, capacity);
        }
        return number;
    }

}
