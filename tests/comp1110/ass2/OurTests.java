package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OurTests {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    // Tests the situation where a track goes directly between 2 adjacent corner stations or 2 adjacent edge stations
    // It also includes a track that goes to the middle station to check if that works (although that may be part of another test)
    @Test
    public void testPlayerScoreHelper() {
        String[] tileArray = {"cbcb00","bcbc07","bcbc70","dbcd77","ccda73","cbaa74","cbaa64","cbaa54"};
        int[] expected = {7};
        int[] outcome = {Score.scorePlayer(2,tileArray, 6)};
        test(expected, outcome);
    }

    private void test(int[] expected, int[] out) {
        assertNotNull("Expected score to be " + Arrays.toString(expected) + ", but got null", out);
        assertTrue("Expected score to be " + Arrays.toString(expected) + ", but got " + Arrays.toString(out), Arrays.equals(expected, out));
    }
    @Test
    public void testStationAlllocation(){
        int NumOfPlayers = 3;
        int[][] stationExpected = {{1, 4, 6, 11, 15, 20, 23, 25, 28, 31},{2, 7, 9, 12, 14, 19, 22, 27, 29, 32},{3, 5, 8, 10, 13, 18, 21, 24, 26, 30}};
        int[][] stationOutcome = Player.allocateStations(NumOfPlayers);
        assertNotNull("Expected station allocation :" + Arrays.deepToString(stationExpected) + " instead got null" ,stationOutcome);
        assertTrue("Expected station allocation: " + Arrays.deepToString(stationExpected) + " but got " + Arrays.deepToString(stationOutcome)
                , Arrays.deepEquals(stationExpected, stationOutcome));

    }
}
