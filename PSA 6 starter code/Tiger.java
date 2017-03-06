/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 8, 2016
 * File:  Tiger.java 
 * Sources of Help: piazza
 * 
 *This is the tiger class. it is responsible for making the tiger objects. it 
 * assigns the color to the tigers, their eat value, how they attack 
 * and the direction they will move in
 */
import java.awt.*;
import java.util.Random;
public class Tiger extends Critter{
  public int hunger;
  private int moveC;
  public int movesLeft;
  public Direction dire;
  
  /* 
   * Name: Tiger
   * Purpose: this is the tiger constructor. it assigns the hunger, moveC, dire, 
   * and moveLeft variables.
   * Parameters: int hunger. its how many times the lion object will eat.
   * Return: none 
   */
  public Tiger(int hunger){
    this.hunger = hunger;
    this.moveC = 0;
    this.dire = moveDecider();
    //bc tiger moves in rounds of three movesLeft is three move than the move
    //count
    this.movesLeft = moveC +3;
  }
  
  /* 
   * Name: getColor
   * Purpose: this determines the color of the lion
   * Parameters: none
   * Return: color. yellow. 
   */
  public Color getColor() {
    return Color.YELLOW;
  }
  
  /* 
   * Name: eat
   * Purpose: this constructor determines whether or not the lion will eat. if 
   * the amount of times the lion has eaten is greater than 0 the lion will 
   * still eat.
   * Parameters: none
   * Return: boolean. if true then the lion will eat. 
   */
  public boolean eat() {
    if(hunger>0){
      //decrement hunger
      this.hunger -= 1;
      return true;
    }
    else
      return false;
  }
  
  /* 
   * Name: fight
   * Purpose: this is the constructor to determine how the tiger will fight. if 
   * the tiger is hungry then it will use scratch, otherwise it will pounce
   * Parameters: String. opponent. this parameter doesn't apply to this class
   * Return: Attack. how the tiger attacks. 
   */
  public Attack fight(String opponent) {
    //if the tiger is still hungry it uses scratch
    if(hunger > 0){
      return Attack.SCRATCH;
    }
    //else it uses pounce
    else
      return Attack.POUNCE;
  }
  
  /* 
   * Name: getMove
   * Purpose: constructor that determines the move of the bear. it picks a 
   * random direction and uses it three times, then picks a new random 
   * direction.
   * Parameters: none
   * Return: Direction.  
   */
  public Direction getMove() {
    //if its still within three moves, go in the same direction
    if(moveC < movesLeft){
      this.moveC += 1;
      return dire;
    }
    //if its been more than three moves
    else{
      //reassign movesLeft to three more than current move count
      this.movesLeft = moveC +3;
      //make a new random direction
      this.dire = moveDecider();
      //recurse this method with new direction
      return getMove();
    }   
  }
  
  /* 
   * Name: moveDecider
   * Purpose: this assigns a random int to a direction and returns it to the 
   * getMove constructor
   * Parameters: none
   * Return: Direction. the random Direction 
   */
  public Direction moveDecider(){
    //new random
    Random isRandom = new Random();
    int random = isRandom.nextInt(4);
    //assigning random ints to dif directions
    if(random == 0)
      return Direction.NORTH;
    else if(random == 1)
      return Direction.EAST;
    else if(random == 2)
      return Direction.SOUTH;
    else
      return Direction.WEST;
  }
  
  /* 
   * Name: toString
   * Purpose: this determines what the tiger will appear as in the simulator.
   * it's the number of hungry that it is. 
   * Parameters: none
   * Return: String. a number representing how hungry the tiger is. 
   */
  public String toString() {
    //make the hunger count into a string
    return ("" + (hunger));
  }  
}