import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        int safeCount = 0;
        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        for (int i = 0; i < fileData.size(); i++){
            String[] report = fileData.get(i).split(" ");
            boolean increasing = false;
            boolean decreasing = false;
            boolean safe = true;
            for (int j = 1; j < report.length; j++){
                int num1 = Integer.parseInt(report[j-1]);
                int num2 = Integer.parseInt(report[j]);
                if (num1 > num2){
                    increasing = true;
                } else if (num2 > num1) {
                    decreasing = true;
                } else {
                    safe = false;
                }
                if (safe){
                    if (increasing && !(num1 - num2 >= 1 && num1 - num2 <= 3)){
                        safe = false;
                    } else {
                        if (decreasing && !(num2 - num1 >= 1 && num2 - num1 <= 3)) {
                            safe = false;
                        }
                    }
                }
            }
            if (safe){
                safeCount++;
            }
        }
        System.out.println("safe: " + safeCount);
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