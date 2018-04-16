package com.github.kevelbreh.rovers;

import java.util.ArrayList;
import java.util.List;

public final class Houston implements Transport.OnTransportEventListener {

    private final Transport transport;
    private final List<Rover> rovers = new ArrayList<>();

    Houston(Transport transport) {
        this.transport = transport;
        this.transport.setOnTransportRouteListener(this);
    }

    @Override
    public void onNewWorld(World world) {
        // Not used in current implementation.
    }

    @Override
    public void onNewRoverRoute(Position position, List<Order> orders) {
        Rover rover = new Rover(position);
        rovers.add(rover);

        for (Order order : orders) {
            rover.perform(order);
        }
    }

    // convenience for reading from the transport and
    // then writing the result back to it.
    void start() {
        transport.read();
        for (Rover rover : rovers) {
            transport.write(rover);
        }
    }
}
