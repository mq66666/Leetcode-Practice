import java.util.Stack;

public class ValidParenth {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s==null){
            return true;
        }
        for(int i = 0; i<= s.length()-1; i++){
            if(s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }
            if(st.empty()){
                return false;
            }
            if(s.charAt(i)==')'){
                if(st.peek()=='('){
                    st.pop();
                }else{return false;}
            }
            if(s.charAt(i)==']'){
                if(st.peek()=='['){
                    st.pop();
                }else{return false;}
            }
            if(s.charAt(i)=='}'){
                if(st.peek()=='{'){
                    st.pop();
                }else{return false;}
            }
        }
        if(st.empty()){
            return true;
        }else{return false;}

    }
}

