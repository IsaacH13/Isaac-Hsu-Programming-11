import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileIn = "in.txt";
        String word = "stored";

        ArrayList<String> lines = convertFileToLines(fileIn);
        ArrayList<ArrayList<Integer>> wordLocations = findLocations(lines, word);
        printResults(word, wordLocations);
    }

    public static ArrayList<String> convertFileToLines(String fileIn) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fileIn));

        int readLineInTxt;
        String lineStorage = "";
        while((readLineInTxt = br.read()) != -1) {
            char character = (char) readLineInTxt;

            String line = Character.toString(character);
            lineStorage += line;

            if (readLineInTxt == '\n') {
                lines.add(lineStorage);
                lineStorage = null;
            }
        }
        br.close();

        return lines;
    }

    public static ArrayList<ArrayList<Integer>> findLocations(ArrayList<String> lines, String word){
        ArrayList<ArrayList<Integer>> locations = new ArrayList<>();

        //search for word in line
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int startPos = 0;
            int indexPos;
            while ((indexPos = line.indexOf(word, startPos)) != -1) {
                //stores location in arrayList 'location'
                ArrayList<Integer> location = new ArrayList<>();
                //line number of match
                location.add(i+1);
                //position in the line
                location.add(indexPos+1);
                //stores the location
                locations.add(location);
                startPos = indexPos+1;
            }
        }

        return locations;
    }

    public static void printResults(String word, ArrayList<ArrayList<Integer>> wordLocations){
        for(ArrayList<Integer> location: wordLocations){
            System.out.println("line number =\t" + location.get(0));
            System.out.println("positionInLines =\t" + location.get(1));
            System.out.println("----------------------------------------------");
        }
    }
}
