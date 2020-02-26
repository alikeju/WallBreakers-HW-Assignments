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

    /*
        Problem: https://leetcode.com/problems/valid-anagram/solution/
     */
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

    /*
        Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
        Source: https://leetcode.com/problems/find-all-anagrams-in-a-string/solution/
     */
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        int pL = p.length();
        int sL = s.length();

        List<Integer> answer  = new ArrayList<>();

        for (int i = 0; i < p.length(); i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (i >= pL) {
                c = s.charAt(i - pL);
                if (sMap.get(c) == 1) {
                    sMap.remove(c);
                } else {
                    sMap.put(c, sMap.get(c) - 1);
                }
            }

            if (pMap.equals(sMap)) {
                answer.add(i - pL + 1);
            }
        }

        return answer;
    }

    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /*
        Problem: https://leetcode.com/problems/partition-labels/
        Source: https://leetcode.com/problems/partition-labels/solution/
     */
    public List<Integer> partitionLabels(String S) {
        //get the last seen index for each letter 'a' - 'z'
        HashMap<Character, Integer> last_seen = new HashMap<>();

        for (int i = 0; i < S.length(); i++){
            last_seen.put(S.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();

        Integer end = 0, begin = 0;

        for (int i = 0; i < S.length(); i++){
            Integer index = last_seen.get(S.charAt(i));

            if (index.intValue() > end.intValue()) {
                end = index;
            }

            if (i == end.intValue()) {
                ans.add(end.intValue() - begin.intValue() + 1);
                begin = i + 1;
            }
        }

        return ans;
    }

    /*
        Problem: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] currentBalloon = points[0];
        int minArrows = 1;

        for (int[] point: points){
            int previousBalloonPosition = currentBalloon[1];
            int nextBalloonPosition = point[0];

            if (nextBalloonPosition > previousBalloonPosition) {
                minArrows++;
                currentBalloon = point;
            }
        }

        return minArrows;
    }

    /*
        Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/
     */
    public int peakIndexInMountainArray(int[] A) {
        int largestNumber = 0;

        for (int i = 0; i < A.length; i++){
            if (A[largestNumber] < A[i]){
                largestNumber = i;
            }
        }

        return largestNumber;
    }

    /*
        Problem: https://leetcode.com/problems/merge-intervals/
        Source: https://www.youtube.com/watch?v=qKczfGUrFY4
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> ans = new ArrayList<>();
        int[] currentInterval = intervals[0];
        ans.add(currentInterval);

        for (int[] interval: intervals){
            int currentEndPoint = currentInterval[1];
            int currentStartPoint = currentInterval[0];

            int nextStartPoint = interval[0];
            int nextEndPoint = interval[1];

            if (currentEndPoint >= nextStartPoint) {
                currentInterval[1] = Math.max(currentEndPoint, nextEndPoint);
            } else {
                currentInterval = interval;
                ans.add(currentInterval);
            }
        }

        return ans.toArray(new int[ans.size()][]);

    }
}
