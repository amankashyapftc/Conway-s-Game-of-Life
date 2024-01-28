package org.example;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Board {

    private Cell[][] grid;

    public Board(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be greater than 0");
        }
        this.grid = new Cell[rows][cols];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Board otherBoard = (Board) obj;
        return Arrays.deepEquals(grid, otherBoard.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grid);
    }

    public void seedRandomCells(int percentage,int rows , int cols) {
        if (percentage <= 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 1 and 100");
        }
        int aliveCellCount = (rows*cols)*percentage/100;
        Random random = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(aliveCellCount == 0) return;
                if (random.nextInt(2) == 1) {
                    grid[i][j] = new Cell(true);
                    aliveCellCount--;
                }else{
                    grid[i][j] = new Cell(false);
                }
            }
        }
    }

    public int countAliveCells() {
        int aliveCells = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (Objects.equals(grid[i][j], new Cell(true))) {
                    aliveCells++;
                }
            }
        }

        return aliveCells;
    }
}