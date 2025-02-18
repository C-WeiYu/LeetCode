class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-")  || str.equals("*") || str.equals("/")){
                int y = stack.pop();
                int x = stack.pop();
                int newInt ;
                switch (str){
                    case "+" :
                        newInt = x + y;
                        break;
                    case "-" :
                        newInt = x - y;
                        break;
                    case "*" :
                        newInt = x * y;
                        break;
                    default :
                        newInt = x / y;
                }
                stack.push(newInt);
            }
            else{
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
