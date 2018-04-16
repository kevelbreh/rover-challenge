package com.github.kevelbreh.rovers;

public class World {

    private final String name;
    private final int[][] grid;

    World(String name, int width, int height) {
        this.name = name;
        this.grid = new int[width][height];
    }

    public String getName() {
        return name;
    }

    public int[][] getGrid() {
        return grid;
    }
}
