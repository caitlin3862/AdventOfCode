import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<String> firstList = new ArrayList<>();
        ArrayList<String> secondList = new ArrayList<>();

        for (int i = 0; i < fileData.size(); i++){
            String[] split = fileData.get(i).split("   ");
            firstList.add(i, split[0]);
            secondList.add(i, split[1]);
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        int similarityScore = 0;
        for (int i = 0; i < firstList.size(); i++){
            int count = 0;
            int num1 = Integer.parseInt(firstList.get(i));
            for (int j = 0; j < secondList.size(); j++){
                if (Integer.parseInt(secondList.get(j)) == num1){
                    count ++;
                }
            }
            similarityScore += (num1 * count);
        }

        System.out.println("Total score: " + similarityScore);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}