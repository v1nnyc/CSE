/*
 * Name:  Vincent Cannalla
 * Login: cs8Bwals
 * Date:  3/8/16
 * File: CS8BTurtle.java
 * Sources of Help:
 *
 * it spells out cs8bwals winter 2016 using turtles. all of the methods for 
 * the letters are included, it has a run method too that draws everything
 */

import turtleClasses.*;
import java.awt.Color;

/*
 * Name:       CS8BTurtle
 * Purpose:    it has a turtle constructor and all the instance variables
 * and it has methods for each letter and a main method that draws
 * everything
 */

public class CS8BTurtle extends Turtle {
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
  
  //angle instance variables
  private final int thirty = 30;
  private final int fortyfive = 45;
  private final int seventysix = 76;
  private final int eightyfive = 85;
  private final int oneten = 110;
  private final int onetwenty = 120;
  private final int twotwenty = 220;
  private final int twotwentyfive = 225;
  
  private final int middleofN = CHAR_HEIGHT+10;
  private final int theRLeg = CHAR_WIDTH+15;
  
  
  
  /*
   * Delay between turtle actions (turns, moves) in milliseconds.
   * 1000 = 1 sec.  so  200 = 0.2 sec.
   */
  private final static int DELAY = 500;
  
  
  
  /*
   * Name:       CS8BTurtle
   * Purpose:    it makes a new turtle object by calling the super's method
   * Parameters: World w is a world, and int delay is the delay time between
   * moves
   */
  public CS8BTurtle(World w, int delay) {
    super(w, delay);  // Invoke superclass's ctor to create this turtle
  }                     // on World w with delay of each turtle's action.
  
  
  
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
   * Purpose:    this is the main method that draws all the letters
   * Parameters: none.
   * Return:     void.
   */
  public static void main(String [] args) {
    int startX1 = START_X_1,  // starting x offset for line 1
      startX2 = START_X_2,  // starting x offset for line 2
      startX3 = START_X_3;  // starting x offset for line 3
    int startY  = START_Y;    // starting y offset
    //initialize x and y for later use
    int x, y;
    //create new world
    World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
    //create new turtle
    CS8BTurtle myTurtle = new CS8BTurtle(w, DELAY);
    
    myTurtle.setPenWidth(PEN_WIDTH);
    myTurtle.setPenColor(PEN_COLOR);
    
    //draw CS8BWALS
    myTurtle.drawC(x = startX1, y = startY);
    myTurtle.drawS(x += CHAR_SPACING, y);
    myTurtle.draw8(x += CHAR_SPACING, y);
    myTurtle.drawB(x += CHAR_SPACING, y);
    myTurtle.drawW(x += CHAR_SPACING, y);
    myTurtle.drawA(x += CHAR_SPACING, y);
    myTurtle.drawL(x += CHAR_SPACING, y);
    myTurtle.drawS(x += CHAR_SPACING, y);
    //new line draw WINTER
    myTurtle.drawW(x = startX2, y = y + LINE_SPACING);
    myTurtle.drawI(x += CHAR_SPACING, y);
    myTurtle.drawN(x += CHAR_SPACING, y);
    myTurtle.drawT(x += CHAR_SPACING, y);
    myTurtle.drawE(x += CHAR_SPACING, y);
    myTurtle.drawR(x += CHAR_SPACING, y);
    //new line draw 2016
    myTurtle.draw2(x = startX3, y = y + LINE_SPACING);
    myTurtle.draw0(x += CHAR_SPACING, y);
    myTurtle.draw1(x += CHAR_SPACING, y);
    myTurtle.draw6(x += CHAR_SPACING, y);
  }
}  // End of public class CS8BTurtle extends Turtle
