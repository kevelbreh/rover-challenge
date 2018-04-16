package com.github.kevelbreh.rovers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TransportTest {

    @Mock Transport.OnTransportEventListener listener;

    @Before
    public void beforeEachTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcess() {
        TestTransport transport = new TestTransport();
        transport.setOnTransportRouteListener(listener);
        transport.testProcess("5 5");
        transport.testProcess("1 2 N");
        transport.testProcess("LMLMLMLMM");
        transport.testProcess("3 3 E");
        transport.testProcess("MMRMMRMRRM");

        verify(listener, atLeastOnce()).onNewWorld(any(World.class));
        verify(listener, times(2)).onNewRoverRoute(any(Position.class), anyList());
    }

    private final class TestTransport extends Transport {

        public void testProcess(String line) {
            process(line);
        }

        @Override
        public void read() { }

        @Override
        public void write(Rover rover) { }
    }
}
