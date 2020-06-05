import java.util.*;

public class Concatenated_Words {
    static class Solution {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            int min = 0;
            int max = 0;
            if (words.length < 2) {
                return new ArrayList<>();
            }
            for (String word : words) {
                min = Math.min(word.length(), min);
                max = Math.max(word.length(), max);
            }
            if (max < min * 2) return new ArrayList<>();

            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                if (word.length() + min > max) continue;
                set.add(word);
            }
            HashMap<String, Boolean> map = new HashMap<>();
            List<String> sl = new ArrayList<String>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() < min * 2) continue;
                if (helper(words[i], set, map, false)) {
                    sl.add(words[i]);
                }
            }

            return sl;
        }

        boolean helper(String s, HashSet set, HashMap<String, Boolean> map, Boolean issubstring) {
            if (issubstring && set.contains(s)) return true;
            if (map.containsKey(s)) return  map.get(s);
            for (int i = 1; i < s.length(); i++) {
                String tailstring = s.substring(i);
                if (set.contains(tailstring)) {
                    if (helper(s.substring(0, i), set, map, true)) {
                        map.put(s, true);
                        return true;
                    }
                }
            }
            map.put(s,false);
            return false;
        }
    }



    public static void main(String[] args) {
        Solution sl = new Solution();
        String[] s = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(sl.findAllConcatenatedWordsInADict(s));
    }
}
