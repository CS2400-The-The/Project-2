package com.jamesjhansen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for class Calc
 */
public class CalcTest extends Calc {

    /**
     * runs unit tests for convertToPostfix
     */
    @Test
    void convertToPostfixTest() {
        testConvert(0, "", "input expression empty!");
        testConvert(1,"A*B/(B+C)","AB*BC+/");
        testConvert(2,"(A/C)-B-B/E","AC/B-BE/-");
        testConvert(3,"(D+D-D)/D*C*C-(A+B)","DD+D-D/C*C*AB+-");
        testConvert(4,"A+B+C+D+E-(A*E*B*C)-A(D/A)","AB+C+D+E+AE*B*C*-ADA/-");
    }

    /**
     * runs unit tests for evaluatePostfix
     */
    @Test
    void evaluatePostfixTest() {
        testConvert(0, "", "input expression empty!");
        testEvaluate(1,"231*+3-",2);
        testEvaluate(2,"34+2*7/",2);
        testEvaluate(3,"39+96-/",4);
        testEvaluate(4,"521+4*+3-",14);
    }

    /**
     * tests method convertToPostfix
     * @param trial test number
     * @param infix input expression
     * @param postfix expected output
     */
    public static void testConvert(int trial, String infix, String postfix){
        System.out.println("Test: " + trial);
        System.out.println("Infix Expression: " + infix);
        System.out.println("Expected postfix expression: " + postfix);
        System.out.println("Resulting postfix expression: " + convertToPostfix(infix));
        assertEquals(postfix,convertToPostfix(infix));
        System.out.println();
    }

    /**
     * tests method convertToPostfix
     * @param trial test number
     * @param postfix input expression
     * @param expectedValue expected output
     */
    public static void testEvaluate(int trial, String postfix, int expectedValue){
        System.out.println("Test: " + trial);
        System.out.println("Postfix expression: " + postfix);
        System.out.println("Expected value: " + postfix);
        System.out.println("Resulting postfix expression: " + evaluatePostfix(postfix));
        assertEquals(expectedValue,evaluatePostfix(postfix));
        System.out.println();
    }
}
