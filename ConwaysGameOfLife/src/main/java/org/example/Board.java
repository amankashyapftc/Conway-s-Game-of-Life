package org.example;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Board {

    private Cell[][] grid;
    private Cell[][] previousGrid;

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
                if (random.nextInt(2) == 1 && aliveCellCount > 0) {
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

    public void nextGeneration() {
        Cell[][] newGrid = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                if (grid[i][j].equals(new Cell(true))) {
                    newGrid[i][j] = new Cell(aliveNeighbors == 2 || aliveNeighbors == 3);
                } else {
                    newGrid[i][j] = new Cell(aliveNeighbors == 3);
                }
            }
        }
        previousGrid = grid.clone();
        grid = newGrid;
    }

    public boolean isSameAsPrevious() {
        return Arrays.deepEquals(grid, previousGrid);
    }

    public int countAliveNeighbors(int row, int col) {
        int aliveNeighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (isValidCell(i, j) && grid[i][j].equals(new Cell(true))) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public void printGrid(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j].equals(new Cell(true))){
                    System.out.print('*');
                }else{
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }
}