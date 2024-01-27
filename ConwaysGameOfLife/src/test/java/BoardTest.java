import org.example.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTest {
    @Test
    public void testInitializeBoardWith3RowsAnd3Cols() {
        int rows = 3;
        int cols = 3;
        Board board = new Board(rows, cols);
        assertNotNull(board);
        assertEquals(new Board(rows, cols), board);
    }
}
