class findBalancedExpression {
    static int top = -1;
    static int limit = 1000;
    static char myStack[] = new char[limit];

    public static boolean isBalanced(String expr, int len) {
        if (expr == null || len % 2 == 1) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            char p = expr.charAt(i);
            if (p == '(' || p == '{' || p == '[') {
                push(p);
            }

            if (p == ')' || p == '}' || p == ']') {
                if (isEmpty()) {
                    return false;
                }

                char top = pop();

                if ((top == '(' && p != ')') || (top == '{' && p != '}') || (top == '[' && p != ']')) {
                    return false;
                }
            }
        }
        return isEmpty();
    }

    public static void push(char p) {
        top++;
        myStack[top] = p;
    }

    public static char pop() {
        char c = myStack[top];
        top--;
        return c;
    }

    public static boolean isFull() {
        if (top == (limit - 1))
            return true;
        else
            return false;
    }

    public static boolean isEmpty() {
        if ((top == -1))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String expr = "{t[(a+b)*(c+d)]}";
        int len = expr.length();

        if (isBalanced(expr, len))
            System.out.println("This expression is balanced ");
        else
            System.out.println("This expression is not Balanced ");
    }
}