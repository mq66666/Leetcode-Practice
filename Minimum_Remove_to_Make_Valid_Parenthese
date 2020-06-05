public class Minimum_Remove_to_Make_Valid_Parenthese {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> del = new Stack<>();
            int p;
            for (int i = 0; i <= s.length() - 1; i++) {
                if (s.charAt(i) == ')' || s.charAt(i) == '(') {
                    stack.push(i);
                }
            }
            while(!stack.isEmpty()) {
                p = stack.pop();
                if (!del.isEmpty() && s.charAt(p) == '(' && s.charAt(del.peek()) == ')') del.pop();
                else del.push(p);
            }
            while(!del.isEmpty()){
                p = del.pop();
                stack.push(p);
            }
            while(!stack.isEmpty()){
                p = stack.pop();
                s = s.substring(0, p) + s.substring(p + 1);
            }
            return s;
        }
    }
}
