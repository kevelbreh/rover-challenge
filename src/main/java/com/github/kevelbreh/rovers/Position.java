package com.github.kevelbreh.rovers;

public class Position {

    private final int x;
    private final int y;
    private final Compass bearing;

    Position(int x, int y, Compass bearing) {
        this.x = x;
        this.y = y;
        this.bearing = bearing;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    Compass bearing() {
        return bearing;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + bearing;
    }
}
