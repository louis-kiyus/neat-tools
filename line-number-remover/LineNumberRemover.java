import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class LineNumberRemover {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        // String line = "1. hahaha\n 2. hehehe\n";
        /*
         * "\t" is a tab character
         */
        System.out.println("Please enter the delimiter of the number (tab is \\t):");
        Scanner scan = new Scanner(System.in);
        String delimeter = scan.nextLine();
        String outputString = "";
        String filepath = "./Numbers.txt";

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader(filepath))) {

            // Read from each line of the file
            String curLine = bfr.readLine();
            while (curLine != null) {

                if (curLine.isEmpty()) {
                    // If the line is empty, continue to the next iteration of the loop
                    continue;
                }
                lines.add(curLine);
                // Add the line to the ArrayList
                curLine = bfr.readLine();
            }
            boolean firstTime = true;

            int indexOfFirstChar = 0;
            for (String aLine : lines) { // iterate through each line
                while (true) {

                    try {
                        // check if the character before the delimeter is a number, if it is, break from
                        // the while loop
                        Integer.parseInt(Character.toString(aLine.charAt(aLine.indexOf(delimeter) - 1)));
                        break;
                    } catch (NumberFormatException e) {
                        aLine = aLine.substring(aLine.indexOf(delimeter) + 1);
                        continue;
                    } catch (StringIndexOutOfBoundsException e) {
                        // used when the delimiter is the first character in the line (happens when the
                        // delimiter is a space)
                        aLine = aLine.substring(aLine.indexOf(delimeter) + 1);
                        // System.out.println(aLine);
                        continue;
                    }
                }
                if (firstTime) {
                    // get the index of the first character in the line (happens when there are
                    // spaces after the line number)
                    indexOfFirstChar = aLine.indexOf(delimeter) + 1;
                    while (true) {
                        if ((aLine.charAt(indexOfFirstChar) != ' ') && aLine.charAt(indexOfFirstChar) != '\t') {
                            indexOfFirstChar -= (aLine.indexOf(delimeter) + 1);
                            break;
                        } else {
                            indexOfFirstChar++;
                        }
                    }
                    firstTime = false;
                }
                // removes the line number and the spaces after the line number
                aLine = aLine.substring(aLine.indexOf(delimeter) + 1 + indexOfFirstChar);
                outputString += aLine + "\n";
            }
            System.out.println("Output: \n" + outputString);

            try {
                File file = new File(filepath);
                file.createNewFile(); // returns true if file does not exist

                FileOutputStream fos = new FileOutputStream(file, false);

                String[] linesToWrite = outputString.split("\n");

                PrintWriter pw = new PrintWriter(fos);

                for (int i = 0; i < linesToWrite.length; i++) {
                    pw.println(linesToWrite[i]);
                }
                pw.close();
            } catch (IOException e) {
                // e.printStackTrace();
                System.out.println("Write Failed :(");
            }

        }
    }
}