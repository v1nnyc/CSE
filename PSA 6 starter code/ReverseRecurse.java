/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 17, 2016
 * File:  ReverseRecurse.java 
 * Sources of Help: none
 * 
 *This is the reverserecurse class. it reverses the order of arrays using
 * recursion. it also has some methods that are responsible for a user making
 * an array.
 */
import java.util.*;
import java.util.Scanner;
public class ReverseRecurse extends PA6Strings {
  
  
  
  /* 
   * Name: initArray
   * Purpose: this is responsible for intializing the array.
   * Parameters: none
   * Return: it returns an array of ints. 
   */
  public int[] initArray() {
    int size=0;
    //scanner in
    Scanner in = new Scanner( System.in ); 
    System.out.println(MAX_NUM);
    //if the input is an int
    if ( in.hasNextInt() ) {
      //assign it to size
      size = in.nextInt();
    } 
    //otherwise exit
    else {
      System.exit(1);
    }
    //making sure that they inputted a positive int
    if ( size <= 0){
      System.out.println(TOO_SMALL);
      //recursion ;)
      int[] array = initArray();
      return array;
    }
    //make a new array with size
    int[] array = new int[size];
    //copy of array
    int[] copy = new int[0];
    //this is responsible for assigning the input to the array
    for (int i = 0; i < array.length; i++)
    {
      System.out.printf(PA6Strings.ENTER_INTS, size);
      if ( in.hasNextInt() ) {
        //make a backup copy in case they enter something other than
        //an int, and it will make a smaller array
        array[i] = in.nextInt();
        copy = makeCopy(array, i+1);
      } 
      //return copy if they enter something
      else {
        return copy;
      }
    }  
    return array;
  }
  
  
  
  /* 
   * Name: printArray
   * Purpose: this loops through the array and prints it
   * Parameters: an int array
   * Return: void
   */
  public void printArray( int[] array ) {
    //check to make sure that the array isn't empty, print empty if empty
    if(array.length == 0){
      System.out.println(EMPTY);
    }
    //loop through array and print the elements
    else{
      for(int i = 0; i<array.length;i++){
        System.out.print(array[i]+" ");
      }
      //new line
      System.out.println("");
    }
  }    
  
  
  
  /* 
   * Name: makeCopy
   * Purpose: this makes a copy of the array
   * Parameters: an int array, and the length of the array
   * Return: a copy of an int array
   */
  public int[] makeCopy(int[] array, int length){
    //make temp array of same length
    int[] temp = new int[length];
    //loop through and assign elements
    for(int i = 0; i<length;i++){
      temp[i]=array[i];
    }
    return temp;
  }
  
  
  
  /* 
   * Name: reverse
   * Purpose: this reverses the array using recursion
   * Parameters: an int array, two ints which are low and high
   * Return: void 
   */
  public void reverse( int[] originalArray, int low, int high ){
    //make sure array isn't null reference
    if(originalArray != null){
      //base case for recursion
      if(low<high){
        //make temp with first element
        int tmp = originalArray[low];
        //assign last element to first
        originalArray[low] = originalArray[high];
        //assign temp to last element
        originalArray[high] = tmp;
        //recurse
        reverse(originalArray, ++low, --high);
      }
    }
  }
  
  
  
  /* 
   * Name: reverse
   * Purpose: this reverses the array using recursion
   * Parameters: an int array
   * Return: it returns an array of ints. 
   */
  public int[] reverse( int[] originalArray ) { 
    //check to make sure array isn't null or empty
    if(originalArray != null && originalArray.length !=0){
      //make a copy of the array
      int[]copy = makeCopy(originalArray, originalArray.length);
      //make temp with first element
      int tmp = originalArray[0];
      //assign last element to first
      copy[0] = originalArray[originalArray.length-1];
      //assign temp to last element
      copy[copy.length-1] = tmp;
      //array needs to be greater than 2 because i subtract two from it
      if(originalArray.length>2){
        //new temp array with original array length - 2
        int[] temp = new int[originalArray.length-2];
        //copy the middle elements into the shorter array
        System.arraycopy(originalArray, 1, temp,0,originalArray.length-2);
        //this recurses and assigns the recursed values into the old copy array
        System.arraycopy(reverse(temp), 0, copy,1,reverse(temp).length);
      }
      //return the copy
      return copy;
    }
    //if it was a null reference or empty return original
    return originalArray;
  }
}