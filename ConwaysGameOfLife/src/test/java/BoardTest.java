import org.example.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testInitializeBoardWith3RowsAnd3Cols() {
        int rows = 3;
        int cols = 3;
        Board board = new Board(rows, cols);
        assertNotNull(board);
        assertEquals(new Board(rows, cols), board);
    }

    @Test
    public void testInitializeBoardWithNegativeRowsAndPositiveColsShouldThrowError() {
        int rows = -1;
        int cols = 2;
        assertThrows(IllegalArgumentException.class,()->{
            Board board = new Board(rows, cols);
        });
    }

    @Test
    public void testInitializeBoardWithNegativeRowsAndNegativeColsShouldThrowError() {
        int rows = -1;
        int cols = -2;
        assertThrows(IllegalArgumentException.class,()->{
            Board board = new Board(rows, cols);
        });
    }


    @Test
    public void testInitializeBoardWith0RowsAnd0ColsShouldThrowError() {
        int rows = 0;
        int cols = 0;
        assertThrows(IllegalArgumentException.class,()->{
            Board board = new Board(rows, cols);
        });
    }

    @Test
    public void testInitializeBoardWith5Rows5ColsAndSeedingPercentage40WillGive10OrLessThan10AliveCells() {
        int rows = 5;
        int cols = 5;
        int seedingPercentage = 40;
        int expectedAliveCells = 10;
        Board board = new Board(rows, cols);
        board.seedRandomCells(seedingPercentage,rows,cols);
        assertNotNull(board);
        assertTrue(expectedAliveCells <= board.countAliveCells());
    }

    @Test
    public void testInitializeBoardWith10Rows10ColsAndSeedingPercentage0ShouldThrowError() {
        int rows = 10;
        int cols = 10;
        int seedingPercentage = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            Board board = new Board(rows, cols);
            board.seedRandomCells(seedingPercentage, rows, cols);
        });
    }

    @Test
    public void testFor1x1GridNextGenerationWillBeAllDead() {
        Board board = new Board(1, 1);
        board.seedRandomCells(100, 1, 1);
        assertEquals(1, board.countAliveCells());
        board.nextGeneration();
        assertEquals(0, board.countAliveCells());
    }


    @Test
    public void testFor2x2GridWithOneAliveCellNextGenerationWillBeAllDead() {
        Board board = new Board(2, 2);
        board.seedRandomCells(25, 2, 2);
        assertEquals(1, board.countAliveCells());
        board.nextGeneration();
        assertEquals(0, board.countAliveCells());
    }

    @Test
    public void testFor3x3GridWithOneAliveCellNextGenerationWillBeAllDead() {
        Board board = new Board(3, 3);
        board.seedRandomCells(15, 3, 3);
        assertEquals(1, board.countAliveCells());
        board.nextGeneration();
        assertEquals(0, board.countAliveCells());
    }

    @Test
    public void testFor4x4GridWithOneAliveCellNextGenerationWillBeAllDead() {
        Board board = new Board(4, 4);
        board.seedRandomCells(10, 4, 4);
        assertEquals(1, board.countAliveCells());
        board.nextGeneration();
        assertEquals(0, board.countAliveCells());
    }


}