
import org.example.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CellTest {
    @Test
    void TestAliveCellsEqualWithDeadCellByUsingChangedIsAlive() {
        Cell epectedCell = new Cell(false);
        Cell cell = new Cell(true);
        cell.changeIsAlive();
        assertEquals(epectedCell,cell);
    }
    @Test
    void testAliveCellsNotEqualWithAliveCellByUsingChangedIsAlive() {
        Cell expectedCell = new Cell(true);
        Cell cell = new Cell(true);
        cell.changeIsAlive();
        assertNotEquals(expectedCell, cell);
    }

    @Test
    void testDeadCellsEqualWithDeadCellByUsingChangedIsAlive() {
        Cell expectedCell = new Cell(false);
        Cell cell = new Cell(true);
        cell.changeIsAlive();
        assertEquals(expectedCell, cell);
    }

    @Test
    void testDeadCellsNotEqualWithAliveCellByUsingChangedIsAlive() {
        Cell expectedCell = new Cell(false);
        Cell cell = new Cell(false);
        cell.changeIsAlive();
        assertNotEquals(expectedCell, cell);
    }
}