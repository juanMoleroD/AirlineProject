import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {

    Pilot pilot;
    CabinCrewMember attendant;
    Passenger passenger1;
    Passenger passenger2;
    Plane plane737;
    Flight flight;
    FlightManager manager;

    @BeforeEach
    void setUp() {
        LocalDateTime date = LocalDateTime.of(2022, 9, 23, 15,30);

        pilot = new Pilot("Florentine", CrewRank.CAPTAIN, "12345");
        attendant = new CabinCrewMember("Joey", CrewRank.FLIGHT_ATTENDANT);
        passenger1 = new Passenger("Joe", 1);
        passenger2 = new Passenger("Jamie", 2);
        plane737 = new Plane(PlaneType.BOEING737);
        flight = new Flight(pilot, plane737, "AA123",
                "GLA", "PHL", date);
        flight.addCrewMember(attendant);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        manager = new FlightManager(flight);
    }

    @Test
    void hasFlightToManager() {
        assertEquals(flight, manager.getFlight());
    }

    @Test
    void calculatesMaxBaggageWeightPerPassenger() {
        assertEquals(50, manager.getMaxBaggageWeightPerPassenger());
    }

    @Test
    void calculatesCurrentTotalBaggageWeightWithConfirmedPassengers() {
        assertEquals(100, manager.getCurrentBaggageWeight());
    }

    @Test
    void calculatesRemainingBaggageWeightOnPlane() {
        assertEquals(4900, manager.getAvailableWeightForBaggage());
    }
}