import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    Passenger passenger = new Passenger("Joe", 1);

    @Test
    void hasNameAndAccessible() {
        assertEquals("Joe", passenger.getName());
    }

    @Test
    void hasNumberOfBagsAndAccessible() {
        assertEquals(1, passenger.getNumberOfBags());
    }

    @Test
    void startsWithNoFlight() {
        assertEquals(null, passenger.getFlight());
    }

    @Test
    void startsWithSeatAs_minus1() {
        assertEquals(-1, passenger.getSeat());
    }
}