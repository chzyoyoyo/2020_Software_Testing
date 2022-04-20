import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedQueueTest {

    BoundedQueue BQueue;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        BQueue = new BoundedQueue(3);
    }

    // 2 Tests for Iterator method hasNext()
    // The characteristics associated with BooundedQueue() are: C1

    // Test 1 of BooundedQueue(): BooundedQueue_BaseCase():  C1-T
    @Test
    void BooundedQueue_BaseCase()
    {
        BQueue = new BoundedQueue(2);
        BQueue.enQueue(1);
        BQueue.enQueue(2);
        assertTrue(BQueue.isFull());
    }

    // Test 2 of BooundedQueue(): BooundedQueue_C1(): C1-F
    @Test
    void BooundedQueue_C1()
    {
        Exception exception0 = assertThrows(IllegalArgumentException.class, ()->{
            BQueue = new BoundedQueue(-1);
        });
    }


    //////////////////////////////////////////////////////////////////////////////
    // 3 Tests for Iterator method enQueue()
    //  The 2 characteristics associated with enQueue() are: C2, C5

    // Test 1 of enQueue(): enQueue_BaseCase():  C2-T, C5-T
    @Test
    void enQueue_BaseCase()
    {
        BQueue.enQueue(1);
        BQueue.enQueue(2);
        BQueue.enQueue(3);
        assertTrue(BQueue.isFull());
    }

    // Test 2 of enQueue(): enQueue_C1(): C2-F, C5-T
    @Test
    void enQueue_C2()
    {
        BQueue.enQueue(1);
        BQueue.enQueue(2);
        BQueue.enQueue(3);
        Exception exception1 = assertThrows(NullPointerException.class, () -> {
            BQueue.enQueue(null);
        });

    }

    // Test 3 of enQueue(): enQueue_C1(): C2-T, C5-F
    @Test
    void enQueue_C5()
    {
        BQueue.enQueue(1);
        assertFalse(BQueue.isFull());
    }

    ///////////////////////////////////////////////////////////////////////////////
    // 3 Tests for Iterator method enQueue()
    //  The 2 characteristics associated with enQueue() are: C3, C4

    // Test 1 of enQueue(): deQueue_BaseCase():  C3-T, C4-T
    @Test
    void deQueue_BaseCase()
    {
        BQueue.enQueue(1);
        BQueue.deQueue();
        assertTrue(BQueue.isEmpty());
    }

    // Test 2 of enQueue(): deQueue_C1(): C3-F, C4-T
    @Test
    void deQueue_C3()
    {
        assertTrue(BQueue.isEmpty());
        Exception exception2 = assertThrows(IllegalStateException.class, () -> {
            BQueue.deQueue();
        });
    }

    // Test 3 of enQueue(): deQueue_C1(): C3-T, C4-F
    @Test
    void deQueue_C4()
    {
        BQueue.enQueue(1);
        BQueue.enQueue(2);
        assertEquals(1, BQueue.deQueue());
        assertFalse(BQueue.isEmpty());
    }

    ////////////////////////////////////////////////////////////////////////////////

    // 2 Tests for Iterator method hasNext()
    // The characteristics associated with isEmpty() are: C4

    // Test 1 of isEmpty(): isEmpty_BaseCase():  C4-T
    @Test
    void isEmpty_BaseCase()
    {
        assertTrue(BQueue.isEmpty());
    }

    // Test 2 of isEmpty(): isEmpty_C4(): C4-F
    @Test
    void isEmpty_C4()
    {
        BQueue.enQueue(2);
        assertFalse(BQueue.isEmpty());
    }
////////////////////////////////////////////////////////////////////////////////

    // 2 Tests for Iterator method hasNext()
    // The characteristics associated with isFull() are: C5

    // Test 1 of isFull(): isFull_BaseCase():  C5-T
    @Test
    void isFull_BaseCase()
    {
        BQueue.enQueue(1);
        BQueue.enQueue(2);
        BQueue.enQueue(3);
        assertTrue(BQueue.isFull());
    }

    // Test 2 of isEmpty(): isEmpty_C4(): C4-F
    @Test
    void isFull_C5()
    {
        assertFalse(BQueue.isFull());
    }

}