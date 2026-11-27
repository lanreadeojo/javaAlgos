import java.util.ArrayDeque;
import java.util.Deque;

class SolutionValidParenthesis {
    Deque<Character> stack = new ArrayDeque<>();

    public boolean isValid(String s) {
        return anOptimalSolution(s);
    }

    private boolean anOptimalSolution(String s) {
        Character currentBracket;
        Character openBracket;
        for (int i = 0; i < s.length(); i++) {
            currentBracket = s.charAt(i);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                openBracket = stack.peek();
                stack.pop();
                if (openBracket == '(' && currentBracket != ')'
                        || openBracket == '{' && currentBracket != '}'
                        || openBracket == '[' && currentBracket != ']') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}