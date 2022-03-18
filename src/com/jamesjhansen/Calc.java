package com.jamesjhansen;

/**
 * contains methods convertToPostfix and evaluatePostfix as well as a demo of their usage
 */
public class Calc {

    /**
     * demonstrates basic usage of postfix methods
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String infixExp = "2*3/(4-2)+5*6";
        String postfixExp = convertToPostfix(infixExp);
        int result = evaluatePostfix(postfixExp);
        System.out.println("Infix Expression: " + infixExp);
        System.out.println("Converted to Postfix: " + postfixExp);
        System.out.println("Result: " + result);
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
            postfixExp = "input expression empty!";

        while (!charStack.isEmpty()) {
            postfixExp += charStack.pop();
        }
        return postfixExp;
    }

    /**
     * evaluates integer expression in postfix form
     * @param postfixExp String: arithmetic expression in postfix form
     * @return int: result of evaluation
     */
    public static int evaluatePostfix(String postfixExp) {
        ArrayStack<Integer> intStack = new ArrayStack<>();
        char[] chars = postfixExp.toCharArray();

        if (!postfixExp.isEmpty()) {
            for (char ch: chars) {
                if (Character.isDigit(ch))
                    intStack.push(Character.getNumericValue(ch));
                else {
                    int a = intStack.pop();
                    int b = intStack.pop();
                    switch (ch) {
                        case '+': intStack.push(a+b);
                        break;
                        case '-': intStack.push(b-a);
                        break;
                        case '*': intStack.push(a*b);
                        break;
                        case '/': intStack.push(b/a);
                        break;
                    }
                }
            }
           return intStack.pop();
        } else {
            System.out.println("input expression empty!");
            return 0;
        }
    }

}
