import org.example.Cell;
import org.example.CellStatus;
import org.example.NeighbourStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NeighbourStatusTest {

    @Test
    public void testExpectCorrectNumberOfAliveCells2x2Grid(){
        Cell[][] grid = {
                {new Cell(CellStatus.DEAD,0,0),new Cell(CellStatus.ALIVE,0,1)},
                {new Cell(CellStatus.ALIVE,1,0),new Cell(CellStatus.ALIVE,1,1)}
        };
        int expectedAliveCells = 3;
        assertEquals(expectedAliveCells, NeighbourStatus.numberOfAliveNeighbours(0,0,grid));
    }
    @Test
    public void testExpectCorrectNumberOfAliveCells3x2Grid(){
        Cell[][] grid = {
                {new Cell(CellStatus.DEAD,0,0),new Cell(CellStatus.ALIVE,0,1)},
                {new Cell(CellStatus.ALIVE,1,0),new Cell(CellStatus.ALIVE,1,1)},
                {new Cell(CellStatus.ALIVE,2,0),new Cell(CellStatus.ALIVE,2,1)}
        };
        int expectedAliveCells = 4;
        assertEquals(expectedAliveCells, NeighbourStatus.numberOfAliveNeighbours(1,1,grid));
    }
    @Test
    public void testExpectCorrectNumberOfAliveCells4x2Grid(){
        Cell[][] grid = {
                {new Cell(CellStatus.DEAD,0,0),new Cell(CellStatus.ALIVE,0,1)},
                {new Cell(CellStatus.ALIVE,1,0),new Cell(CellStatus.ALIVE,1,1)},
                {new Cell(CellStatus.ALIVE,2,0),new Cell(CellStatus.ALIVE,2,1)},
                {new Cell(CellStatus.ALIVE,3,0),new Cell(CellStatus.ALIVE,3,1)}
        };
        int expectedAliveCells = 5;
        assertEquals(expectedAliveCells, NeighbourStatus.numberOfAliveNeighbours(2,1,grid));
    }
    @Test
    public void testExpectCorrectNumberOfAliveCells3x3Grid(){
        Cell[][] grid = {
                {new Cell(CellStatus.ALIVE,0,0),new Cell(CellStatus.ALIVE,0,1),new Cell(CellStatus.ALIVE,0,2)},
                {new Cell(CellStatus.ALIVE,1,0),new Cell(CellStatus.ALIVE,1,1),new Cell(CellStatus.ALIVE,1,2)},
                {new Cell(CellStatus.ALIVE,2,0),new Cell(CellStatus.ALIVE,2,1),new Cell(CellStatus.ALIVE,2,2)}
        };
        int expectedAliveCells = 8;
        assertEquals(expectedAliveCells, NeighbourStatus.numberOfAliveNeighbours(1,1,grid));
    }

}
