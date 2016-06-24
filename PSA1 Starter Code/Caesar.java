// Keep these two lines.  They are what tell Java to include the
// classes you need for working with files.
// You might get warnings about them at first.  That's OK, just
// ignore the warnings.  They should go away as you complete your code.
import java.io.*;
import java.util.*;
/*
 * Name:  Vincent Cannalla
 * Login: cs8bwals 
 * Date:  January 11, 2016
 * File:  Caesar.java
 */
public class Caesar {
  // Complete the methods below.  Be sure to add header
  // comments for each. You may (and should) also write additional
  // helper methods.  Be sure to make the helper methods private and include
  // header comments for each.
  
  // Although you will not be graded on style this week, you should follow
  // these basic style guidelines nonetheless.   You will be graded on this
  // in weeks to come, so start to practice now.
  
  // Use proper indenting: Indent each block of code (e.g., method body,
  //   loop body.  Line up the lines in the block so that they are all
  //   indented to the same degree.  See examples of this in the book
  //   and in the code below.
  // Use descriptive variable names: The names of your variables should
  //   describe the data they hold.  Almost always, your variable names
  //   should be words (or abbreviations), not single letters.
  // Write short methods: Break your methods up into submethods if they
  //   are getting too complicated or long.  Generally your methods
  //   shouldn't get too much longer than about 20 lines of code (give or take)
  // Write short lines: Each line of code should be no longer than 80
  //   characters, so it can fit in a reasonable size window.  There's a
  //   column number in both vim and emacs.
  //
  // We'll start with these, as these are the most important.  We may add
  // to this list later in the term, but if you do all of the above you're
  // in good shape.
  
  /*
  * Name:       encrypt
  * Purpose:    encrypts only chars in the string by the amount set by 
  * rotation
  * Parameters: s - String, rotation - an int (positive or negative)
  * Return:     encrypted string
  */ 
  public static String encrypt(String s, int rotation) { 
    //creating new blank string
    String message = "";
    int len = s.length();
    if (rotation > 0){
      //using rotationChanger to change rotation to <26
      rotation = Caesar.rotationChanger(rotation);
      for(int x = 0; x < len; x++){
        char current = (char)(s.charAt(x));
        //adding each char to the new string
        message += (Caesar.letterOperation(current,rotation));
      }
    }
    if (rotation < 0 ){
      int rotation1 = Math.abs(rotation);
      //using decrypt message to encrypt with a negative rotation
      message= Caesar.decrypt(s, rotation1);
    }
    if (rotation == 0){
      return s;
    }
    return message;
  }
  
  /*
  * Name:       decrypt
  * Purpose:    changes the chars in the string by rotation value, if using 
  * decrypt to change an encrypted message, rotation value must be the same
  * Parameters: s - String, rotation - an int (positive or negative)
  * Return:     decrypted string
  */ 
  public static String decrypt(String s, int rotation) { 
    String message = "";
    int len = s.length();
    if (rotation > 0){
      rotation = Caesar.rotationChanger(rotation);
      for(int x = 0; x < len; x++){
        //changing rotation to a negative value for letterOperation
        int rotation1 = rotation*-1;
        char current = (char)(s.charAt(x));
        message += (Caesar.letterOperation(current,rotation1));
      }
    }
    if (rotation < 0 ){
      int rotation1 = Math.abs(rotation);
      //using encrypt method to decrypt with a negative number
      message= Caesar.encrypt(s, rotation1);
    }
    if (rotation == 0){
      return s;
    }
    return message;
  }
  
  /*
  * Name:       rotationChanger
  * Purpose:    if rotation value is above 26, the methods won't work, so this
  * method makes sure that the rotation value is below 26
  * Parameters: rotation - int
  * Return:     changed rotation int
  */ 
  private static int rotationChanger(int rotation) {
    while (rotation > 26){
      rotation = rotation - 26;
    }
    return rotation;
  }
  
  /*
  * Name:       letterOperation
  * Purpose:    takes a char as input and rotates it if it is a letter, then 
  * returns, if char isn't a letter it returns the unaltered char
  * Parameters: a - char, rotation - an int (positive or negative)
  * Return:     altered or unaltered char
  */ 
  private static char letterOperation(char letter, int rotation) {
    char changedChar = 0;
    if (rotation > 0){
      if (Character.isLetter(letter)){
        //making a char that has value of letter + rotation
        char current = (char)(letter + rotation);
        if (Character.isUpperCase(letter)){
          if (current > 'Z')
            // if char is > Z, subtract letter value by 26-rotation
            changedChar= (char)(letter - (26-rotation));
          else
            changedChar= (char)(letter + rotation);
        }
        if (Character.isLowerCase(letter)){
          if (current > 'z')
            changedChar= (char)(letter - (26-rotation));
          else
            changedChar= (char)(letter + rotation);
        }
      }
      else
        //returning a char if it isn't a letter
        changedChar= (char)(letter);
    }
    if (rotation < 0){
      int rotation1 = Math.abs(rotation);
      if (Character.isLetter(letter)){
        char current = (char)(letter - rotation1);
        if (Character.isUpperCase(letter)){
          if (current < 'A')
            //to make sure that it loops through the alphabet add 26-rotation
            changedChar = (char)(letter + (26-rotation1));
          else
            changedChar = (char)(letter - rotation1);
        }
        if (Character.isLowerCase(letter)){
          if (current < 'a')
            changedChar = (char)(letter + (26-rotation1));
          else
            changedChar = (char)(letter - rotation1);
        }
      }
      else
        changedChar= (char)(letter);    
    }
    return changedChar;
  }
}
