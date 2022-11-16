/*
 * Wordle.java 
 * 
 * An console-based implementation of a popular word-guessing game
 * 
 * starter code: Computer Science 112 staff (cs112-staff@cs.bu.edu)
 *
 * completed by: Fawzy Lawal
 */

import java.util.*;

public class Wordle {
    // the name of a file containing a collection of English words, one word per line
    public static final String WORD_FILE = "words.txt";

    /*
     * printWelcome - prints the message that greets the user at the beginning of the game
     */  
    public static void printWelcome() {
        System.out.println();   
        System.out.println("Welcome to Wordle!");
        System.out.println("The mystery word is a 5-letter English word.");
        System.out.println("You have 6 chances to guess it.");
        System.out.println();
    }
    
    /*
     * initWordList - creates the WordList object that will be used to select
     * the mystery work. Takes the array of strings passed into main(),
     * since that array may contain a random seed specified by the user 
     * from the command line.
     */
    public static WordList initWordList(String[] args) {
        int seed = -1;
        if (args.length > 0) {
            seed = Integer.parseInt(args[0]);
        }

        return new WordList(WORD_FILE, seed);
    }

    /*
     * readGuess - reads a single guess from the user and returns it
     * inputs:
     *   guessNum - the number of the guess (1, 2, ..., 6) that is being read
     *   console - the Scanner object that will be used to get the user's inputs
     */
    public static String readGuess(int guessNum, Scanner console) {
        String guess;
        do {
            System.out.print("guess " + guessNum + ": ");
            guess = console.next();
        } while (! isValidGuess(guess));

        return guess.toLowerCase();
    }

    /**** ADD YOUR METHODS FOR TASK 1 HERE ****/
     /* includes - takes two parameters, String and char, and return True
        if char is found in the String; False otherwise 
     */
    public static boolean includes(String s, char c){
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c ){
                return true;
            }
        }
        return false;
    }

     /* isAlpha - takes arbitary parameter String s and return True
        if all character in s are letters of the alphabet; False otherwise 
     */
    public static boolean isAlpha(String s){
        for (int i = 0; i < s.length(); i++){
            if (Character.isAlphabetic(s.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    /* numOccur - takes two parameters, char c and String s; count and return
        the number of times that c occurs in s
     */  
    public static int numOccur(char c, String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                count +=1;
            }
        }
        return count;
    } 
    
     /* numInSamePosn - takes three parameters, char c and Strings s1 and s2; count and return
        num of times that c occurs in the same postion in both s1 and s2
     */
    public static int numInSamePosn( char c, String s1, String s2){
        int count = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) == c){
                if (s1.charAt(i) == s2.charAt(i) ){
                    count+=1;
                }
            }
        }
        return count;
    }

    /*
     * TASK 2: Implement this method
     * 
     * isValidGuess -  takes an arbitrary string guess and returns true
     * if it is a valid guess for Wordle, and false otherwise
     */
    public static boolean isValidGuess(String guess) {
        if (guess.length() == 5){
            if (isAlpha(guess) == true){
                return true;
            }

            else{
                System.out.println("Your guess must only contain letters of the alphabet.");
                return false;
            }
        }

        else{
            System.out.println("Your guess must be 5 letters long.");
            return false;
        }
        
    }

    /**** ADD YOUR METHOD FOR TASKS 3 and 5 HERE. ****/

     /* processGuess - takes two parameters, 5 character String guess and mystery;
        provide feedback about how guess compares to mystery; 
        return true if guess equals mystery;false otherwise
     */
    public static boolean processGuess(String guess , String mystery){
        System.out.println("  ");
        if (isValidGuess(guess) == true){
            for ( int i = 0; i < mystery.length(); i++){
                if (numInSamePosn(guess.charAt(i),guess,mystery) ==1){
                    if (guess.charAt(i) == mystery.charAt(i)){
                        System.out.print(guess.charAt(i) + " ");
                        // return true;
                    }

                    else if(includes(mystery, guess.charAt(i)) == true) {
                        System.out.print("[" + guess.charAt(i) + "] ");
                    }
                    else if(includes(mystery, guess.charAt(i)) == false){
                        System.out.print("_ ");
                    }
                }
                else{
                    if (guess.charAt(i) == mystery.charAt(i)){
                        System.out.print(guess.charAt(i) + " ");
                        // return true;
                    }

                    else if(includes(mystery, guess.charAt(i)) == true) {
                        if(numOccur(guess.charAt(i), mystery) > 1){
                            System.out.print("_ ");
                        }
                        else{
                        System.out.print("[" + guess.charAt(i) + "] ");
                        }
                    }
                    else if(includes(mystery,guess.charAt(i)) == false) {
                         System.out.print("_ ");
                     }
                    }                    
                }
            }
            
        System.out.println();
        if ( guess.equals(mystery)){
            return true;
        }
        return false;
    
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        printWelcome();

        // Create the WordList object for the collection of possible words.
        WordList words= initWordList(args);

        // Choose one of the words as the mystery word.
        String mystery = words.getRandomWord();
        
        /*** TASK 4: Implement the rest of the main method below. ***/
        int i = 1;
        
        while( i <= 6){
            String guess = readGuess(i, console);
            if (processGuess(guess, mystery) == true){
                System.out.println("Congrats! You guessed it!");
                break;
            }
            
            if(i == 6){
                System.out.println("Sorry! Better luck next time! The word was " + mystery + ".");
            }
            i+=1;
            //readGuess(i,console);
            // processGuess(guess,mystery);
        }
        


        console.close();
    }
}