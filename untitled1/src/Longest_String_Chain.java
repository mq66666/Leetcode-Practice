import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Longest_String_Chain {
    int longeststrchain(String[] words){
        Arrays.sort(words, (s1,s2)->s1.length()-s2.length());
        int[][] liebiao = new int[words.length][words.length];
        HashMap<String, Integer> haxibiao = new HashMap();
        int max = 0;

        for(int i= 0;i<=words.length-1;i++){
            int same = 0;
            for (int j = i;j<=words.length-1;j++){
                if(i ==j){
                    liebiao[i][j] = haxibiao.getOrDefault(words[j],1);
                    same = liebiao[i][j];
                }
                if(words[i].length() == words[j].length()-1){
                    if(contain(words[i],words[j])){
                        liebiao[i][j] = same+1;
                        haxibiao.put(words[j],same+1);
                    }
                }
                if( max<liebiao[i][j]){
                    max = liebiao[i][j];
                }
            }same = 0;
        }
        return max;
    }
    public boolean contain(String s1,String s2){
        int i = 0, j = 0, blank = 0;
        while(i < s1.length() && j < s2.length())
        {
            if(s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
                blank++;
            }
        }
        return blank == 1 || blank == 0;


    }

}
