/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 17, 2016
 * File:  MyCritter.java 
 * Sources of Help: none
 * 
 *This is the mycritter class. it is responsible for making the mycritter 
 * objects. it 
 * assigns the color to the critters, their eat value, how they attack
 * and the direction they will move in
 */
import java.util.*;
import java.awt.*;
import java.util.Random;
public class MyCritter extends Critter{
  private int moveC;
  private Random randGen;
  private int getRand;
  private int runAway;
  public Direction dire;
  public String opp;
  
  
  
  /* 
   * Name: mycritter
   * Purpose: this is the mycritter constructor. it assigns values to the
   * randGen, moveC, runAway, dire, and variables.
   * Parameters: none
   * Return: none 
   */
  public MyCritter(){
    //initializing variables
    this.randGen = new Random();
    this.moveC = 1;
    this.runAway = 5;
    this.dire = Direction.NORTH;
  }
  
  
  
  /* 
   * Name: eat
   * Purpose: this is the eat constructor that determines whether or not the 
   * critter will eat. 
   * Parameters: none
   * Return: boolean. always true.
   */
  public boolean eat() {
    return true;
  }
  
  
  
  /* 
   * Name: fight
   * Purpose: this is the fight constructor. it determines what move the 
   * critter
   * will
   * use. it initializes the opponent variable, and then uses runaway to run
   * away. then it has methods for conterattacking the LTB
   * Parameters: String. opponent. the opponent determines which move will be 
   * used
   * Return: Attack. the critters's attack. 
   */
  public Attack fight(String opponent) {
    this.opp = opponent;
    runAway();
    //for the first 700 moves use this strategy
    while(moveC<300){
      //if bear or string use roar
      if(opponent.equals("B")||isStringInt(opponent))
        return Attack.ROAR;
      //if 0 or l use scratch
      else if(opponent.equals("0")||opponent.equals("L"))
        return Attack.SCRATCH;
      //if e or not a string use a random int
      else if(opponent.equals("E")||!opponent.equals(toString())){
        getRand = randGen.nextInt(3);
        if(getRand == 1)
          return Critter.Attack.ROAR;
        if(getRand == 2)
          return Critter.Attack.POUNCE;
        else
          return Critter.Attack.SCRATCH;
      }
      //if past 300 moves use scratch
      else
        return Attack.SCRATCH;
    }
    //scratch by default
    return Attack.SCRATCH;
  }
  
  
  
  /* 
   * Name: getColor
   * Purpose: this assigns the color value to the critter
   * Parameters: none
   * Return: Color. color of the critter. 
   */
  public Color getColor() {
    return Color.WHITE;
  }
  
  
  
  /* 
   * Name: getMove
   * Purpose: this determines which direction the critter will move. 
   * if the object next to it is food itll move to that but otherwise it will
   * just run away in the opposite direction of an enemy.
   * Return: Direction. the direction that the critter moves. 
   */
  public Direction getMove() {
    //increment move count
    this.moveC +=1;
    //only eat for the first 200 moves
    if(moveC < 200){
      //these are just little if statements about if theres food
      //in a certain direction
      if(getNeighbor(Critter.Direction.SOUTH).equals("."))
        return Critter.Direction.SOUTH;
      if(getNeighbor(Critter.Direction.NORTH).equals("."))
        return Critter.Direction.NORTH;
      if(getNeighbor(Critter.Direction.WEST).equals("."))
        return Critter.Direction.WEST;
      if(getNeighbor(Critter.Direction.EAST).equals("."))
        return Critter.Direction.EAST;
    }
    //use runaway
    runAway();
    return dire;
  }
  
  
  
  /* 
   * Name: runaway
   * Purpose: this calls on the preda method and determines if the critter
   * will keep moving in the same direction or go a different way.
   * Parameters: none
   * Return: none
   */
  public void runAway(){
    //if an enemy is in one direction, return the opposite direction
    if(preda(Direction.NORTH))
      this.dire = Direction.SOUTH;
    else if(preda(Direction.EAST))
      this.dire = Direction.WEST;
    else if(preda(Direction.SOUTH))
      this.dire = Direction.NORTH;
    else if(preda(Direction.WEST))
      this.dire = Direction.EAST;
  }
  
  
  
  /* 
   * Name: preda
   * Purpose: to see if the object next to it is an enemy
   * Parameters: none
   * Return: boolean. if the object is an opponent, not an empty space, and 
   * not food
   * then this will return true
   */
  public boolean preda(Direction dir){
    //if the object is an opponent, not an empty space, and not food  
    if(!getNeighbor(dir).equals(toString())&&!getNeighbor(dir).equals(" ")
         &&!getNeighbor(dir).equals(".")){
      return true;
    }
    else
      return false;
  }
  
  
  
  /* 
   * Name: isE
   * Purpose: if the neighbor in w/e direction is not equal to the string then
   * the direction is changed
   * Parameters: none
   * Return: Direction. if string doesn't match then return a direction. 
   * otherwise return north by default
   */
  public Direction isE(){
    if(!getNeighbor(Direction.NORTH).equals("!"))
      return Direction.SOUTH;
    else if(!getNeighbor(Direction.EAST).equals("!"))
      return Direction.WEST;
    else if(!getNeighbor(Direction.SOUTH).equals("!"))
      return Direction.NORTH;
    else if(!getNeighbor(Direction.WEST).equals("!"))
      return Direction.EAST;
    else
      return Direction.NORTH;
  }
  
  
  
  /* 
   * Name: toString
   * Purpose: this changes the string of mycritter
   * Parameters: none
   * Return: string. it changes to a new string based on how many times
   * the critter has moved
   */
  public String toString() {
    //0 for first 200 moves
    if(moveC < 200)
      return "0";
    //b for next 150 moves
    else if(moveC > 200 && moveC <= 350)
      return "L";
    //l for next 150 moves
    else if(moveC > 350 && moveC <= 500)
      return "B";
    //E for next 200 moves
    else if(moveC > 500 && moveC <= 700)
      return "E";
    else
      return "B";
  }
  
  
  
  /* 
   * Name: isStringInt
   * Purpose: to see if the opponent is a tiger
   * Parameters: string. what the opponent is
   * Return: boolean. if it is an int then it returns true.
   */
  public static boolean isStringInt(String opponent){
    //tI is tiger int bc im using this method to see if the int is a tiger
    ArrayList<String> tI = new ArrayList<String>();
    tI.add("1");
    tI.add("2");
    tI.add("3");
    tI.add("4");
    tI.add("5");
    tI.add("6");
    tI.add("7");
    tI.add("8");
    tI.add("9");
    tI.add("10");
    if(tI.contains(opponent))
      return true;
    else
      return false;
  }
}