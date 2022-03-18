package com.jamesjhansen;

public class Calc {

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * returns (order of operation) precedence for arithmetic operators
     * @param ch character (should be an operator)
     * @return integer representation of precedence (higher precedence for higher ints)
     */
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return 0;
    }

    /**
     * converts a string expression in infix form to postfix form
     * @param infixExp String: input (should be infix expression)
     * @return String: converted (postfix) expression)
     */
    public static String convertToPostfix(String infixExp) {
        LinkedStack<Character> charStack = new LinkedStack<>();
        String postfixExp = "";
        char[] chars = infixExp.toCharArray();

        if (!infixExp.isEmpty()) {
            for (char ch: chars) {
                if (Character.isLetterOrDigit(ch))
                    postfixExp += ch;
                else if (ch == '(')
                    charStack.push('(');
                else if (ch == ')') {
                    while (!charStack.isEmpty() && charStack.peek() != '(') {
                        postfixExp += charStack.pop();
                    }
                    charStack.pop();
                } else {
                    while (!charStack.isEmpty() && precedence(ch) <= precedence(charStack.peek())) {
                        postfixExp += charStack.pop();
                    }
                    charStack.push(ch);
                }
            }
        } else
            postfixExp = "input string empty!";

        while (!charStack.isEmpty()) {
            postfixExp += charStack.pop();
        }
        return postfixExp;
    }
}
