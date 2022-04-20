import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Vehicle vehicle;
    @BeforeEach
    void setUp() {
        vehicle = new Vehicle();
    }

    @AfterEach
    void tearDown() {
        vehicle.finalize();
    }

    @Test
    void testFinalize() {
        this.tearDown();
        assertEquals(0 ,vehicle.totalVehicle());
    }

    @Test
    void setSpeed() {
        vehicle.setSpeed(10);
        assertEquals(10, vehicle.getSpeed());
    }

    @Test
    void setDir() {
        vehicle.setDir("west");
        assertEquals("west", vehicle.getDir());
    }

    @Test
    void getSpeed() {
        this.setSpeed();
        assertEquals(10, vehicle.getSpeed());
    }

    @Test
    void getDir() {
        this.setDir();
        assertEquals("west", vehicle.getDir());
    }

    @Test
    void totalVehicle() {
        assertEquals(0 ,vehicle.totalVehicle());
    }
}