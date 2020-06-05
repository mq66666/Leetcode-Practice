import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] b = new boolean[s.length()+1];
            Set<String> set = new HashSet<String>();
            for (String word : wordDict) {
                set.add(word);
            }
            b[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (b[j] && set.contains(s.substring(j, i))) {
                        b[i] = true;
                        break;
                    }
                }
            }
            return b[s.length()];


        }
    }
}
