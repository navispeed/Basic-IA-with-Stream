package eu.navispeed;

import static org.junit.Assert.*;

public class CombinaisonTest {

    Combinaison c = new Combinaison(new int[]{0, 0, 0}, 2);

    @org.junit.Test
    public void increment() {
        c.increment();
        c.increment();
        c.increment();

        assertArrayEquals(c.getC(), new int[]{0, 1, 1});
    }
}