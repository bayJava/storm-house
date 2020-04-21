package Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScore implements Serializer {
    private List<Score> scoresList = new ArrayList<Score>();
    private int maxNumOfHighScoreEntries = 15;
    private int maxScoresDisplayed = 5;

    /**
     * Takes a Score as I/P.
     * Loads the High Scores from File into a Data Structure (scoresList).
     * Adds the incoming Score into the appropriate position in the List.
     * Writes the List back to the File (overwrite the old file).
     * 
     * @param score - Score Object to be added 
     */
    public void addHighScore(Score score) {
        scoresList.add(score);
    
    }

    /**
    * Takes a Score as I/P. If the List size is < 10 then the Score Qualifies else
     * if Incoming Score > than the lowest score in the List (last element) If so
     * return 'true' or else return 'false'.
     * 
     * @param score - Score to be checked if qualifies to be high
     * @return - True or False
     */
    public boolean findIfScoreQualifiesAsHigh(Score score) {
        int scoreListsize = scoresList.size();
        scoresList.add(score);
     // Score lowestScore = Collections.min(scoresList);
        Score lowestScore = scoresList.get(scoresList.size()- 1);
        if(scoreListsize < 10){
            return true;
        }else if(score.getScore() > lowestScore.getScore()){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 
     * @param fileName - File name to load high scores from.
     * @throws IOException
     */
    public void loadScores(String fileName) throws IOException {

        // 1. Create the File Object to identify the file to work with
        File myFileObj = new File(fileName);
        // 2. Create the FileReader object from the File object to work with a character Stream
        // 3. Create the BufferedReader object to read through the stream by passing the FileReader object
        BufferedReader buffObj = new BufferedReader(new FileReader(myFileObj));

        // 4. Clear the Scores list
        scoresList.clear();
        // 5. Read through the BufferedReader object line by line
        String line = buffObj.readLine();
        while (line != null) {
            // 6. Parse the individual items in the line into fields
            String[] allFields = line.split(",");
            String name = allFields[0];
            int score = Integer.parseInt(allFields[1]);
            DifficultyType diffType = DifficultyType.valueOf(allFields[2]);
            // 7. Populate the High Scores List with the data from eac line
            scoresList.add(new Score(name,score,diffType));
        }
        // Close the File
        buffObj.close();

    }
    /**
     * 1. Create the File Object to identify the file to write to
     * 2. Create the FileWriter object for the File object to work with a character Stream
     * 3. Create the BufferedWriter object to write into the stream by passing the FileWriter object
     *    connected to the File object. 
     * Loop through the Scores List and Write each line to PrintWriter Stream 
     * Close the file
     * @param fileName - File to Write to
     */
    public void saveScores(String fileName) {
        // Create File Object
        File outFile = new File(fileName);
        try {
            FileWriter fw = new FileWriter(outFile);
            BufferedWriter bufReader = new BufferedWriter(fw);
            PrintWriter outStream = new PrintWriter(bufReader);
            for (int i = 0; i < scoresList.size(); ++i) {
                String line = scoresList.get(i).getName() + "," + scoresList.get(i).getScore() + "," + scoresList.get(i).getDifficultyType();
                outStream.println(line);
            }
            outStream.close();
        } catch (IOException e) {
            System.out.println("I/O Error");
            System.exit(0);
        }

    }

    /**
     // For Sort function
     // Pass file as an arugument to sort function
     // Get the a file path and readAllLines of the file
     // Put Loop for check the one by ne record 
     //  Get All the columns and Add to Scorelist
     // And Pass that List to Collections.sort() method
     // then return the Scorelist
    */

    public List<Score> sort(File filename) throws Exception{
        Path path = Paths.get(filename.toURI());
        List<String> allrecords = Files.readAllLines(path);
        for (int i = 1; i < allrecords.size(); i++) {
            String line = scoresList.get(i).getName() + "," + scoresList.get(i).getScore() + "," + scoresList.get(i).getDifficultyType();
            String[] columns = line.split(",");
            DifficultyType diffType = DifficultyType.valueOf(columns[2]);
            Score record = new Score(columns[0],Integer.parseInt(columns[1]), diffType);
            scoresList.add(record);
        }
        //Stream.of(scoresList).max((s1,s2) -> s1.length()- s2.length()).get();
        Collections.sort(scoresList);
        return scoresList;
    }



    /**
     * 
     * @return - returns the list of Highscores.
     */
    public List<Score> getScoresList() {
        return scoresList;
    }

    /**
     * Takes the Highscore list as input and sets it as the scoresList.
     * 
     * @param scoresList
     */
    public void setScoresList(List<Score> scoresList) {
        this.scoresList = scoresList;
    }

    /**
     * 
     * @return - returns the maximum number of high score entries (15).
     */
    public int getMaxNumOfHighScoreEntries() {
        return maxNumOfHighScoreEntries;
    }

    /**
     * sets the maximum number of high score entries to 15. 
     * @param maxNumOfHighScoreEntries
     */
    public void setMaxNumOfHighScoreEntries(int maxNumOfHighScoreEntries) {
        this.maxNumOfHighScoreEntries = maxNumOfHighScoreEntries;
    }

    /**
     * 
     * @return - returns the maximum number of scores displayed on the screen at a time (5).
     */
    public int getMaxScoresDisplayed() {
        return maxScoresDisplayed;
    }

    /**
     * Sets the maximum number of scores displayed on the screen at a time to 5.
     * @param maxScoresDisplayed
     */
    public void setMaxScoresDisplayed(int maxScoresDisplayed) {
        this.maxScoresDisplayed = maxScoresDisplayed;
    }
    
    // Singleton implementation
    // prevent direct instantiation outside this class
    private HighScore() {

    }

    private static HighScore instance = new HighScore();

    public static HighScore getInstance() {
        return instance;
    }

    public static void reset() {
        instance = new HighScore();
    }

    @Override
    public String serialize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deserialize(String data) {
        // TODO Auto-generated method stub

    }
}

