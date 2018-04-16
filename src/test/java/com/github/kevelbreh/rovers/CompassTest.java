package com.github.kevelbreh.rovers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompassTest {

    @Test
    public void testCompassPoints() {
        assertEquals(Compass.fromAlias("N"), Compass.NORTH);
        assertEquals(Compass.fromAlias("E"), Compass.EAST);
        assertEquals(Compass.fromAlias("S"), Compass.SOUTH);
        assertEquals(Compass.fromAlias("W"), Compass.WEST);
    }

    @Test(expected = EnumConstantNotPresentException.class)
    public void testInvalidCompassPoint() {
        Compass.fromAlias("A");
    }
}
