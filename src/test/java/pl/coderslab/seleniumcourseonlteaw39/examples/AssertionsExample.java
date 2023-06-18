package pl.coderslab.seleniumcourseonlteaw39.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExample {

    @Test
    public void assertionExample() {
        // given

        // when

        // then
        assertTrue(true);
        assertFalse(false);
        assertEquals(1, 1);
        assertEquals("ala", "ala");
        double actual = 0.1 + 0.2;
        assertEquals(0.3, actual, 0.1);
        assertNull(null);
        assertNotNull(new Object());
        Object o1 = new Object();
        Object o2 = o1;
        assertSame(o1, o2);
        int[] arr1 = {1,2};
        int[] arr2 = {1,2};
        assertArrayEquals(arr1, arr2);
    }
}
