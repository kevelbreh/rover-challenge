package com.github.kevelbreh.rovers;

import java.util.Scanner;

public class StandardTransport extends Transport {

    @Override
    public void read() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            process(scanner.nextLine());
        }
    }

    @Override
    public void write(Rover rover) {
        System.out.println(rover);
    }
}
