package Etapa3;

public class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {
        StaticStack<Character> stack = new StaticStack<>(s1.numElements());

        while (!s1.isEmpty()) {
            try {
                char ch = s1.pop();
                if (ch == '(') {
                    if (stack.isEmpty() || stack.pop() != ')') {
                        return false;
                    }
                } else if (ch == ')') {
                    stack.push(ch);
                }
            } catch (UnderflowException | OverflowException e) {
                e.printStackTrace();
                return false;
            }
        }
        return stack.isEmpty();
    }
}


