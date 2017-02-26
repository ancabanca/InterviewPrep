package com.github.ancabanca.interviewprep.problems;

import java.util.Arrays;

/**
 * Stack with push and pop operations that also supports a getMax operation.
 */
public class MaxStack {
    private Integer[] stack;
    private Integer[] max;

    private int stackPosition;
    private int maxPosition;

    public MaxStack() {
        stack = new Integer[20];
        max = new Integer[20];
    }

    public void push(int value) {
        stack[stackPosition++] = value;
        if(maxPosition == 0 || max[maxPosition-1] < value)
            max[maxPosition++] = value;
        System.out.println(toStringDebug());
    }

    public int pop() {
        int result = stack[--stackPosition];
        if(result == max[maxPosition-1])
            maxPosition--;
        System.out.println(toStringDebug());
        return result;
    }

    public int max() {
        return max[maxPosition-1];
    }

    public String toStringDebug() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        for(int i = 0; i < stackPosition; i++)
            sb.append(stack[i] + " ");

        sb.append("\nMaxStack: ");
        for(int i = 0; i < maxPosition; i++)
            sb.append(max[i] + " ");

        sb.append("\nMax: " + max() + "\n");

        return new String(sb);
    }

    public static void main(String[] args) {
        MaxStack s = new MaxStack();
        s.push(2);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(8);
        s.push(3);
        s.pop();
        s.pop();
        s.push(9);
    }
}