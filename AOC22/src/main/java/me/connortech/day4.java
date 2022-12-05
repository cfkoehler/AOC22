package me.connortech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day4 {
    public static void main(String[] args) {
        BufferedReader reader;
        List<String> lines = new ArrayList<>();
        try {
            String file = "/Users/connor/Projects/AOC22/AOC22/src/main/resources/Inputs/day4";
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)");
        // For each line
        int count = 0;
        int count2 = 0;
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            int p1Min = 0;
            int p1Max = 0;
            int p2Min = 0;
            int p2Max =0;
            while (matcher.find()) {
                p1Min = Integer.parseInt(matcher.group(1));
                p1Max = Integer.parseInt(matcher.group(2));
                p2Min = Integer.parseInt(matcher.group(3));
                p2Max = Integer.parseInt(matcher.group(4));
            }
            // Check for inclusivity
            if (((p1Min <= p2Min) && (p2Max <= p1Max)) || ((p2Min <= p1Min) && (p1Max <= p2Max))) {
                count = count + 1;
            }
            // if not (e1 < s2 or s1 > e2):
            if ( !((p1Max < p2Min) || (p1Min > p2Max))) {
                count2 = count2 + 1;
            }
        }
        System.out.println(count);
        System.out.println(count2);
    }
}
