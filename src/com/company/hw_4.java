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

    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {

            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack2.push(x);

            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }
    }

    class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q2.add(x);

            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }


}
