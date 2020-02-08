package com.company;
import java.util.*;

public class hw_1 {

    //---------------------------------------------- Arrays ------------------------------------------------------------
    /*
        Problem Description: Given an array A of non-negative integers,
        return an array consisting of all the even elements of A, followed by all the odd elements of A.
        Link: https://leetcode.com/problems/sort-array-by-parity/
    */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int evenIndex = 0;
        int oddIndex = A.length - 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[evenIndex] = A[i];
                evenIndex++;
            } else {
                result[oddIndex] = A[i];
                oddIndex--;
            }
        }

        return result;
    }

    /*
       Link: https://leetcode.com/problems/transpose-matrix/
    */
    public int[][] transpose(int[][] A) {
        int R = A[0].length;
        int C = A.length;
        int[][] ans = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[i][j] = A[j][i];
            }
        }

        return ans;
    }

    /*
        Link: https://leetcode.com/problems/flipping-an-image/
    */
    public int[][] flipAndInvertImage(int[][] A) {
         /*

        1) Go through each row in the two-dim Array
        2) Reverse the row in the array
        3) After reversing it, I will invert it.
    */

        int R = A[0].length;

        for (int[] row : A) {
            for (int j = 0; j < (R + 1) / 2; j++) {
                int tmp = row[j] ^ 1;
                row[j] = row[R - 1 - j] ^ 1;
                row[R - 1 - j] = tmp;
            }
        }

        return A;
    }

    //---------------------------------------------- Basic Math --------------------------------------------------------
    /*
        Link: https://leetcode.com/problems/fizz-buzz/
    */

    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            if (i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            } else if (i % 5 == 0){
                list.add("Buzz");
            } else if (i % 3 == 0){
                list.add("Fizz");
            } else {
                list.add(Integer.toString(i));
            }
        }

        return list;
    }

    //---------------------------------------------- Strings -----------------------------------------------------------
    /*
        Link: https://leetcode.com/problems/reverse-string/
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    /*
        Link: https://leetcode.com/problems/detect-capital/
     */
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase() == word || word.length() == 1) {
            return true;
        }

        int index = 1;

        for (int i = 0; i < word.length(); i++) {
            char firstChar = word.charAt(0);
            boolean isUpper = Character.isUpperCase(firstChar);

            char rest = word.charAt(index);

            if ((isUpper == true && Character.isUpperCase(rest) == true) || (isUpper == false && Character.isUpperCase(rest) == true)) {
                return false;
            }

            if (index < word.length() - 1) {
                index++;
            }

        }

        return true;
    }

    /*
        Link: https://leetcode.com/problems/valid-palindrome/
    */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String loCaseS = s.toLowerCase();

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(loCaseS.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(loCaseS.charAt(j))) {
                j--;
            }

            if (i < j && loCaseS.charAt(i) != loCaseS.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    /*
        Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
     */
    public String reverseWords(String s) {

        StringBuilder word = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) != ' '){
                word.append(s.charAt(i));
            } else{
                answer.append(word.reverse());
                answer.append(" ");
                word.setLength(0);
            }
        }

        answer.append(word.reverse());
        return answer.toString();
    }

    //---------------------------------------------- Map or Sets -------------------------------------------------------
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (char ch: s.toCharArray()){
            if (mapS.containsKey(ch)){
                mapS.put(ch, mapS.get(ch) + 1);
            } else {
                mapS.put(ch, 1);
            }
        }

        for (char ch: t.toCharArray()){
            if (mapT.containsKey(ch)){
                mapT.put(ch, mapT.get(ch) + 1);
            } else {
                mapT.put(ch, 1);
            }
        }

        return mapS.equals(mapT);
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
