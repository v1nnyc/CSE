/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: January 21, 2016
 * File:  WordCloud.java 
 * Sources of Help: the textbook, piazza
 * 
 * This program does a lot of stuff. it creates an array list, then it
 * copies words from a file into that list. it finds the word counts of the 
 * words in the list, it compares the list you made to a file of common words
 * and removes any words that are present in both files, it determines the top n
 * words in the list, and removes all the other words, and finally it prints all
 * the words in the list to either the console or a new file
 */
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/* 
 * Name: WordCloud
 * Purpose: it makes the WordClouds which are arraylists full of wordpairs
 * Parameters: none
 * Return: void
 */
public class WordCloud{
  
  // The ArrayList to store the words and their associated counts
  ArrayList<WordPair> list;
  
  // construct the list
  public WordCloud() {
    list = new ArrayList<WordPair>();
  }
  
  
  /* 
   * Name: getWordsFromFile
   * Purpose: This method will read all the words from the source file and 
   * properly updates the list
   * Parameters: filename, string, the file that is transferred into strings 
   * and added to the arraylist
   * Return: void 
   */
  public void getWordsFromFile( String filename ) throws IOException {
    java.io.File file = new java.io.File(filename);
    Scanner input = new Scanner(file);
    //creating the first wordpair for the arraylist
    String firstword = input.next();
    WordPair firstWord = new WordPair(firstword);
    list.add(firstWord);
    while(input.hasNext()){
      String word = input.next();
      //this is the loop that goes through the arraylist checking 
      // if the new word is already in it
      for (int i = 0; i < list.size(); i++){
        String wordCheck = list.get(i).getWord().toUpperCase();
        if (wordCheck.equals(word.toUpperCase())){
          //if it's already in the list the wordpair is incremented
          list.get(i).increment();
        }
      }
      //if it's not in the list, it gets added
      if (!alreadyIn(word, list)){
        WordPair newWord = new WordPair(word);
        list.add(newWord);
      }
    }
    input.close();
  }
  
  
  
  /* 
   * Name: alreadyIn
   * Purpose: I used this in the getWordsFromFile method to check if a word
   * was already in the list, if it wasn't, it returned false
   * Parameters: word, string, the word to be checked. theList, arraylist,
   * the list to be checked
   * Return: boolean, if it's true the word is in the list, if it's false
   * the word isn't in the list
   */
  public boolean alreadyIn(String word, ArrayList<WordPair> theList) throws 
    IOException{
    for (int i = 0; i < theList.size(); i++){
      String wordCheck = theList.get(i).getWord();
      if (wordCheck.equalsIgnoreCase(word)){
        return true;
      }
    }
    return false;
  }
  
  
  
  /* 
   * Name: getList
   * Purpose: accessor method to access list from tester file
   * Parameters: none 
   * Return: ArrayList<WordPair>, you're returning an array list of word pairs
   */
  public ArrayList<WordPair> getList(){
    return list;
  }
  
  
  
  /* 
   * Name: findWordCount
   * Purpose: this method searches for a word in the list and returns its count
   * Parameters: word, string, and it is the word the method searched the list 
   * for 
   * Return: int, because the count is a number, the return type is an int 
   */
  public int findWordCount(String word){
    int count= 0;
    for (int i = 0; i < list.size(); i++){
      String wordCheck = list.get(i).getWord();
      if (wordCheck.equalsIgnoreCase(word)){
        count = list.get(i).getCount();
      }
      
    }
    return count;
  }
  
  
  
  /* 
   * Name: removeCommon
   * Purpose: this method removes any of the common words from the list 
   * Parameters: omitFilename, string, it's the name of the file that we use
   * to compare the objects in the list to
   * Return: void
   */
  public void removeCommon( String omitFilename ) throws IOException {
    java.io.File file = new java.io.File(omitFilename);
    Scanner input = new Scanner(file);
    while(input.hasNext()){
      String word = input.next();
      for (int i = 0; i < list.size(); i++){
        String wordCheck = list.get(i).getWord();
        if (wordCheck.equalsIgnoreCase(word)){
          list.remove(i);
        }
      }
    }
    input.close();
  }
  
  
  
  /* 
   * Name: topNWords
   * Purpose: This method finds the top n occuring words in the list and then
   * puts them into a new arraylist. 
   * Parameters: n, int, it's how many words you want to be in the list of most
   * used words
   * Return: ArrayList<WordPair>, we're going to return an arraylist full of 
   * wordpair objects
   */
  public ArrayList<WordPair> topNWords(int n) {
    //making a new list to store the topNWords
    ArrayList<WordPair> sortList = new ArrayList<WordPair>();
    //this for loop is responsible for going through the arraylist n times
    for (int cycleCount = 0; cycleCount < n; cycleCount++){
      int temp=0;
      int element = 0;
      //this for loop finds the max count in the arraylist
      for (int i=0; i < list.size(); i++){
        int first = list.get(i).getCount();
        if (first > temp){
          temp = first;
        }
      }
      //this for loop finds which element corresponded with the max count
      //it increments backwards so that if there's a tie, the first word will 
      //replace the second word 
      for(int j = list.size()-1; j >=0; j--){
        int second = list.get(j).getCount();
        if (second == temp){
          element = j;
        }
      }
      //this adds the max element to the new list
      sortList.add(list.get(element));
      //this changes the count of the element in original list to be negative
      int negC = list.get(element).getCount();
      list.get(element).setCount(negC - (negC*2));
    }
    //changing all the negative numbers to positive
    for (int i = 0; i < list.size(); i++){
      int pos = Math.abs(list.get(i).getCount());
      list.get(i).setCount(pos);
    }
    list = sortList;
    return list;
  }
  
  
  
  /* 
   * Name: printWords
   * Purpose: to print the wordpair objects as a string with the word and count
   * in an arraylist to either a file or to the console.
   * Parameters: wordList, ArrayList<WordPair>, it's the list that you want to 
   * print. printToFile, boolean, if this is true, the strings are printed out
   * to a new file. if it is false the strings are printed to the console
   * Return: void
   */
  public void printWords(ArrayList<WordPair>wordList,boolean printToFile) 
    throws IOException{
    if (printToFile == true){
      //naming the new file
      java.io.File file = new java.io.File("myOutput.out");
      java.io.PrintWriter output = new java.io.PrintWriter(file);
      //looping through all the elements and printing them out
      for (int i = 0; i < list.size(); i++){
        output.print(list.get(i).getWord() +"("+list.get(i).getCount()+")"
                       +" " );
      }
      output.close();
    }
    else if (printToFile == false){
      //more looping and printing
      for (int i = 0; i < list.size(); i++){
        System.out.print(list.get(i).getWord() +"("+list.get(i).getCount()+")"
                           +" " );
      }
    }
  }
}