
import Model.DifficultyType;
import Model.Score;
import Model.HighScore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

public class HighScoreTest {

    /**
     * Unit Test to verify the adding of a High Score
     * 
     * @throws IOException
     */
    @Test
    public void testHighScoresAdd() throws IOException {
        HighScore highScores = UnitTestUtil.setupHighScores();

        // Delete the old SaveScoresData.txt file
        File fileObj = new File("src/main/resources/SaveScoresData.txt");
        if (fileObj.exists()) {
            fileObj.delete();
        }
        // Create a Score and add to High Scores
        Score score = new Score("Roger", 45000, DifficultyType.INSANE);
        highScores.addHighScore(score);

        assertTrue(score.getName().equals("Roger"));
        assertTrue(score.getScore() == 45000);
        assertEquals(1, highScores.getScoresList().size());
        assertEquals("Roger", highScores.getScoresList().get(0).getName());

        // Create 2nd Score and add to High Scores
        score = new Score("Burt", 50000, DifficultyType.HARD);
        highScores.addHighScore(score);
        assertEquals("Burt", highScores.getScoresList().get(0).getName());

        assertEquals(2, highScores.getScoresList().size());

        // Once Burt is added as above into the High Scores list
        // The Scores would have to be sorted in the scoresList and
        // also in the file.
        assertEquals("Burt", highScores.getScoresList().get(0).getName());
        assertEquals("Roger", highScores.getScoresList().get(1).getName());

    }

    /**
     * Unit Test for checking sucessful loading of High Scores from File
     * 
     * @throws IOException
     */
    @Test
    public void testLoadScores() throws IOException {
        HighScore highScores = UnitTestUtil.setupHighScores();

        // Load High Scores from File
        String fileName = "src/main/resources/HighScoresTestData.txt";
        highScores.loadScores(fileName);

        assertTrue(highScores.getScoresList().get(0).getName().equals("Frank"));
        assertTrue(highScores.getScoresList().get(0).getScore() == 40000);

        assertTrue(highScores.getScoresList().get(1).getName().equals("Joe"));
        assertTrue(highScores.getScoresList().get(1).getScore() == 35000);

        assertTrue(highScores.getScoresList().get(2).getName().equals("Sue"));
        assertTrue(highScores.getScoresList().get(2).getScore() == 30000);
        
        assertEquals(12, highScores.getScoresList().size());
    }

    /**
     * Unit test for saveScores() method
     * 1. Create the HignScore Singleton instance
     * 2. Load scores from HighScoresTestData.txt file into scoresList list
     * 3. Save scores into a new file, SaveScoresTestData.txt 
     * 4. Check if new file is written to and exists
     */
    @Test
    public void testSaveScores() {
        HighScore highScores = UnitTestUtil.setupHighScores();

        try {
            highScores.loadScores("src/main/resources/HighScoresTestData.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("I/O Error");
            e.printStackTrace();
        }
        highScores.saveScores("src/main/resources/SaveScoresTestData.txt");
        // Check if File SaveScoresTestData.txt exists
        File fileObj =  new File("src/main/resources/SaveScoresTestData.txt");
        assertTrue(fileObj.exists());

    }

}