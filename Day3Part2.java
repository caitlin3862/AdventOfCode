import java.io.File;
import java.io.FileNotFoundException;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Day3Input.txt");
        ArrayList<String> allMatches = new ArrayList<>();
        for (int i = 0; i< fileData.size(); i++) {
            String searchString = fileData.get(i);
            String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
            Matcher m = Pattern.compile(regex).matcher(searchString);
            while (m.find()) {
                allMatches.add(m.group());
            }
        }

        int total = 0;
        System.out.println(allMatches);
        boolean include = true;
        for (int i = 0; i < allMatches.size(); i++){
            if (allMatches.get(i).equals("don't()")) {
                include = false;
            }
            if (allMatches.get(i).equals("do()")){
                include = true;
            }
            if (include && !allMatches.get(i).equals("do()")) {
                total += calculateMul(allMatches.get(i));
            }
        }
        System.out.println("Total: " + total);

        //174103751
        //154470644
    }

    public static int calculateMul(String str){
        int idxP = str.indexOf("(");
        int idxC = str.indexOf(",");

        int num1 = Integer.parseInt(str.substring(idxP+1, idxC));
        int num2 = Integer.parseInt(str.substring(idxC+1, str.length()-1));

        return num1*num2;
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