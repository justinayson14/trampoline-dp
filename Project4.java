// Justin Ayson
// Project 4
// 12/17/2024
// Read in a set of ints and calculate the min number of trampolines needed
// to move from rightmost index to leftmost index
import java.io.*;
import java.util.*;

public class Project4 {

    PrintStream prt = System.out;
    int[] B;
    int[] hops;
    int numT;

    public int minTrampoline() {
        Arrays.fill(hops, Integer.MAX_VALUE);
        hops[0] = 0;

        for(int i = 1; i < numT; i++) {
            for(int j = i - 1; j >= i - B[i] && j >= 0; j--) {
                if(hops[j] != Integer.MAX_VALUE)
                    hops[i] =  Math.min(hops[i], hops[j] + 1);
            }
        }

        // unreachable
        if(hops[numT - 1] == Integer.MAX_VALUE)
            return 0;

        return hops[numT - 1];
    }

    public void getInput() {
        try{
            Scanner inf = new Scanner(new File("input.txt"));
            numT = inf.nextInt();
            B = new int[numT];
            hops = new int[numT];
            for(int i = 0; i < numT; i++) {
                B[i] = inf.nextInt();
            }

            System.out.println(minTrampoline());
            inf.close();
        } catch(Exception e) {prt.printf("\nINVALID: %s", e);}
    }
    public static void main(String[] args) {
        Project4 proj = new Project4();
        proj.getInput();
    }
}