package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionPathCompressionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with
     * n elements  0 through  n-1
     * Initially, each elements is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if  n < 0
     */
    public QuickUnionPathCompressionUF(int n) {
		// Add code here
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        count = n;
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets
     */
    public int count() {
		// Add code here
        return (count);
	}

    /**
     * Returns the canonical element of the set containing element
     * Add two pass compression here
     */
    public int find(int p) {
		// Add code here with two pass compression
        int rootOfP = p;
        while (rootOfP != id[rootOfP])
            rootOfP = id[rootOfP];
        while (p != rootOfP)
        {
            int anotherP = id[p];
            id[p] = rootOfP;
            p = anotherP;
        }
        return (rootOfP);
    }

    /**
     * Returns true if the two elements are in the same set.
     */
    public boolean connected(int p, int q) {
		// Add code here
        int first = find(p);
        int second = find(p);
        return (first == second);
	}

    /**
     * Merges the set containing element  p with the
     * the set containing element  q.
     */
    public void union(int p, int q) {
		// Add code here
        if (connected(p, q))
            return;
        id[find(p)] = find(q);
        count--;
    }

    /**
     * Reads in a an integer n and a sequence of pairs of integers
     * (between 0 and  n-1) from standard input, where each integer
     * in the pair represents some element;
     * if the elements are in different sets, merge the two sets
     * and print the pair to standard output.
     *[DO NOT EDIT CODE IN MAIN]
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}

