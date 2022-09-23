import java.util.ArrayList;
import java.util.List;

public class Flight {

    private Pilot pilot;
    private List<CabinCrewMember> crew;
    private List<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;

    public Flight(Pilot pilot, Plane plane, String flightNumber, String destination, String departureAirport, String departureTime) {
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

    public void addPassenger(Passenger passenger) {
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

    public String getDepartureTime() {
        return departureTime;
    }
    public int getSeatsAvailable() {
        return plane.getCapacity() - passengerCount();
    }

    public CabinCrewMember getCrewMember() {
        return crew.get(0);
    }
}
