import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decode_String {
    static class Solution {
        String s;
        int start = 0;

        public String decodeString(String s) {
            this.s = s;
            return decode_helper();

        }

        public String decode_helper() {
            StringBuilder sb = new StringBuilder();
            while(start<s.length()){
                if(s.charAt(start) == ']'){

                    start++;
                    return sb.toString();

                }

                if(Character.isDigit(s.charAt(start))){
                    StringBuilder digit = new StringBuilder();
                    while(Character.isDigit(s.charAt(start))){
                        digit.append(s.charAt(start));
                        start++;
                    }
                    int count = Integer.parseInt(digit.toString());
                    start = start+1;
                    String new_s = decode_helper();
                    for(int t = 1;t<=count;t++){
                        sb.append(new_s);
                    }

                    continue;
                }
                sb.append(s.charAt(start));
                start=start+1;
                continue;


            }
            return sb.toString();

        }
    }

    public static void main(String[] args) {
        String t = new Solution().decodeString("100[leetcode]");
        System.out.println(t);
    }
}
