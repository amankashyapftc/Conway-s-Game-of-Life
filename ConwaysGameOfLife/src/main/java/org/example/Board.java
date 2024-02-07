package org.example;
import org.example.Cell.Cell;
import org.example.Cell.CellStatus;
import org.example.Cell.CellNeighboursList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Board {
    private Cell[][] board;

    public Board(int row, int column) {
        if (row <= 0 || column <= 0) {
            throw new IllegalArgumentException("Rows and columns must be greater than 0");
        }
        this.board = new Cell[row][column];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Board otherBoard = (Board) obj;
        return Arrays.deepEquals(board, otherBoard.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    public void seedRandomCells(int percentage,int rows , int cols) {
        if (percentage <= 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 1 and 100");
        }
        int aliveCellCount = (rows*cols)*percentage/100;
        Random random = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (random.nextInt(2) == 1 && aliveCellCount > 0) {
                    board[i][j] = new Cell(CellStatus.ALIVE,i,j);
                    aliveCellCount--;
                }else{
                    board[i][j] = new Cell(CellStatus.DEAD,i,j);
                }
            }
        }
    }

    public int countAliveCells() {
        int aliveCells = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Objects.equals(board[i][j], new Cell(CellStatus.ALIVE,i,j))) {
                    aliveCells++;
                }
            }
        }
        return aliveCells;
    }

    public void nextGeneration() {
        Cell[][] newGrid = new Cell[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<int[]> neighboursCoordinates = new CellNeighboursList(i,j).validNeighboursCoordinates(board.length, board[0].length);
                List<Cell> neighbourCells = neighboursCoordinates.stream().map( coordinates -> board[coordinates[0]][coordinates[1]]).toList();
                newGrid[i][j] = board[i][j].nextGenerationState(neighbourCells);
            }
        }
        if(Arrays.deepEquals(newGrid, board)){
            throw new IllegalStateException("Reached to Stable State.");
        }
        board = newGrid;
    }
    public void print(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals(new Cell(CellStatus.ALIVE,i,j))){
                    System.out.print(CellStatus.ALIVE.getStateString());
                }else{
                    System.out.print(CellStatus.DEAD.getStateString());
                }
            }
            System.out.println();
        }
    }
}