package com.company;
import java.util.*;
import java.util.regex.Pattern;

public class Main
{
    //Atlassian
    public static int maxDifference(List<Integer> qty) {
        // Write your code here
        if (qty.size() == 0 || qty == null) {
            return -1;
        }

        int nextTimePeriod = 1, maxOutput = -1, smallestQuantity = Integer.MAX_VALUE;
        for (int i = 0; i < qty.size() && nextTimePeriod < qty.size(); i++) {
            if (qty.get(i) < qty.get(nextTimePeriod)) {
                smallestQuantity = Math.min(smallestQuantity, qty.get(i));
                maxOutput = Math.max(maxOutput, qty.get(nextTimePeriod) - smallestQuantity);
            }
            nextTimePeriod++;
        }

        return maxOutput;
    }

    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
        // Write your code here
        //Determine how many meetings the owner can schedule.
        if (firstDay.size() == 0 && lastDay.size() == 0) {
            return 0;
        }

        int meetings = 1, firstDayPointer = 0, lastDayPointer = 0, nextDayPointer = 1;

        while(firstDayPointer < firstDay.size() && nextDayPointer < lastDay.size()) {
            if (firstDay.get(firstDayPointer) < firstDay.get(nextDayPointer)) {
                meetings++;
            }

            firstDayPointer++;
            nextDayPointer++;
        }

        return meetings;
    }

    /*
        For each match in Team B, compute the total number of matches of team A where team A has scored less
        than or equal to the number of points scored by team B in that match.
     */
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        // Write your code here
        List<Integer> output = new ArrayList<>();
        if (teamA.size() == 0 || teamB.size() == 0) {
            return output;
        }

        int count = 0;

        for (int i = 0; i < teamB.size(); i++) {
            for (int j = 0; j < teamA.size(); j++) {
                if (teamA.get(j) <= teamB.get(i)) {
                    count++;
                }
            }
            output.add(count);
            count = 0;
        }

        return output;
    }

    public static String compressWord(String word, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        int count = 0, nextLetter = 1, currentLetter = 0;
        //abbcccb
        while (nextLetter < sb.length() && currentLetter < sb.length()) {
            if (sb.charAt(nextLetter) == sb.charAt(currentLetter)) {
                count++;
                nextLetter++;
            } else {
                currentLetter++;
                count = 0;
            }

            if (count == k) {
                sb.delete(currentLetter, nextLetter);
                count = 0;
                nextLetter = 1;
                currentLetter = 0;
            }
        }

        return sb.toString();
    }

    public static int reduceCapacity(List<Integer> model) {
        // Write your code here
        double generators = model.size() / 2.0;
        double ceiling = Math.ceil(generators);
        HashMap<Integer, Integer> map = new HashMap<>();
        int deactiveCount = 1;

        for (int m: model) {
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        for (int i = 0; i < model.size(); i++) {
            for (int j = 1; j < model.size(); j++) {
                if (map.get(model.get(i)) + map.get(model.get(j)) >= ceiling) {
                    deactiveCount++;
                    return deactiveCount;
                }
            }
        }

        return deactiveCount;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(10);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(7);
        list.add(1);

        String newWord = compressWord("abbcccb", 3);
        System.out.println("newWord: " + newWord);
    }
}
