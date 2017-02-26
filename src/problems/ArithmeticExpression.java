package com.github.ancabanca.interviewprep.problems;

import com.github.ancabanca.interviewprep.util.Stack;
import com.github.ancabanca.interviewprep.util.LinkedListStack;

public class ArithmeticExpression {
    private String expression;

    public ArithmeticExpression(String s) {
        expression = s;
    }

    public boolean checkParantheses() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Dijkstra's algorithm for evaluating an arithmetic expression.
     * @return the value obtained after evaluating the current arithmetic expression
     */
    public int evaluate() {
        Stack<Integer> valueStack = new LinkedListStack<Integer>();
        Stack<String> operatorStack = new LinkedListStack<String>();

        String[] tokens = expression.split(" ");
        for(String token : tokens) {
            // System.out.println("Parsing " + token);
            if(token.equals("("))
                continue;
            else if(token.equals(")")) {
                Integer y = valueStack.pop();
                Integer x = valueStack.pop();
                String operator = operatorStack.pop();
                valueStack.push(performOperation(x,y,operator));
                continue;
            }
            else if("+-*/".contains(token)) {
                operatorStack.push(token);
                continue;
            }

            try {
                Integer i = Integer.parseInt(token);
                valueStack.push(i);
            }
            catch(NumberFormatException e) {
                throw new IllegalArgumentException("Arithmetic expression has bad format: " + token);
            }
            // System.out.println("Value stack: " + valueStack);
            // System.out.println("Operator stack: " + operatorStack);
        }
        try {
           int result = valueStack.pop();
           return result;
        }
        catch(Exception e) {
            throw new IllegalArgumentException("Arithmetic expression has bad format.");
        }
    }

    private Integer performOperation(Integer x, Integer y, String c) {
        switch(c) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + c);
        }
    }
}