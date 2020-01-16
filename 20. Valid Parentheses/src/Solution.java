import java.util.Stack;

public class Solution {
    public boolean validParentheses(String s){
        if (s == null || s == ""){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else {
                if (s.isEmpty()){
                    return false;
                }
                char last_char = stack.pop();
                if (c == '(' && last_char != ')'){
                    return false;
                }
                if (c == '[' && last_char != ']'){
                    return false;
                }
                if (c == '{' && last_char != '}'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
