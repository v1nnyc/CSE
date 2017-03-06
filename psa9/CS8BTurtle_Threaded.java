/*
 * Name:  Vincent Cannalla
 * Login: cs8Bwals
 * Date:  3/8/16
 * File: CS8BTurtle_Threaded.java
 * Sources of Help:
 *
 * it spells out cs8bwals winter 2016 using turtles. all of the methods for 
 * the letters are included, it has a run method too that draws everything. 
 * this is similar to the other code, except this one uses threading to have
 * multiple turtles drawing the shapes simultaneously
 */

import turtleClasses.*;
import java.awt.Color;
import java.util.concurrent.*;

/*
 * Name:       CS8BTurtle_Threaded
 * Purpose:    this has methods for shapes and a turtle constructor and then a
 * run method that splits the turtles into different threads and then a run
 * method that has different switches for each character
 */
public class CS8BTurtle_Threaded extends Turtle implements Runnable{
  private final static int CHAR_WIDTH = 40;
  private final static int CHAR_HEIGHT = 80;
  private final static int PADDING_BETWEEN_CHARS = 40;
  private final static int PADDING_BETWEEN_LINES = 40;
  private final static int CHAR_SPACING = CHAR_WIDTH + PADDING_BETWEEN_CHARS;
  private final static int LINE_SPACING = CHAR_HEIGHT + PADDING_BETWEEN_LINES;
  
  private final static int WORLD_WIDTH = 800;
  private final static int WORLD_HEIGHT = 500;
  
  private final static int START_X_1 = 
    ((WORLD_WIDTH/2) - (CHAR_SPACING * 4) + 20); // starting x offset for line 1
  private final static int START_X_2 = 
    ((WORLD_WIDTH/2) - (CHAR_SPACING * 3) + 20); // starting x offset for line 2
  private final static int START_X_3 = 
    ((WORLD_WIDTH/2) - (CHAR_SPACING * 2) + 20); // starting x offset for line 3
  private final static int START_Y = 
    (int)((WORLD_HEIGHT/2) - (LINE_SPACING * 1.5)+20);   // starting y offset
  
  private final static int PEN_WIDTH = 10;
  private final static Color PEN_COLOR = Color.BLUE;
  
  private char ch;
  private int x;
  private int y;
  
  private final static World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
  
  //angle instance variables
  private final int thirty = 30;
  private final int fortyfive = 45;
  private final int seventysix = 76;
  private final int eightyfive = 85;
  private final int oneten = 110;
  private final int onetwenty = 120;
  private final int twotwenty = 220;
  private final int twotwentyfive = 225;
  
  //this is the middle of N (that little diagonal)
  private final int middleofN = CHAR_HEIGHT+10;
  //this is the little dangly thing on R
  private final int theRLeg = CHAR_WIDTH+15;
  
  
  /*
   * Delay between turtle actions (turns, moves) in milliseconds.
   * 1000 = 1 sec.  so  200 = 0.2 sec.
   */
  private final static int DELAY = 500;
  
  
  
