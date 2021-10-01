import org.junit.Test;
import sample.EndPage.FinalScoreManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FinalScoreManagerTester {
    FinalScoreManager finalScoreManager;
    private File scores = new File("Scores.txt");

    //Requires: nothing
    //Modifies: this, finalScoreManager
    //Effects: tests is finalScoreManager size is empty after a delete
    @Test
    public void testDeleteScores() throws IOException {
        finalScoreManager = new FinalScoreManager();
        finalScoreManager.deleteScores();

        ArrayList<String> allScores = finalScoreManager.getAllScores();
        assertEquals(0, allScores.size());
    }

    //Requires: nothing
    //Modifies: this, finalScoreManager
    //Effects: tests if adding a new score to an empty fileScoreManager has the size of 1 and if it contains the same
    //score
    @Test
    public void testAddScore() throws IOException {
        finalScoreManager = new FinalScoreManager();
        finalScoreManager.deleteScores();

        finalScoreManager.addScore(432);
        ArrayList<String> allScores = finalScoreManager.getAllScores();
        assertEquals(1, allScores.size());
        assertTrue(allScores.get(0).equals("score: 432"));
    }

    //Requires: nothing
    //Modifies: this, finalScoreManager
    //Effects: tests if adding new scores to an empty filesScoreManager has the size is the number of scores and if it
    //contains the same scores but in reverse order.
    @Test
    public void testGetAllScores() throws IOException {
        finalScoreManager = new FinalScoreManager();
        finalScoreManager.deleteScores();

        finalScoreManager.addScore(123);
        finalScoreManager.addScore(456);
        finalScoreManager.addScore(789);

        ArrayList<String> allScores = finalScoreManager.getAllScores();
        assertEquals(3, allScores.size());
        // Scores are reversed; most recent at top.
        assertTrue(allScores.get(0).equals("score: 789"));
        assertTrue(allScores.get(1).equals("score: 456"));
        assertTrue(allScores.get(2).equals("score: 123"));
    }
}
