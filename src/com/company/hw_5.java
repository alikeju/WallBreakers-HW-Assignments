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
}
