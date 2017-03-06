/* 
 * Name: Vincent Cannalla
 * Login: cs8bwals 
 * Date: January 21, 2016
 * File:  WordCloudGraphic.java
 * Sources of Help: https://developer.mozilla.org/en-US/docs/Web/JavaScript/
 * Reference/Global_Objects/Math/pow
 * 
 * It draws the words from the arraylist in order and the most frequent words
 * are the biggest and they get smaller based on frequency
 */
//importing classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.Math;

/* 
 * Name: WordCloudGraphics
 * Purpose: it makes a window and then types the words in it
 * Parameters: non
 * Return: none bc it's a class
 */
public class WordCloudGraphics extends JPanel {
  
  
  //Name of the font you want
  String type = "SansSerif";
  
  
  //Style of the font you want
  int styles = Font.BOLD;
  
  
  //Arraylist of WordPair
  ArrayList<WordPair> storeArray;
  
  
  //constructor
  public WordCloudGraphics(ArrayList<WordPair> words){
    storeArray = words;
  }
  
  
  //Default Constructor
  public WordCloudGraphics(){
    storeArray = null;
  }
  
  
  /* 
   * Name: drawWords
   * Purpose: it calls the draw method
   * Parameters: none
   * Return: void
   */
  public void drawWords(){
    try{
      JFrame f = new JFrame();
      f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      }
      );
      f.setContentPane(new WordCloudGraphics(storeArray));
      //Size of the cloud
      f.setSize(1000,1000);
      f.setVisible(true);
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
  /* 
   * Name: paint
   * Purpose: to cycle through array list and print out the words
   * it also determines the size of the font, and the spacing
   * Parameters: g, graphics, i'm not sure what it is
   * Return: void
   */
  public void paint(Graphics g) {
    
    int size=0;
    String word;
    int x = 0;
    int y = 0;
    //it cycles through the array and draws the words
    for(int i=0;i<storeArray.size();i++){
      int othersize = storeArray.get(i).getCount();
      //size is based on the frequency of the word + 1, to the power of three
      // so that each word shrinks exponentially
      // this is ideal for words with max frequencies of about 5
      size = ((int) Math.pow(othersize+1,3));
      x=x+size;
      word = storeArray.get(i).getWord();
      Font font = new Font(type, styles,size);
      g.setFont(font);
      y=y+size;
      g.drawString(word,x,y); 
    }
  }                  
}

