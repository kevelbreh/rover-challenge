package com.github.kevelbreh.rovers;

public class Rover {

    private Position position;

    Rover(Position position) {
        this.position = position;
    }

    void setPosition(Position position) {
        this.position = position;
    }

    Position getPosition() {
        return position;
    }

    void perform(Order order) {
       switch (order) {
           case TURN_LEFT:
               turnLeft();
               break;
           case MOVE_FORWARD:
               moveForward();
               break;
           case TURN_RIGHT:
               turnRight();
               break;
       }
    }

    private void moveForward() {
        switch (position.bearing()) {
            case NORTH:
                setPosition(new Position(position.x(), position.y() + 1, position.bearing()));
                break;
            case EAST:
                setPosition(new Position(position.x() + 1, position.y(), position.bearing()));
                break;
            case SOUTH:
                setPosition(new Position(position.x(), position.y() - 1, position.bearing()));
                break;
            case WEST:
                setPosition(new Position(position.x() - 1, position.y(), position.bearing()));
                break;
        }
    }

    private void turnRight() {
        int i = position.bearing().ordinal() + 1;
        if (i >= Compass.values().length) {
            i = 0;
        }
        position = new Position(position.x(), position.y(), Compass.values()[i]);
    }

    private void turnLeft() {
        int i = position.bearing().ordinal() - 1;
        if (i < 0) {
            i = Compass.values().length + i;
        }
        position = new Position(position.x(), position.y(), Compass.values()[i]);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
