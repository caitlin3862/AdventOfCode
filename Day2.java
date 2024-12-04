import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        int safe = 0;
        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        for (int i = 0; i < fileData.size(); i++){
            String[] report = fileData.get(i).split(" ");
            for (int j = 0; j < report.length; j++){
                // check the conditions
            }
        }

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
