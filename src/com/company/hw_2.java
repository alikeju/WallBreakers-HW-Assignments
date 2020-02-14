package com.company;
import java.util.*;

public class hw_2 {
    /*
        Problem: https://leetcode.com/problems/unique-morse-code-words/
     */
    //---------------------------------------------- HashMaps and Sets -------------------------------------------------
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> hs = new HashSet<>();
        int answer = 0;

        for (String word: words){

            char[] cArray = word.toCharArray();
            StringBuilder morsedWord = new StringBuilder();

            for (char c: cArray){
                morsedWord.append(morseCode[(int) c - 97]);
            }

            if (hs.add(morsedWord.toString())){
                answer++;
            }

        }

        return answer;
    }

    /*
        Problem: https://leetcode.com/problems/jewels-and-stones/
    */
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet();

        for (int i = 0; i < J.length(); i++){
            jewels.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++){
            if (jewels.contains(S.charAt(i))){
                count++;
            }
        }

        return count;
    }
}
