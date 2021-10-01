package sample.EndPage;

import sample.TitlePage.TitlePageController;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

//manages methods for all score related items;
public class FinalScoreManager {
    private File scores = new File("Scores.txt");

    //Requires: nothing
    //Modifies: this, scores
    //Effects: scores.txt file's content of scores is deleted
    public void deleteScores() {
        scores.delete();
    }

    //Requires: int score
    //Modifies: this, scores
    //Effects: Write a score into the file of scores.
    public void addScore(int score) throws IOException {
        FileWriter fw = new FileWriter(scores, true);
        fw.write("Score: " + score + "\n");
        fw.close();
    }

    //Requires: nothing
    //Modifies: this, allScores
    //Effects: Returns the scores from the file as a list of strings.
    public ArrayList<String> getAllScores() throws IOException {
        ArrayList<String> allScores = new ArrayList<>();
        if(!scores.exists()){
            return allScores;
        }
        BufferedReader br = new BufferedReader(new FileReader(scores));
        String line;
        while ((line = br.readLine()) != null){
            allScores.add(0, line);
        }
        br.close();
        return allScores;
    }
}
