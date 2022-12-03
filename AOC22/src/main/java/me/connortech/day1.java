package me.connortech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day1 {

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            String file = "/Users/connor/Projects/AOC22/AOC22/src/main/resources/Inputs/day1";
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            int sum = 0;
            int max = 0;
            List<Integer> elvesCals = new ArrayList<>();
            while (line != null) {
                if (line.equals("")) {
                    // Check if it is the max
                    if (sum > max) {
                        max = sum;
                    }
                    elvesCals.add(sum);
                    sum = 0;
                } else {
                    sum = sum + Integer.parseInt(line);
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
            System.out.println(String.format("MAX: %s", max));
            Integer[] elvesArray = new Integer[elvesCals.size()];
            elvesArray = elvesCals.toArray(elvesArray);
            Arrays.sort(elvesArray);
            int top3 = elvesArray[elvesArray.length-1] + elvesArray[elvesArray.length-2] + elvesArray[elvesArray.length-3];
            System.out.println(String.format("Top3: %s", top3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
