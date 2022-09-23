import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    Plane plane737 = new Plane(PlaneType.BOEING737);

    @Test
    void hasTypeAccessible() {
        assertEquals(PlaneType.BOEING737, plane737.getType());
    }

    @Test
    void hasCapacity() {
        assertEquals(100, plane737.getCapacity());
    }
    @Test
    void hasTotalWeight() {
        assertEquals(10000, plane737.getTotalWeight());
    }

}