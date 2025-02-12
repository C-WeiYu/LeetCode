class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(stack.empty() || stack.peek() != ch){
                stack.push(ch);
            }
            else{
                stack.pop();
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();   
    }
}
