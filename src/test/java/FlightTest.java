import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    LocalDateTime date;
    Pilot pilot;
    CabinCrewMember captain;
    CabinCrewMember firstOfficer;
    CabinCrewMember purser;
    CabinCrewMember attendant;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    Plane plane737;

    Flight flight;

    @BeforeEach
    void setUp() throws Exception {
        pilot = new Pilot("Florentine", CrewRank.CAPTAIN, "12345");
        captain = new CabinCrewMember("Jill", CrewRank.CAPTAIN);
        firstOfficer = new CabinCrewMember("Anne", CrewRank.FIRST_OFFICER);
        purser = new CabinCrewMember("Jack", CrewRank.PURSER);
        attendant = new CabinCrewMember("Joey", CrewRank.FLIGHT_ATTENDANT);
        passenger1 = new Passenger("Joe", 1);
        passenger2 = new Passenger("Jamie", 2);
        passenger3 = new Passenger("Julian", 1);


        plane737 = new Plane(PlaneType.BOEING737);
        date = LocalDateTime.of(2022, 9, 23, 15, 30);
        flight = new Flight(pilot, plane737, "AA123",
                "GLA", "PHL", date);
        flight.addCrewMember(firstOfficer);
        flight.addCrewMember(purser);
        flight.addCrewMember(attendant);

        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);

    }

    @Test
    void hasAtLeastOnePilot() {
        assertTrue(flight.getPilot() != null);
        assertEquals(CrewRank.CAPTAIN, flight.getPilot().getRank());
    }
    // add so that a crew is required.

    @Test
    void canAddMembersToCrew() {
        assertEquals(3, flight.crewCount());
    }

    @Test
    void canHavePassengers() {
        assertEquals(2, flight.passengerCount());
    }

    @Test
    void canAddPassengers() throws Exception {
        flight.addPassenger(passenger3);
        assertEquals(3, flight.passengerCount());
    }

    @Test
    void hasAPlane() {
        assertEquals(plane737, flight.getPlane());
    }

    @Test
    void hasFlightDetails() {
        assertEquals("AA123", flight.getFlightNumber());
        assertEquals("GLA", flight.getDestination());
        assertEquals("PHL", flight.getDepartureAirport());
        assertEquals(date, flight.getDepartureTime());
    }

    @Test
    void canReturnNumberOfAvailableSeats() {
        assertEquals(98, flight.getSeatsAvailable());
    }

    @Test
    void pilotCanFlyPlane() {
        assertEquals("Pilot is flying the plane", flight.getPilot().flyPlane(flight.getPlane()));
    }

    @Test
    void crewCanRelayMessage() {
        assertEquals("Message to passengers", flight.getCrewMember().relayMessage());
    }

    @Test
    void passengerIsAssignedTheFlightWhenAddedToPassengersList() {
        assertEquals(flight, flight.getPassenger().getFlight());
    }

    @Test
    void canGetArrayOfAllAllocatedSeats() {
        List<Integer> result = new ArrayList<>();
        result.add(passenger1.getSeat());
        result.add(passenger2.getSeat());
        assertEquals(result, flight.getAllocatedSeats());
    }

    @Test
    void canGetRandomAvailableSeat() throws Exception {
        int capacity = flight.getPlane().getCapacity();
        for (int i = 0; i < 2000; i++) {
            int randomSeat = flight.getRandomAvailableSeat();
            assertTrue(0 < randomSeat && randomSeat < capacity);
        }
    }

    @Test
    void passengerGetsRandomSeatWhenAddedToPassengersList() {
        int capacity = flight.getPlane().getCapacity();
        assertTrue(flight.getPassenger().getSeat() < capacity &&
                flight.getPassenger().getSeat() > 0);
    }
}