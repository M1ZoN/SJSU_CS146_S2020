package com.company;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    // Return true if s has matching parentheses, and false otherwise.
    private static boolean match(String s) {
        Stack<Character>pt = new Stack<>();
        boolean error = false;

        for (int i = 0; !error && i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                pt.push(s.charAt(i));
            else
            {
                if (pt.peek() == pair(s.charAt(i)))
                    pt.pop();
                else
                    error = true;
            }
        }
        return (!error && pt.isEmpty());
    }

    private static char pair(char one) {
        char res = 'x';
        if (one == ')')
            res = '(';
        else if (one == ']')
            res = '[';
        else if (one == '}')
            res = '{';
        return (res);
    }

    // Test client. [DO NOT EDIT]

    //------------------IMPORTANT------------------
    // One thing with readAll and trim it didn't work with console input so I changed it to readLine() method
    public static void main(String[] args) {
        StdOut.println(match(StdIn.readLine()));
    }
}
