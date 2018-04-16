package com.github.kevelbreh.rovers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static final String TEST_INPUT = "5 5\n" +
            "1 2 N\n" +
            "LMLMLMLMM\n" +
            "3 3 E\n" +
            "MMRMMRMRRM\n";

    public static void main(String[] args) {
        InputStream stream = new ByteArrayInputStream(TEST_INPUT.getBytes(StandardCharsets.UTF_8));
        System.setIn(stream);

        Houston houston = new Houston(new StandardTransport());
        houston.start();
    }
}
