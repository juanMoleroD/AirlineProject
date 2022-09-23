import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabinCrewMemberTest {

    CabinCrewMember captain = new CabinCrewMember("Jill", CrewRank.CAPTAIN);
    CabinCrewMember firstOfficer = new CabinCrewMember("Anne", CrewRank.FIRST_OFFICER);
    CabinCrewMember purser = new CabinCrewMember("Jack", CrewRank.PURSER);
    CabinCrewMember attendant = new CabinCrewMember("Joey", CrewRank.FLIGHT_ATTENDANT);

    @Test
    void hasNameAccessible() {
        assertEquals("Jill", captain.getName());
        assertEquals("Anne", firstOfficer.getName());
        assertEquals("Jack", purser.getName());
        assertEquals("Joey", attendant.getName());
    }

    @Test
    void hasRankAccessible() {
        assertEquals(CrewRank.CAPTAIN, captain.getRank());
        assertEquals(CrewRank.FIRST_OFFICER, firstOfficer.getRank());
        assertEquals(CrewRank.PURSER, purser.getRank());
        assertEquals(CrewRank.FLIGHT_ATTENDANT, attendant.getRank());

    }
}