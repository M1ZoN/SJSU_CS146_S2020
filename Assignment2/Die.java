package com.company;

import edu.princeton.cs.algs4.StdOut;

// A data type representing a six-sided die.
public class Die implements Comparable<Die> {
    private int value; // face value
    private final int SIDES = 6;

    Die() {
        this.value = 0;
    }
    // Roll the die.
    public void roll() {
        // Code Here
        this.value = (int) (Math.random() * SIDES) + 1;
    }

    // Face value of the die.
    public int value() {
        // Code Here
        return (this.value);
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        // Code Here
        return (that.value() == this.value);
    }

    // A negative integer, zero, or positive integer depending on whether this
    // die's value is less than, equal to, or greater than the that die's value.
    public int compareTo(Die that) {
        // Code Here
        return (this.value - that.value());
    }

    // A string representation of the die giving the current face value.
    public String toString() {
        // Code Here
        String res = "";
        switch (this.value) {
            case 1:
                res = "   \n" + " * \n" + "   ";
                break;
            case 2:
                res = "*  \n" + "   \n" + "  *";
                break;
            case 3:
                res = "*  \n" + " * \n" + "  *";
                break;
            case 4:
                res = "* *\n" + "   \n" + "* *";
                break;
            case 5:
                res = "* *\n" + " * \n" + "* *";
                break;
            case 6:
                res = "***\n" + "   \n" + "***";
                break;
        }
        return (res);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();        
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();        
        c.roll();
        while (c.value() != z) {
            c.roll();
        }
        StdOut.println(a);
        StdOut.println(a.equals(b));
        StdOut.println(b.equals(c));        
        StdOut.println(a.compareTo(b));
        StdOut.println(b.compareTo(c));        
    }
}