  /*
   * Name:       CS8BTurtle_Threaded
   * Purpose:    it makes a new turtle object by calling the super's method
   * then initializes the instance variables for ch x and y
   * Parameters: World w is a world, and int delay is the delay time between
   * moves, char ch is the character that the turtle will draw and x and y are
   * coordinates
   */
  public CS8BTurtle_Threaded(World w, char ch, int x, int y, int delay) {
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
   * Name:       drawC
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawC(int x, int y) {
    penUp();
    moveTo(x, y);  // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       drawS
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawS(int x, int y) {
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
    turnRight();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       draw8
   * Purpose:    this is responsible for drawing the corresponding number
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void draw8(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       drawB
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawB(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turn(thirty);
    forward(CHAR_WIDTH);
    turn(onetwenty);
    forward(CHAR_WIDTH);
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turn(thirty);
    forward(CHAR_WIDTH);
    turn(onetwenty);
    forward(CHAR_WIDTH);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turnLeft();
    forward(CHAR_HEIGHT);
  }
  
  
  /*
   * Name:       drawW
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawW(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turn(eightyfive);
    forward(CHAR_HEIGHT);
    turn(twotwenty);
    forward(CHAR_HEIGHT/3);
    turn(oneten);
    forward(CHAR_HEIGHT/3);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(-eightyfive);
    forward(CHAR_HEIGHT);
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
    forward(CHAR_WIDTH/2);
    penDown();
    turn(seventysix);
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turnRight();
    turnRight();
    turn(-seventysix);
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT/2);
    turnToFace(getXPos() + 1, getYPos()); // face right
    forward(CHAR_WIDTH/2);
  }
  
  
  /*
   * Name:       drawL
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawL(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       drawI
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawI(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH/2);
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH/2);
    backward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       drawN
   * Purpose:    this is responsible for drawing the corresponding letter
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void drawN(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    turnRight();
    forward(CHAR_HEIGHT);
    backward(CHAR_HEIGHT);
    turn(-thirty);
    forward(middleofN);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turnLeft();
    forward(CHAR_HEIGHT);
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
   * Name:       draw2
   * Purpose:    this is responsible for drawing the corresponding number
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void draw2(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       draw0
   * Purpose:    this is responsible for drawing the corresponding number
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void draw0(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
  }
  
  
  /*
   * Name:       draw1
   * Purpose:    this is responsible for drawing the corresponding number
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void draw1(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    forward(CHAR_WIDTH/2);
    penDown();
    turn(-twotwentyfive);
    forward(CHAR_WIDTH/2);
    backward(CHAR_WIDTH/2);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turnRight();
    forward(CHAR_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH/2);
    backward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       draw6
   * Purpose:    this is responsible for drawing the corresponding number
   * Parameters: two ints, x and y, which are their starting coordinates
   * Return:     void
   */
  private void draw6(int x, int y) {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    forward(CHAR_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
  }
  
  
  /*
   * Name:       main
   * Purpose:    this is responsible for making threads with new turtle 
   * objects.
   * Parameters: none
   * Return:     void
   */
  public static void main(String[] args){
    
    int startX1 = START_X_1,  // starting x offset for line 1
      startX2 = START_X_2,  // starting x offset for line 2
      startX3 = START_X_3;  // starting x offset for line 3
    int startY  = START_Y;    // starting y offset
    //initialize x and y for later use
    int x, y;
    
    //making new threads for each turtle
    Thread thread1 = 
      new Thread(new CS8BTurtle_Threaded(w, 'C', x = startX1, y = startY, DELAY));
    Thread thread2 = 
      new Thread(new CS8BTurtle_Threaded(w, 'S',x += CHAR_SPACING, y, DELAY));
    Thread thread3 = 
      new Thread(new CS8BTurtle_Threaded(w, '8',x += CHAR_SPACING, y, DELAY));
    Thread thread4 = 
      new Thread(new CS8BTurtle_Threaded(w, 'B',x += CHAR_SPACING, y, DELAY));
    Thread thread5 = 
      new Thread(new CS8BTurtle_Threaded(w, 'W',x += CHAR_SPACING, y, DELAY));
    Thread thread6 = 
      new Thread(new CS8BTurtle_Threaded(w, 'A',x += CHAR_SPACING, y, DELAY));
    Thread thread7 = 
      new Thread(new CS8BTurtle_Threaded(w, 'L',x += CHAR_SPACING, y, DELAY));
    Thread thread8 = 
      new Thread(new CS8BTurtle_Threaded(w, 'S',x += CHAR_SPACING, y, DELAY));
    Thread thread9 = 
      new Thread(new CS8BTurtle_Threaded
                   (w, 'W',x = startX2, y = y + LINE_SPACING, DELAY));
    Thread thread10 = 
      new Thread(new CS8BTurtle_Threaded(w, 'I',x += CHAR_SPACING, y, DELAY));
    Thread thread11 = 
      new Thread(new CS8BTurtle_Threaded(w, 'N',x += CHAR_SPACING, y, DELAY));
    Thread thread12 = 
      new Thread(new CS8BTurtle_Threaded(w, 'T',x += CHAR_SPACING, y, DELAY));
    Thread thread13 = 
      new Thread(new CS8BTurtle_Threaded(w, 'E',x += CHAR_SPACING, y, DELAY));
    Thread thread14 = 
      new Thread(new CS8BTurtle_Threaded(w, 'R',x += CHAR_SPACING, y, DELAY));
    Thread thread15 = 
      new Thread(new CS8BTurtle_Threaded
                   (w, '2',x = startX3, y = y + LINE_SPACING, DELAY));
    Thread thread16 = 
      new Thread(new CS8BTurtle_Threaded(w, '0',x += CHAR_SPACING, y, DELAY));
    Thread thread17 = 
      new Thread(new CS8BTurtle_Threaded(w, '1',x += CHAR_SPACING, y, DELAY));
    Thread thread18 = 
      new Thread(new CS8BTurtle_Threaded(w, '6',x += CHAR_SPACING, y, DELAY));
    
    //starting the threads
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    thread6.start();
    thread7.start();
    thread8.start();
    thread9.start();
    thread10.start();
    thread11.start();
    thread12.start();
    thread13.start();
    thread14.start();
    thread15.start();
    thread16.start();
    thread17.start();
    thread18.start();
    
    /*
     * this was more efficient and i didn't want to delete it
     ExecutorService executor = Executors.newCachedThreadPool();
     
     executor.execute(new CS8BTurtle_Threaded(w, 'C', 100, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'S', 180, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, '8', 260, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'B', 340, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'W', 420, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'A', 500, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'L', 580, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'S', 660, 90, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'W', 180, 210, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'I', 260, 210, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'N', 340, 210, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'T', 420, 210, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'E', 500, 210, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, 'R', 580, 210, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, '2', 260, 330, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, '0', 340, 330, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, '1', 420, 330, DELAY));
     executor.execute(new CS8BTurtle_Threaded(w, '6', 500, 330, DELAY));
     
     executor.shutdown();*/
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
      case 'C': this.drawC(x, y); break;
      case 'S': this.drawS(x, y); break;
      case '8': this.draw8(x, y); break;
      case 'B': this.drawB(x, y); break;
      case 'W': this.drawW(x, y); break;
      case 'A': this.drawA(x, y); break;
      case 'L': this.drawL(x, y); break;
      case 'I': this.drawI(x, y); break;
      case 'N': this.drawN(x, y); break;
      case 'T': this.drawT(x, y); break;
      case 'E': this.drawE(x, y); break;
      case 'R': this.drawR(x, y); break;
      case '2': this.draw2(x, y); break;
      case '0': this.draw0(x, y); break;
      case '1': this.draw1(x, y); break;
      case '6': this.draw6(x, y); break;
    }
  }
}
