/*
Overview:
1. Parse from left to right adding to the stack
2. When we encounter the first operator, we perform 
   the corresponding operation on the last two elements 
   in the stack
3. We then push the result of this operation and continue
   until the next operator, repeating evaluation
4. The last element in the stack will be the result
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        HashMap<String, Operator> map = new HashMap<>();
        map.put("+", new Add()); map.put("-", new Minus()); 
        map.put("*", new Multiply()); map.put("/", new Divide());
        for (int i = 0; i < tokens.length; i++) {
            if (map.containsKey(tokens[i])) {
                int b = s.pop();
                int a = s.pop();
                Operator oper = map.get(tokens[i]);
                s.push(oper.op(a, b));
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return s.pop();
    }
}

interface Operator{
    int op(int x, int y);
}


class Add implements Operator{
    @Override
    public int op(int x, int y) {
        return x+y;
    }
}

class Minus implements Operator{
    @Override
    public int op(int x, int y) {
        return x-y;
    }
}

class Multiply implements Operator{
    @Override
    public int op(int x, int y){
        return x*y;
    }
}

class Divide implements Operator{
    @Override
    public int op(int x, int y) {
        return x/y;
    }
}
