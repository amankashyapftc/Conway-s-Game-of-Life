package org.example;

import java.util.Objects;

public class Cell {

    private final int row;

    private final int col;

    private final CellStatus cellStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell cell)) return false;
        return row == cell.row && col == cell.col && cellStatus == cell.cellStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, cellStatus);
    }

    public Cell(CellStatus cellStatus, int row, int col) {
        if(row<0 || col<0){
            throw new IllegalArgumentException("Can not create Cell with negative rows and cols");
        }
        this.row = row;
        this.col=col;
        this.cellStatus = cellStatus;
    }

    public Cell nextGenerationState(int aliveNeighbors) {
        if(cellStatus.equals(CellStatus.ALIVE) && aliveNeighbors==2 || aliveNeighbors==3){
            return new Cell(CellStatus.ALIVE,this.row,this.col);
        }
        return new Cell(CellStatus.DEAD,this.row,this.col);
    }
}