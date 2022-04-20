import static org.junit.Assert.*;

public class CalTest {

    Cal cal;
    @org.junit.Before
    public void setUp() throws Exception {
        cal = new Cal();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void cal() {
        int T =  cal.cal(10, 1, 11, 30, 2020);
        assertEquals(T, 60);

        T =  cal.cal(11, 30, 10, 1, 2020);
        assertEquals(T, 1);

        T =  cal.cal(1, 30, 12, 25, 2020);
        assertEquals(T, 330);

        T =  cal.cal(12, 30, 12, 25, 2020);
        assertEquals(T, -5);

        T =  cal.cal(1, 30, 12, 25, 2000);
        assertEquals(T, 330);

        T =  cal.cal(1, 30, 12, 25, 1900);
        assertEquals(T, 329);

        T =  cal.cal(1, 30, 12, 25, -3);
        assertEquals(T, 329);

        T =  cal.cal(1, 30, 12, 25, -16);
        assertEquals(T, 330);

        T =  cal.cal(1, 30, 12, 25, -500);
        assertEquals(T, 329);

        T =  cal.cal(1, 30, 12, 25, 1995);
        assertEquals(T, 329);

        T =  cal.cal(1, 20, 1, 20, 2020);
        assertEquals(T, 0);

    }

}