/*
 * Name:  Vincent Cannalla
 * Login: cs8Bwals
 * Date:  3/8/16
 * File: PSA9_ExtraCredit.java
 * Sources of Help:
 *
 * Using 20 threads, I made the turtles draw “JAVA” and its reflection along
 * horizontal axis and “THREAD” and its reflection along horizontal axis.
 */

import turtleClasses.*;
import java.awt.Color;
import java.util.concurrent.*;

/*
 * Name:       Class PSA9_ExtraCredit
 * Purpose:    It makes the turtles and has methods for every letter
 */

public class PSA9_ExtraCredit extends Turtle implements Runnable{
  private final static int CHAR_WIDTH = 40;
  private final static int CHAR_HEIGHT = 80;
  private final static int PADDING_BETWEEN_CHARS = 40;
  private final static int PADDING_BETWEEN_LINES = 40;
  private final static int CHAR_SPACING = CHAR_WIDTH + PADDING_BETWEEN_CHARS;
  private final static int LINE_SPACING = CHAR_HEIGHT + PADDING_BETWEEN_LINES;
  
  private final static int WORLD_WIDTH = 800;
  private final static int WORLD_HEIGHT = 500;
  
  private final static int PEN_WIDTH = 10;
  private final static Color PEN_COLOR = Color.BLUE;
  
  private char ch;
  private int x;
  private int y;
  
  private final static World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
  
  /*
   * Delay between turtle actions (turns, moves) in milliseconds.
   * 1000 = 1 sec.  so  200 = 0.2 sec.
   */
  private final static int DELAY = 500;
  
  //angle instance variables
  private final int thirty = 30;
  private final int fortyfive = 45;
  private final int seventysix = 76;
  private final int eightyfive = 85;
  private final int oneten = 110;
  private final int onetwenty = 120;
  private final int twotwenty = 220;
  private final int twotwentyfive = 225;
  private final int onefiftytwo = 152;
  private final int seventy = 70;
  private final int ten = 10;
  
  private final int theRLeg = CHAR_WIDTH+15;
  /*
   * Name:       PSA9_ExtraCredit
   * Purpose:    this is a constructor for the turtles
   * Parameters: World w is a world, and int delay is the delay time between
   * moves, char ch is the character that the turtle will draw and x and y are
   * coordinates
   */
  public PSA9_ExtraCredit(World w, char ch, int x, int y, int delay) {
    super(w, delay);
    setCh(ch);
    setX(x);
    setY(y);
    setPenWidth(PEN_WIDTH);
    setPenColor(PEN_COLOR);
  }  
  
  /*
   * Name:       setCh
   * Purpose:    this is a setter for the ch instance variable
   * Parameters: char ch is the character that the turtle will draw
   */
  public void setCh(char ch){
    this.ch = ch;
  }
  
  /*
   * Name:       setX
   * Purpose:    this is a setter for the x instance variable
   * Parameters: int x is the x coordinate for the turtle
   */
  public void setX(int x){
    this.x = x;
  }
  
  /*
   * Name:       setY
   * Purpose:    this is a setter for the y instance variable
   * Parameters: int y is the y coordinate for the turtle
   */
  public void setY(int y){
    this.y = y;
  }
  
