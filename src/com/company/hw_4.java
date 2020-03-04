package com.company;
import java.util.*;

public class hw_4 {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        int score = 0;

        for (String op: ops){
            if (op.equals("C")) {
                score = score - st.lastElement();
                st.pop();
            } else if (op.equals("D")) {
                st.push(st.lastElement() + st.lastElement());
                score = score + (st.lastElement());
            } else if (op.equals("+")) {
                int lastElement = st.lastElement();
                st.pop();
                int secLastElement = st.lastElement();
                st.push(lastElement);
                int sum = lastElement + secLastElement;
                st.push(sum);
                score = score + sum;
            } else {
                score += Integer.parseInt(op);
                st.push(Integer.parseInt(op));
            }
        }

        return score;
    }

    /*
        First Approach
     */

    public boolean isValid2(String s) {
        int lefParen = 0;
        int rightParen = 0;
        int lefCurly = 0;
        int rightCurly = 0;
        int lefBrace = 0;
        int rightBrace = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') {
                lefParen++;
            } else if (c == ')') {
                rightParen++;
            } else if (c == '{') {
                lefCurly++;
            } else if (c == '}') {
                rightCurly++;
            } else if (c == '[') {
                lefBrace++;
            } else {
                rightBrace++;
            }
        }

        if (lefParen == rightParen && lefCurly == rightCurly && lefBrace == rightBrace) {
            return true;
        } else {
            return false;
        }
    }

    /*
        Correct Answer
     */

    private HashMap<Character, Character> mappings;

    public hw_4() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char paren: s.toCharArray()){
            if (this.mappings.containsKey(paren)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(paren)) {
                    return false;
                }

            } else {
                stack.push(paren);
            }
        }

        return stack.isEmpty();
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char c: S.toCharArray()) {
            if (c == '#')  {
                if (!stackS.isEmpty()){
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }

        for (char c: T.toCharArray()) {
            if (c == '#')  {
                if (!stackT.isEmpty()){
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }

        return stackS.equals(stackT);

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++){
            while(!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])) {
                answer[i] = map.get(nums1[i]);
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }

}
