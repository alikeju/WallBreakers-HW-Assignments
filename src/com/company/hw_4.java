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
}
