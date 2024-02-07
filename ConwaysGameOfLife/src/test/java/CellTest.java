
import org.example.Cell;
import org.example.CellStatus;
import org.junit.jupiter.api.Test;

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
        assertEquals(deadCell.nextGenerationState(3),new Cell(CellStatus.ALIVE,0,0));
    }

    @Test
    public void testAliveCellWillBecameRemainAliveIfItHas2AliveNeighbours(){
        Cell aliveCell = new Cell(CellStatus.ALIVE,0,0);
        assertEquals(aliveCell.nextGenerationState(2),new Cell(CellStatus.ALIVE,0,0));
    }
    @Test
    public void testAliveCellHasLessThan2AliveNeighboursItWillBecameDead(){
        Cell aliveCell = new Cell(CellStatus.ALIVE,0,0);
        assertEquals(aliveCell.nextGenerationState(1),new Cell(CellStatus.DEAD,0,0));
    }
    @Test
    public void testAliveCellWillBecameDeadIfItHasMoreThan3LiveNeighbours(){
        Cell aliveCell = new Cell(CellStatus.ALIVE,0,0);
        assertEquals(aliveCell.nextGenerationState(4),new Cell(CellStatus.DEAD,0,0));
    }

}