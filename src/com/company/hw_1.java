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

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else {
                list.add(Integer.toString(i));
            }
        }

        return list;
    }

    /*
        Link: https://leetcode.com/problems/power-of-two/
    */

    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            while (n % 2 == 0) {
                n = n / 2;
            }

            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    /*
    Link: https://leetcode.com/problems/self-dividing-numbers/
    Source: https://leetcode.com/problems/self-dividing-numbers/solution/
*/
    public boolean isSelfDividing(int num){

        for (char c: String.valueOf(num).toCharArray()){

            if (c == '0' || num % Character.getNumericValue(c) > 0){
                return false;
            }
        }

        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> self_dividing_nums = new ArrayList<>();

        for (int i = left; i <= right; i++){
            if (isSelfDividing(i)){
                self_dividing_nums.add(i);
            }
        }

        return self_dividing_nums;
    }
    /*
        Link: https://leetcode.com/problems/excel-sheet-column-number/submissions/
    */

    public int titleToNumber(String s) {
        int columnNumber = 0;
        int twentysix = 26;

        if (s.length() == 1){
            return (int)s.charAt(0) - 65 + 1;
        }

        char[] c = s.toCharArray();

        for (int i = c.length - 1; i >= 0; i--) {

            if (i == c.length - 1){
                columnNumber += (int)s.charAt(i) - 65 + 1;

            } else {
                columnNumber += twentysix * ((int)s.charAt(i) - 65 + 1);
                twentysix *= 26;
            }

        }

        return columnNumber;
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
        Source: https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
     */
    public String reverseWords(String s) {

        StringBuilder word = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                answer.append(word.reverse());
                answer.append(" ");
                word.setLength(0);
            }
        }

        answer.append(word.reverse());
        return answer.toString();
    }

    /*
        Source:
     */
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();

        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');

        int sIndex = 0;
        int eIndex = s.length() - 1;

        char[] c = s.toCharArray();

        while (sIndex < eIndex) {
            while (sIndex < eIndex && !vowels.contains(c[sIndex])) {
                sIndex++;
            }

            while (sIndex < eIndex && !vowels.contains(c[eIndex])) {
                eIndex--;
            }

            char tmp = c[sIndex];
            c[sIndex] = c[eIndex];
            c[eIndex] = tmp;
            sIndex++;
            eIndex--;
        }

        String ans = new String(c);

        return ans;
    }

    /*
        Link: https://leetcode.com/problems/longest-common-prefix/
    */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder lcp = new StringBuilder(); //lcp: longestCommonPrefix

        if (strs == null || strs.length == 0){
            return lcp.toString();
        }

        int index = 0;

        for (char c: strs[0].toCharArray()){

            for (int i = 1; i < strs.length; i++){
                if (index >= strs[i].length() || c != strs[i].charAt(index)){
                    return lcp.toString();
                }
            }

            lcp.append(c); //lcp = lcp + c;
            index++;
        }

        return lcp.toString();
    }

    //---------------------------------------------- Bitwise Manipulation ----------------------------------------------
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for (int n: nums){
            if (!set.add(n)){
                set.remove(n);
            }
        }

        Iterator<Integer> it = set.iterator();
        return it.next();
    }

    /*
        Link: https://leetcode.com/problems/number-complement/
        Source: https://www.youtube.com/watch?v=oURSuMY4zSc
     */
    public int findComplement(int num) {
        int result = 0;
        int power = 1;

        while (num > 0){
            result += (num % 2 ^ 1) * power;
            power <<= 1;
            num >>= 1;
        }

        return result;
    }

    //---------------------------------------------- Map or Sets -------------------------------------------------------
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (mapS.containsKey(ch)) {
                mapS.put(ch, mapS.get(ch) + 1);
            } else {
                mapS.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (mapT.containsKey(ch)) {
                mapT.put(ch, mapT.get(ch) + 1);
            } else {
                mapT.put(ch, 1);
            }
        }

        return mapS.equals(mapT);
    }

    /*
        Source:
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
