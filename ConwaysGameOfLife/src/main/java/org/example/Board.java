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
                if (random.nextInt(2) == 1 && aliveCellCount > 0) {
                    grid[i][j] = new Cell(CellStatus.ALIVE,i,j);
                    aliveCellCount--;
                }else{
                    grid[i][j] = new Cell(CellStatus.DEAD,i,j);
                }
            }
        }
    }

    public int countAliveCells() {
        int aliveCells = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (Objects.equals(grid[i][j], new Cell(CellStatus.ALIVE,i,j))) {
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
                int aliveNeighbors = NeighbourStatus.numberOfAliveNeighbours(i,j,grid);
                newGrid[i][j] = grid[i][j].nextGenerationState(aliveNeighbors);
            }
        }
        if(Arrays.deepEquals(newGrid, grid)){
            throw new IllegalStateException("Reached to Stable State.");
        }
        grid = newGrid;
    }
    public void print(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j].equals(new Cell(CellStatus.ALIVE,i,j))){
                    System.out.print(CellStatus.ALIVE.getStateString());
                }else{
                    System.out.print(CellStatus.DEAD.getStateString());
                }
            }
            System.out.println();
        }
    }
}