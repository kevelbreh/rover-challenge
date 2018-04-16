package com.github.kevelbreh.rovers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    private Position origin;

    @Before
    public void beforeEachTest() {
        origin = new Position(0, 0, Compass.NORTH);
    }

    @Test
    public void testMoveForward() {
        Rover rover = new Rover(origin);
        rover.perform(Order.MOVE_FORWARD);
        assertEquals(1, rover.getPosition().y());
        assertEquals(0, rover.getPosition().x());

        rover.perform(Order.TURN_RIGHT);
        rover.perform(Order.MOVE_FORWARD);
        assertEquals(1, rover.getPosition().y());
        assertEquals(1, rover.getPosition().x());
    }

    @Test
    public void testRotations() {
        Rover rover = new Rover(origin);
        assertEquals(Compass.NORTH, rover.getPosition().bearing());
        rover.perform(Order.TURN_RIGHT);
        assertEquals(Compass.EAST, rover.getPosition().bearing());
        rover.perform(Order.TURN_RIGHT);
        assertEquals(Compass.SOUTH, rover.getPosition().bearing());
        rover.perform(Order.TURN_RIGHT);
        assertEquals(Compass.WEST, rover.getPosition().bearing());
        rover.perform(Order.TURN_RIGHT);
        assertEquals(Compass.NORTH, rover.getPosition().bearing());

        rover = new Rover(origin);
        assertEquals(Compass.NORTH, rover.getPosition().bearing());
        rover.perform(Order.TURN_LEFT);
        assertEquals(Compass.WEST, rover.getPosition().bearing());
        rover.perform(Order.TURN_LEFT);
        assertEquals(Compass.SOUTH, rover.getPosition().bearing());
        rover.perform(Order.TURN_LEFT);
        assertEquals(Compass.EAST, rover.getPosition().bearing());
        rover.perform(Order.TURN_LEFT);
        assertEquals(Compass.NORTH, rover.getPosition().bearing());
    }

    @Test
    public void testSampleInput() {
        Rover rover = new Rover(new Position(1,2,Compass.NORTH));
        rover.perform(Order.TURN_LEFT);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.TURN_LEFT);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.TURN_LEFT);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.TURN_LEFT);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.MOVE_FORWARD);
        assertEquals(1, rover.getPosition().x(), 1);
        assertEquals(3, rover.getPosition().y(), 3);
        assertEquals(Compass.NORTH, rover.getPosition().bearing());

        rover = new Rover(new Position(3,3,Compass.EAST));
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.TURN_RIGHT);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.TURN_RIGHT);
        rover.perform(Order.MOVE_FORWARD);
        rover.perform(Order.TURN_RIGHT);
        rover.perform(Order.TURN_RIGHT);
        rover.perform(Order.MOVE_FORWARD);
        assertEquals(5, rover.getPosition().x());
        assertEquals(1, rover.getPosition().y());
        assertEquals(Compass.EAST, rover.getPosition().bearing());
    }
}
