package com.company;
import javax.swing.tree.*;
import java.util.*;
import javafx.scene.*;

public class hw_5 {

    int sum = 0;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;
    }

    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.addFirst(node.val);

            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }

        return output;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }

            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] c = new int[numCourses]; //in-degrees
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] courses: prerequisites) {
            int course = courses[0], prereqCourse = courses[1];
            c[course]++;
            if (!graph.containsKey(prereqCourse)) {
                graph.put(prereqCourse, new ArrayList());
            }

            graph.get(prereqCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        //Pick all the vertices with indegree as 0 and add them to the queue
        for (int i = 0; i < numCourses; i++) {
            if (c[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();

            if (graph.containsKey(course)) {
                for (int neigh: graph.get(course)) {
                    if (--c[neigh] == 0) {
                        queue.offer(neigh);
                    }
                }
            }

            count++;
        }

        return count == numCourses;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] c = new int[numCourses]; //in-degrees
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] courses: prerequisites) {
            int course = courses[0], prereqCourse = courses[1];
            c[course]++;
            if (!graph.containsKey(prereqCourse)) {
                graph.put(prereqCourse, new ArrayList());
            }

            graph.get(prereqCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        ArrayList<Integer> topOrder = new ArrayList<>();

        while(!queue.isEmpty()) {
            int course = queue.poll();
            topOrder.add(course);

            if (graph.containsKey(course)) {
                for (int neigh : graph.get(course)) {
                    if (--c[neigh] == 0) {
                        queue.offer(neigh);
                    }
                }
            }

            count++;
        }

        if (count != numCourses) {
            return new int[]{};
        }

        int[] courses = new int[numCourses];
        for (int i = 0; i < topOrder.size(); i++) {
            courses[i] = topOrder.get(i);
        }

        return courses;
    }

    public String alienOrder(String[] words) {
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                char c1 = words[i].charAt(index);
                char c2 = words[i + 1].charAt(index); //compare two chars with same index
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
                index++;
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            char letter = queue.poll();
            sb.append(letter);

            if (graph.containsKey(letter)) {
                for (char neigh: graph.get(letter)) {
                    inDegree.put(neigh, inDegree.get(neigh) - 1);
                    if (inDegree.get(neigh) == 0) {
                        queue.offer(neigh);
                    }
                }
            }

            count++;
        }

        if (count != graph.size()) {
            return "";
        }

        return sb.toString();
    }
}
