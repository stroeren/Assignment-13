import java.io.*;
import java.util.*;

public class Assignment13 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt"; // Path to the input file
        String outputFilePath = "output.txt"; // Path to the output file

        // Using a TreeMap to store words in lowercase along with their counts. TreeMap ensures words are sorted.
        Map<String, Integer> wordCounts = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase to ensure case insensitivity
                line = line.toLowerCase();
                // Update the count for each word
                wordCounts.put(line, wordCounts.getOrDefault(line, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Writing the counts to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine(); // Move to the next line after writing each word's count
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}