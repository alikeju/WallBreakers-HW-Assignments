package com.company;

public class hw_1 {

    //---------------------------------------------- Arrays ------------------------------------------------------------
    /*
        Problem Description: Given an array A of non-negative integers,
        return an array consisting of all the even elements of A, followed by all the odd elements of A.
        Link: https://leetcode.com/problems/sort-array-by-parity/
    */
    public int[] sortArrayByParity(int[] A){
        int[] result = new int[A.length];
        int evenIndex = 0;
        int oddIndex = A.length -  1;

        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0){
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

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
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

        for (int[] row: A){
            for (int j = 0; j < (R + 1)/2; j++){
                int tmp = row[j] ^ 1;
                row[j] = row[R - 1 - j] ^ 1;
                row[R - 1 - j] = tmp;
            }
        }

        return A;
    }

    //---------------------------------------------- Strings -----------------------------------------------------------
    /*
        Link: https://leetcode.com/problems/reverse-string/
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++){
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    /*
        Link: https://leetcode.com/problems/detect-capital/
     */
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase() == word || word.length() == 1){
            return true;
        }

        int index = 1;

        for (int i = 0; i < word.length(); i++){
            char firstChar = word.charAt(0);
            boolean isUpper = Character.isUpperCase(firstChar);

            char rest = word.charAt(index);

            if ((isUpper == true && Character.isUpperCase(rest) == true) || (isUpper == false && Character.isUpperCase(rest) == true)) {
                return false;
            }

            if (index < word.length() - 1){
                index++;
            }

        }

        return true;
    }
}
