package me.connortech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class day3 {

    public static void main(String[] args) {

        String filepath = "/Users/connor/Projects/AOC22/AOC22/src/main/resources/Inputs/day3";
        List<String> lines = getInputLines(filepath);

        // For every line
        // Split in half to find both compartments
        // Get common items and calculate the priority.
        // Add that priority score to sum
        int total = 0;
        for (String line : lines) {
            int lineLength = line.length();
            String comp1 = line.substring(0,lineLength/2);
            String comp2 = line.substring((lineLength/2),lineLength);
            //System.out.println("par1: " + comp1 + "   part2: " + comp2);
            // Check for repeat items
            List<Character> matches = new ArrayList<>();
            for (char item : comp1.toCharArray()) {
                if (comp2.contains(String.valueOf(item))) { // TODO: revisit. not the best way
                    // Need to get the score of this if not already similar
                    if ( matches.isEmpty() || !matches.contains(item)) {
                        matches.add(item);
                        total = total + calculatePriority(item);
                    }
                }
            }
        }
        System.out.println(total);

        // Part 2. Look for the common item between in 3 lines. Get priority of that
        BufferedReader reader;
        List<List> linesGroup = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {
                List<String> lineGroup = new ArrayList<>();
                lineGroup.add(line);
                line = reader.readLine();
                lineGroup.add(line);
                line = reader.readLine();
                lineGroup.add(line);
                linesGroup.add(lineGroup);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }


        int totalGroups = lines.size()/3;
        int total2 = 0;


        for (List group : linesGroup) {
            String line1 = group.get(0).toString();
            String line2 = group.get(1).toString();
            String line3 = group.get(2).toString();
            for (char item : line1.toCharArray()) {
                if ((line2.contains(String.valueOf(item))) && (line3.contains(String.valueOf(item)))) {
                    total2 = total2 + calculatePriority(item);
                    break;
                }
            }
            System.out.println(total2);
        }
    }

    // TODO: Move to util import. Not sure why that does not work
    public static List<String> getInputLines(String filepath) {
        BufferedReader reader;
        List<String> lines = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    // Calculate the priority of the item
    public static int calculatePriority(char input) {
        int value = 0;
        switch (input) {
            case 'a' : value = 1;
                break;
            case 'b' : value = 2;
                break;
            case 'c' : value = 3;
                break;
            case 'd' : value = 4;
                break;
            case 'e' : value = 5;
                break;
            case 'f' : value = 6;
                break;
            case 'g' : value = 7;
                break;
            case 'h' : value = 8;
                break;
            case 'i' : value = 9;
                break;
            case 'j' : value = 10;
                break;
            case 'k' : value = 11;
                break;
            case 'l' : value = 12;
                break;
            case 'm' : value = 13;
                break;
            case 'n' : value = 14;
                break;
            case 'o' : value = 15;
                break;
            case 'p' : value = 16;
                break;
            case 'q' : value = 17;
                break;
            case 'r' : value = 18;
                break;
            case 's' : value = 19;
                break;
            case 't' : value = 20;
                break;
            case 'u' : value = 21;
                break;
            case 'v' : value = 22;
                break;
            case 'w' : value = 23;
                break;
            case 'x' : value = 24;
                break;
            case 'y' : value = 25;
                break;
            case 'z' : value = 26;
                break;

            case 'A' : value = 27;
                break;
            case 'B' : value = 28;
                break;
            case 'C' : value = 29;
                break;
            case 'D' : value = 30;
                break;
            case 'E' : value = 31;
                break;
            case 'F' : value = 32;
                break;
            case 'G' : value = 33;
                break;
            case 'H' : value = 34;
                break;
            case 'I' : value = 35;
                break;
            case 'J' : value = 36;
                break;
            case 'K' : value = 37;
                break;
            case 'L' : value = 38;
                break;
            case 'M' : value = 39;
                break;
            case 'N' : value = 40;
                break;
            case 'O' : value = 41;
                break;
            case 'P' : value = 42;
                break;
            case 'Q' : value = 43;
                break;
            case 'R' : value = 44;
                break;
            case 'S' : value = 45;
                break;
            case 'T' : value = 46;
                break;
            case 'U' : value = 47;
                break;
            case 'V' : value = 48;
                break;
            case 'W' : value = 49;
                break;
            case 'X' : value = 50;
                break;
            case 'Y' : value = 51;
                break;
            case 'Z' : value = 52;
                break;
        }

        return value;
    }

}