  /*
   * Name:       drawShape
   * Purpose:    this draws a fancy little geometric pattern I thought up
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawShape(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown(); this.setPenColor(Color.RED);
    forward(10); turnLeft(); 
    this.setPenColor(Color.ORANGE);forward(20); turnLeft(); 
    this.setPenColor(Color.BLUE); forward(30); turnLeft(); 
    this.setPenColor(Color.GREEN);forward(40); turnLeft(); 
    this.setPenColor(Color.RED);forward(50); turnLeft();
    this.setPenColor(Color.ORANGE);forward(60); turnLeft(); 
    this.setPenColor(Color.BLUE);forward(70); turnLeft(); 
    this.setPenColor(Color.GREEN);forward(80); turnLeft(); 
    this.setPenColor(Color.RED);forward(90); turnRight(); 
    this.setPenColor(Color.BLACK);forward(90); turnRight();
    this.setPenColor(Color.RED);forward(15); turnRight(); 
    this.setPenColor(Color.BLACK);forward(70); turnLeft();
    this.setPenColor(Color.RED);forward(15); turnLeft(); 
    this.setPenColor(Color.BLACK);forward(70); turnRight(); 
    this.setPenColor(Color.RED);forward(15); turnLeft();
    this.setPenColor(Color.BLACK); forward(70); turnRight();
    this.setPenColor(Color.RED);forward(15); turnRight(); 
    this.setPenColor(Color.BLACK);forward(90); turnRight();
    this.setPenColor(Color.RED);forward(10); turnLeft(); 
    this.setPenColor(Color.BLACK);forward(50); turnLeft();
    this.setPenColor(Color.RED);forward(35); turnLeft(); 
    this.setPenColor(Color.BLACK);forward(15); turnLeft(); 
    this.setPenColor(Color.RED);forward(15); turnRight(); 
    this.setPenColor(Color.BLACK);forward(15); turnRight(); 
    this.setPenColor(Color.RED);forward(10); turnLeft();
    this.setPenColor(Color.BLACK);forward(50); turnRight(); 
    this.setPenColor(Color.RED);forward(25); turnRight(); 
    this.setPenColor(Color.BLACK);forward(100);
    this.setPenColor(Color.GREEN); forward(100); turnRight();
    this.setPenColor(Color.BLUE);forward(100); turnRight(); 
    this.setPenColor(Color.ORANGE);forward(80); turnLeft();
    this.setPenColor(Color.ORANGE); forward(25); turnRight(); 
    this.setPenColor(Color.BLACK);forward(110); turnLeft(); 
    this.setPenColor(Color.CYAN);forward(20); 
  }
  
  /*
   * Name:       drawJ
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawJ(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH/2);
    turnRight();
    forward(CHAR_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH/2);
  }
  
  /*
   * Name:       drawJu
   * Purpose:    this is responsible for drawing the corresponding letter,
   * but UPSIDE DOWN
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawJu(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH/2);
    turnLeft();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH/2);
  }
  
  /*
   * Name:       drawH
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawH(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT/2);
    turnLeft();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT/2);
    backward(CHAR_HEIGHT);
  }
  
  /*
   * Name:       drawV
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawV(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turn(seventysix);
    forward(CHAR_HEIGHT);
    turn(-onefiftytwo);
    forward(CHAR_HEIGHT);
  }
  
  /*
   * Name:       drawVu
   * Purpose:    this is responsible for drawing the corresponding letter
   * but UPSIDE DOWN
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawVu(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turn(-seventysix);
    forward(CHAR_HEIGHT);
    turn(onefiftytwo);
    forward(CHAR_HEIGHT);
  }
  
  /*
   * Name:       drawD
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawD(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH/2);
    turn(-thirty);
    forward(ten);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turnLeft();
    forward(seventy);
    turn(-thirty);
    forward(ten);
    turnToFace(getXPos() + 1, getYPos()); // face right
    backward(CHAR_WIDTH/2);
  }
  
  /*
   * Name:       drawA
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawA(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT/2);
    turnRight();
    forward(CHAR_WIDTH);
  }
  
  /*
   * Name:       drawAu
   * Purpose:    this is responsible for drawing the corresponding letter
   * but UPSIDE DOWN
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawAu(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnLeft();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT/2);
    turnLeft();
    forward(CHAR_WIDTH);
  }
  
  /*
   * Name:       drawT
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawT(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH/2);
    turnRight();
    forward(CHAR_HEIGHT);
  }
  
  /*
   * Name:       drawTu
   * Purpose:    this is responsible for drawing the corresponding letter
   * but UPSIDE DOWN
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawTu(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH/2);
    turnLeft();
    forward(CHAR_HEIGHT);
  }
  
  /*
   * Name:       drawE
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawE(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
  }
  
  /*
   * Name:       drawR
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawR(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(fortyfive);
    forward(theRLeg);
  }
  
  /*
   * Name:       drawRu
   * Purpose:    this is responsible for drawing the corresponding letter
   * but UPSIDE dowN
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawRu(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(-fortyfive);
    forward(theRLeg);
  }
  
  
  
  /*
   * Name:       main
   * Purpose:    this is responsible for making threads with new turtle 
   * objects. it uses a cached thread pool
   * Parameters: none
   * Return:     void
   */
  
  public static void main(String[] args){
    //I decided to use a cached thread pool for this because making separate
    //threads for each turtle would have been 60 lines longer, and that's
    //very unnecessary and excessive 
    //plus this way I got to practice with both
    
    ExecutorService executor = Executors.newCachedThreadPool();
    
    executor.execute(new PSA9_ExtraCredit(w, 'J', 100, 20, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'A', 180, 20, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'V', 260, 20, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'A', 340, 20, DELAY));
    //new line
    //I used lower case chars for the flipped letters
    executor.execute(new PSA9_ExtraCredit(w, 'j', 100, 230, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'a', 180, 230, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'v', 260, 230, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'a', 340, 230, DELAY));
    //new line
    executor.execute(new PSA9_ExtraCredit(w, 'T', 20, 270, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'H', 100, 270, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'R', 180, 270, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'E', 260, 270, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'A', 340, 270, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'D', 420, 270, DELAY));
    //new line
    executor.execute(new PSA9_ExtraCredit(w, 't', 20, 470, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'H', 100, 390, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'r', 180, 390, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'E', 260, 390, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'a', 340, 470, DELAY));
    executor.execute(new PSA9_ExtraCredit(w, 'D', 420, 390, DELAY));
    //this is my shape i like it and I hope you do too
    executor.execute(new PSA9_ExtraCredit(w, '6', 600, 200, DELAY));
    
    executor.shutdown();
  }
  
  /*
   * Name:       run
   * Purpose:    this draws all the shapes 
   * Parameters: none
   * Return:     void
   */
  @Override
  public void run(){
    switch(ch) {
      case 'J': this.setPenColor(Color.RED);
      this.drawJ(x, y); break;
      case 'A': this.setPenColor(Color.ORANGE);
      this.drawA(x, y); break;
      case 'V': this.setPenColor(Color.YELLOW);
      this.drawV(x, y); break;
      case 'T': this.setPenColor(Color.GREEN);
      this.drawT(x, y); break;
      case 'H': this.setPenColor(Color.BLUE);
      this.drawH(x, y); break;
      case 'R': this.setPenColor(Color.MAGENTA);
      this.drawR(x, y); break;
      case 'E': this.setPenColor(Color.CYAN);
      this.drawE(x, y); break;
      case 'D': this.setPenColor(Color.RED);
      this.drawD(x, y); break;
      case 'j': this.setPenColor(Color.ORANGE);
      this.drawJu(x, y); break;
      case 'a': this.setPenColor(Color.YELLOW);
      this.drawAu(x, y); break;
      case 'v': this.setPenColor(Color.GREEN);
      this.drawVu(x, y); break;
      case 't': this.setPenColor(Color.CYAN);
      this.drawTu(x, y); break;
      case 'r': this.setPenColor(Color.PINK);
      this.drawRu(x, y); break;
      
      case '6': this.drawShape(x, y); break;
    }
  }
}
