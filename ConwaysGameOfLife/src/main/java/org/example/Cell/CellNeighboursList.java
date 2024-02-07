package org.example.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellNeighboursList {
    private final int[][] NEIGHBOURS_RELATIVE_POSITIONS;

    public CellNeighboursList(int row, int column) {
        if(row < 0 || column < 0) {
            throw new IllegalArgumentException("Row and column must be non-negative values.");
        }
        this.NEIGHBOURS_RELATIVE_POSITIONS = new int[][]{
                {row, column-1},    // left
                {row-1, column},    // top
                {row, column+1},    // right
                {row+1, column},    // bottom
                {row-1, column-1},  // top left
                {row+1, column+1},  // bottom right
                {row+1, column-1},  // bottom left
                {row-1, column+1}   // top right
        };
    }

    public List<int[]> validNeighboursCoordinates(int totalRows, int totalColumns){
        List<int[]> validNeighboursCoordinates = new ArrayList<>();
        for (int[] neighbourPosition : NEIGHBOURS_RELATIVE_POSITIONS) {
            int row = neighbourPosition[0];
            int column = neighbourPosition[1];
            if (row >= 0 && column >= 0 && row < totalRows && column < totalColumns)
                validNeighboursCoordinates.add(new int[]{row, column});
        }
        return validNeighboursCoordinates;
    }
}
