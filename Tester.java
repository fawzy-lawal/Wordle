/*
 * Tester.java 
 * 
 * A program that you can use to make test calls to the methods that you 
 * write as part of your Wordle implementation. 
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // // sample test for the includes method
        // System.out.println("\nTesting includes method...");
        // boolean result = Wordle.includes("goodbye", 'x');
        // System.out.println("includes(\"goodbye\", 'x') returns " + result);

        // // Add additional tests below to ensure that your methods
        // // work correctly.

        // //isAlpha method test
        // System.out.println("\nTesting isAlpha method...");
        // boolean resultalpha = Wordle.isAlpha("Goodbye!");
        // System.out.println("isAlpha(\"Goodbye!\") returns " + resultalpha);

        //  //numOccur method test
        // System.out.println("\nTesting numOccur method...");
        // int resultnumOccur = Wordle.numOccur('x',"hello");
        // System.out.println("numOccur returns " + resultnumOccur);

        //numInSamePosn method test
        // System.out.println("\nTesting numInSamePosn method...");
        // int resultnumPosn = Wordle.numInSamePosn('a',"java","mama");
        // System.out.println("numPosn returns " + resultnumPosn);

        // //isValidGuess method test
        // System.out.println("\nTesting isValidGuess method...");
        // System.out.println(Wordle.readGuess(1, console));

        //processGuess method test
        System.out.println("\nTesting processGuess method...");
        boolean resultprocess = Wordle.processGuess("nanny","enact");
        System.out.println("processGuess returns " + resultprocess);         
        
        console.close();


    }
}
