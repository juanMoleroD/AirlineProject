import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    Pilot pilot = new Pilot("Jackie", CrewRank.CAPTAIN, "12345");

    @Test
    void hasPilotLicenseNumberAvailable() {
        assertEquals("12345", pilot.getLicence());
    }
}