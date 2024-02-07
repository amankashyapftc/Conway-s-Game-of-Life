
import org.example.Cell.Cell;
import org.example.Cell.CellStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CellTest {

    @Test
    public void testCanNotCreateNewCellWithNegativeRowsAndCols(){
        assertThrows(IllegalArgumentException.class,()->{
            new Cell(CellStatus.ALIVE,-1,0);
        });
    }

    @Test
    public void testDeadCellWillBecameAliveIfItHas3AliveNeighbours(){
        Cell deadCell = new Cell(CellStatus.DEAD,0,0);
        List<Cell> neighbours = new ArrayList<>();
        neighbours.add(new Cell(CellStatus.ALIVE,0,1));
        neighbours.add(new Cell(CellStatus.ALIVE,1,0));
        neighbours.add(new Cell(CellStatus.ALIVE,1,1));
        assertEquals(deadCell.nextGenerationState(neighbours),new Cell(CellStatus.ALIVE,0,0));
    }

    @Test
    public void testAliveCellWillBecameRemainAliveIfItHas2AliveNeighbours(){
        Cell aliveCell = new Cell(CellStatus.ALIVE,0,0);
        List<Cell> neighbours = new ArrayList<>();
        neighbours.add(new Cell(CellStatus.ALIVE,0,1));
        neighbours.add(new Cell(CellStatus.ALIVE,1,0));
        assertEquals(aliveCell.nextGenerationState(neighbours),new Cell(CellStatus.ALIVE,0,0));
    }
    @Test
    public void testAliveCellHasLessThan2AliveNeighboursItWillBecameDead(){
        Cell aliveCell = new Cell(CellStatus.ALIVE,0,0);
        List<Cell> neighbours = new ArrayList<>();
        neighbours.add(new Cell(CellStatus.ALIVE,0,1));
        assertEquals(aliveCell.nextGenerationState(neighbours),new Cell(CellStatus.DEAD,0,0));
    }
    @Test
    public void testAliveCellWillBecameDeadIfItHas4LiveNeighbours(){
        Cell aliveCell = new Cell(CellStatus.ALIVE,1,1);
        List<Cell> neighbours = new ArrayList<>();
        neighbours.add(new Cell(CellStatus.ALIVE,0,0));
        neighbours.add(new Cell(CellStatus.ALIVE,0,1));
        neighbours.add(new Cell(CellStatus.ALIVE,0,2));
        neighbours.add(new Cell(CellStatus.ALIVE,1,2));
        assertEquals(aliveCell.nextGenerationState(neighbours),new Cell(CellStatus.DEAD,1,1));
    }

}