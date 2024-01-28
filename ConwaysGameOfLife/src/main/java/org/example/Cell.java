package org.example;

import java.util.Objects;

public class Cell {

    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell cell)) return false;
        return isAlive == cell.isAlive;  // Directly compare the alive states
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }

    public void changeIsAlive() {
        this.isAlive = !isAlive;
    }
}
