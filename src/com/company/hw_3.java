package com.company;

public class hw_3 {
    /*
        Problem: https://leetcode.com/problems/is-subsequence/submissions/
        Source: https://leetcode.com/problems/is-subsequence/discuss/493859/Java-3ms-simple-solution
     */
    public boolean isSubsequence(String s, String t) {

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(t.indexOf(c) != -1) {
                t = t.substring(t.indexOf(c) + 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
