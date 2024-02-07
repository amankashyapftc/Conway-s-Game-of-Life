import org.example.NeighboursList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NeighboursListTest {

    @Test
    void testNotToHaveANeighbourWithNegativeRowValue() {
        assertThrows(IllegalArgumentException.class, ()-> new NeighboursList(-1, 0));
    }

    @Test
    void testAbleToCreateNeighbourObject() {
        assertDoesNotThrow(()-> new NeighboursList(2, 0));
    }



    @Test
    void testAbleToGetValidNeighboursCoordinatesForCellAt0_0() {
        NeighboursList neighboursList = new NeighboursList(0,0);
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0,1});
        expected.add(new int[]{1,0});
        expected.add(new int[]{1,1});

        List<int[]> neighboursCoordinates = neighboursList.validNeighboursCoordinates(3,3);

        for(int i=0; i<neighboursCoordinates.size(); i++){
            assertEquals(expected.get(i)[0], neighboursCoordinates.get(i)[0]);
            assertEquals(expected.get(i)[1], neighboursCoordinates.get(i)[1]);
        }
    }

    @Test
    void TestAbleToGetValidNeighboursCoordinatesForCellAt1_1() {
        NeighboursList neighboursList = new NeighboursList(1,1);
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1,0});
        expected.add(new int[]{0,1});
        expected.add(new int[]{1,2});
        expected.add(new int[]{2,1});
        expected.add(new int[]{0,0});
        expected.add(new int[]{2,2});
        expected.add(new int[]{2,0});
        expected.add(new int[]{0,2});

        List<int[]> neighboursCoordinates = neighboursList.validNeighboursCoordinates(3,3);

        for(int i=0; i<neighboursCoordinates.size(); i++){
            assertEquals(expected.get(i)[0], neighboursCoordinates.get(i)[0]);
            assertEquals(expected.get(i)[1], neighboursCoordinates.get(i)[1]);
        }
    }

}
