import java.util.ArrayList;
import java.util.List;

public class Remove_invalide_parenthese {
    static class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int l = 0;
            int r = 0;
            List<String> ans = new ArrayList<>();
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    if(r>0){
                        r--;
                    }else{
                    l++;}
                }else if(s.charAt(i)==')'){
                    if(l==0){
                        r++;
                    }else{
                        l--;
                    }
                }
            }
            dfs(s,l,r,0,ans);
            return ans;

        }
        public void dfs(String s,int l,int r, int start, List<String> ans){
            if(l == r && l == 0){
                if(isValide(s)){
                    ans.add(s);
                    return;
                }
            }
            for(int i = start; i<s.length();i++){
                if(i!=start&&s.charAt(i) ==s.charAt(i-1)){
                    continue;
                }else if(s.charAt(i)=='('&& l>0){
                    StringBuilder sb = new StringBuilder(s);
                    sb.replace(i,i+1,"");
                    dfs(sb.toString(),l-1,r,i,ans);
                }else if (s.charAt(i)==')'&& r>0){
                    StringBuilder sb = new StringBuilder(s);
                    sb.replace(i,i+1,"");
                    dfs(sb.toString(),l,r-1,i,ans);
                }
            }
        }


        public boolean isValide(String s){
            int count = 0;
            for(int i = 0; i<s.length();i++){
                if(s.charAt(i) == '('){
                    count++;
                }else if(s.charAt(i) == ')'){
                    count--;
                    if(count<0){
                        return false;
                    }
                }
            }
            if(count>0){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        List<String>ans = sl.removeInvalidParentheses("()())()");
        System.out.println(ans);
    }
}
