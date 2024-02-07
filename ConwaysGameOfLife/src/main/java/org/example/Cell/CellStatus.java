package org.example.Cell;

public enum CellStatus {
    ALIVE("*"),
    DEAD("-");

    private final String stateString;

    CellStatus(String stateString) {
        this.stateString = stateString;
    }

    public String getStateString() {
        return stateString;
    }
}
