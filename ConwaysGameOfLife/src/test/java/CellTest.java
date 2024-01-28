
import org.example.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CellTest {
    @Test
    void TestAliveCellsEqualWithDeadCellByUsingChangedIsAlive() {
        Cell epectedCell = new Cell(false);
        Cell cell = new Cell(true);
        cell.changeIsAlive();
        assertEquals(epectedCell,cell);
    }
}