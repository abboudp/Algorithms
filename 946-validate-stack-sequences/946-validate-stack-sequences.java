class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIdx = 0;
        int popIdx = 0;
        
        Stack<Integer> stack = new Stack<>();

        while (pushIdx < pushed.length || popIdx < popped.length) {
            if (!stack.isEmpty() && popIdx < popped.length && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            } else if (pushIdx < pushed.length) {
                stack.push(pushed[pushIdx]);
                pushIdx++;
            } else {
                break;
            }
        }
        
        return pushIdx == pushed.length && popIdx == popped.length && stack.isEmpty();
    }
}