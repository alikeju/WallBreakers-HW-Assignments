package com.company;
import java.util.*;

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

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int a_pointer = 0;
        int b_pointer = 0;

        while (a_pointer < g.length && b_pointer < s.length){
            if (g[a_pointer] <= s[b_pointer]){
                a_pointer++;
                b_pointer++;
            } else {
                b_pointer++;
            }
        }

        return a_pointer;
    }
}
