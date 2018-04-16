package com.github.kevelbreh.rovers;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {

    private static final String WORLD_PATTERN = "^\\d+\\s+\\d$";
    private static final String LANDING_PATTERN = "^\\d+\\s+\\d+\\s+[NSEW]$";
    private static final String ORDERS_PATTERN = "^[LMR]+$";

    private OnTransportEventListener onTransportRouteListener;
    private Position roverLandingPosition = null;

    void setOnTransportRouteListener(OnTransportEventListener listener) {
        this.onTransportRouteListener = listener;
    }

    /**
     * Read data from the transport and funnel it for processing.
     */
    public abstract void read();

    /**
     *
     * @param rover which should be sent through the transport
     */
    public abstract void write(Rover rover);

    /**
     * Process a line input by matching it against predefined patterns for world composition, landing destination and
     * order line.
     *
     * @param line to be processed matching a given pattern.
     * @see #WORLD_PATTERN
     * @see #LANDING_PATTERN
     * @see #ORDERS_PATTERN
     */
    void process(String line) {
        if (line.matches(WORLD_PATTERN)) {
            String[] values = line.split("\\s");
            final int width = Integer.valueOf(values[0]);
            final int height = Integer.valueOf(values[1]);
            onTransportRouteListener.onNewWorld(new World("Unknown", width, height));
        }
        else if (line.matches(LANDING_PATTERN)) {
            String[] values = line.split("\\s");
            final int x = Integer.valueOf(values[0]);
            final int y = Integer.valueOf(values[1]);
            Compass bearing = Compass.fromAlias(values[2]);
            roverLandingPosition = new Position(x, y, bearing);
        }
        else if (line.matches(ORDERS_PATTERN)) {
            List<Order> orders = new ArrayList<>(line.length());
            for (char character : line.toCharArray()) {
                switch (character) {
                    case 'M':
                        orders.add(Order.MOVE_FORWARD);
                        break;
                    case 'R':
                        orders.add(Order.TURN_RIGHT);
                        break;
                    case 'L':
                        orders.add(Order.TURN_LEFT);
                        break;
                }
            }
            onTransportRouteListener.onNewRoverRoute(roverLandingPosition, orders);
        }
    }

    /** Event listeners for transport events **/
    public interface OnTransportEventListener {
        void onNewRoverRoute(Position position, List<Order> orders);
        void onNewWorld(World world);
    }
}
