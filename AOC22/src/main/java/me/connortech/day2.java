package me.connortech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day2 {
    // A=ROCK       =X=1point
    // B=PAPER      =Y=2point
    // C=SCISSORS   =Z=3point
    // 0 points for lose
    // 3 points for draw
    // 6 points for won

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            String file = "/Users/connor/Projects/AOC22/AOC22/src/main/resources/Inputs/day2";
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            List<String> games = new ArrayList<>();
            int scorePart1 = 0;
            while (line != null) {
                games.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();

            for (String game : games) {
                char p1 = game.charAt(0);
                char p2 = game.charAt(2);

                // WIN
                if ((p1 == 'A') && (p2 == 'Y') || (p1 == 'B') && (p2 == 'Z') || (p1 == 'C') && (p2 == 'X')) {
                    scorePart1 = scorePart1 + 6 + scoreForShape(p2);
                } // Draw
                else if ((p1 == 'A') && (p2 == 'X') || (p1 == 'B') && (p2 == 'Y') || (p1 == 'C') && (p2 == 'Z')) {
                    scorePart1 = scorePart1 + 3 + scoreForShape(p2);
                } else {
                    scorePart1 = scorePart1 + scoreForShape(p2);
                }
            }

            System.out.println(scorePart1);

            // Part 2
            // p2 = X = lose
            // p2 = Y = draw
            // p3 = Z = win
            int scorePart2 = 0;

            for (String game : games) {
                char p1 = game.charAt(0);
                char p2 = game.charAt(2);

                if (p2 == 'X') { //Lose
                    char need = desiredShape(0,p1);
                    scorePart2 = scorePart2 + scoreForRound(p1,need) + scoreForShape(need);
                } else if (p2 == 'Y') { //Draw
                    char need = desiredShape(1,p1);
                    scorePart2 = scorePart2 + scoreForRound(p1,need) + scoreForShape(need);
                } else { //Win
                    char need = desiredShape(2,p1);
                    scorePart2 = scorePart2 + scoreForRound(p1,need) + scoreForShape(need);
                }
            }

            System.out.println(scorePart2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int scoreForShape(char shape) {
        int score = 0;
        switch (shape) {
            case 'X':  score = 1;
                break;
            case 'Y': score = 2;
                break;
            case 'Z': score = 3;
        }
        return score;
    }

    public static int scoreForRound(char p1, char p2) {
        if ((p1 == 'A') && (p2 == 'Y') || (p1 == 'B') && (p2 == 'Z') || (p1 == 'C') && (p2 == 'X')) {
            return 6;
        } // Draw
        else if ((p1 == 'A') && (p2 == 'X') || (p1 == 'B') && (p2 == 'Y') || (p1 == 'C') && (p2 == 'Z')) {
            return 3;
        } else {
            return 0;
        }
    }

    // Figure out what shape is needed
    // Desire 0=lose, 1=draw, 2=win
    public static char desiredShape(int desire, char p1) {
        char need = 0;
        if (desire == 0) { // lose
            switch (p1) {
                case 'A' : need = 'Z';
                    break;
                case 'B' : need = 'X';
                    break;
                case 'C' : need = 'Y';
            }
        } else if (desire == 1) { // draw
            switch (p1) {
                case 'A' : need = 'X';
                    break;
                case 'B' : need = 'Y';
                    break;
                case 'C' : need = 'Z';
            }
        } else if (desire == 2) { //win
            switch (p1) {
                case 'A' : need = 'Y';
                    break;
                case 'B' : need = 'Z';
                    break;
                case 'C' : need = 'X';
            }
        }
        return need;
    }
}

// TODO: Refactor all of this. Lot of repeated logic