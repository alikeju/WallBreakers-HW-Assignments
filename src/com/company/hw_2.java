package com.company;
import java.util.*;

public class hw_2 {
    /*
        Problem: https://leetcode.com/problems/unique-morse-code-words/
     */
    //---------------------------------------------- HashMaps and Sets -------------------------------------------------
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> hs = new HashSet<>();
        int answer = 0;

        for (String word: words){

            char[] cArray = word.toCharArray();
            StringBuilder morsedWord = new StringBuilder();

            for (char c: cArray){
                morsedWord.append(morseCode[(int) c - 97]);
            }

            if (hs.add(morsedWord.toString())){
                answer++;
            }

        }

        return answer;
    }

    /*
        Problem: https://leetcode.com/problems/jewels-and-stones/
    */
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet();

        for (int i = 0; i < J.length(); i++){
            jewels.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++){
            if (jewels.contains(S.charAt(i))){
                count++;
            }
        }

        return count;
    }

    /*
        Problem: https://leetcode.com/problems/word-pattern/
        Source: https://leetcode.com/problems/word-pattern/discuss/507593/Java-HashMap-Solution-or-100-Time
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
        Problem: https://leetcode.com/problems/set-mismatch
        Source: https://leetcode.com/problems/set-mismatch/solution/
     */
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int dup = 0, missing = 0;

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++){
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                missing = i;
            }
        }

        return new int[]{dup, missing};
    }

    /*
        Problem: https://leetcode.com/problems/intersection-of-two-arrays/
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++){
            if (map.containsKey(nums2[i]) && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != null){
                ans[i] = list.get(i);
            }
        }

        return ans;
    }

    /*
        Problem: https://leetcode.com/problems/sort-characters-by-frequency/
     */

    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
            public int compare (Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        //put data from sorted list into hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa: list){
            temp.put(aa.getKey(), aa.getValue());
        }

        return temp;
    }

    public String frequencySort(String s) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++){
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }

        HashMap<Character, Integer> hm = sortByValue(map);

        for (Map.Entry m: hm.entrySet()) {
            int value = (int) m.getValue();

            if (value > 1){
                for (int i = 0; i < value; i++){
                    answer.append(m.getKey());
                }
            } else {
                answer.append(m.getKey());
            }
        }

        return answer.reverse().toString();
    }
}
