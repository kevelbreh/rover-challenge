package com.github.kevelbreh.rovers;

public enum Compass {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String alias;

    Compass(String alias) {
        this.alias = alias;
    }

    public String alias() {
        return alias;
    }

    public static Compass fromAlias(String alias) {
        for (Compass compass : values()) {
            if (compass.alias().equalsIgnoreCase(alias)) {
                return compass;
            }
        }
        throw new EnumConstantNotPresentException(Compass.class, "Didn't find anything for " + alias);
    }
}
