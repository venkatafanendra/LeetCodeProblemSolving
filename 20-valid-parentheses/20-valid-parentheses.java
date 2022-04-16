class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char it : s.toCharArray()){
            if(it=='(' || it=='{' || it =='[')
                stack.push(it);
            else {
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(top=='(' && it==')' || top=='{' && it=='}' || top=='[' && it==']' )
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}