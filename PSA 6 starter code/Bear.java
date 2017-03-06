/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 8, 2016
 * File:  Bear.java 
 * Sources of Help: piazza
 * 
 *This is the bear class. it is responsible for making the bear objects. it 
 * assigns the color to the bears, their eat value, how they attack (scratch)
 * and the direction they will move in
 */
import java.awt.*;
public class Bear extends Critter{
  public boolean grizzly;
  public int moveC;
  /* 
   * Name: Bear
   * Purpose: this is the bear class and it generates new bears. it initializes
   * the grizzly and move count variables.
   * Parameters: boolean. grizzly.
   * Return: none 
   */
  public Bear(boolean grizzly){
    this.grizzly = grizzly;
    this.moveC = 0;
  }
  
  /* 
   * Name: getColor
   * Purpose: this is a constructor for bear. it assigns the color value to the 
   * bear depending on whether or not it is a grizzly (if not then it is white)
   * Parameters: none
   * Return: Color. its a color. if the bear is a grizzly then it is brown, else 
   * it is white
   */
  public Color getColor() {
    //if grizzly color is brown
    if(grizzly)
      //new color is brown
      return (new Color(190,110,50));
    else
      //if not color is white
      return Color.WHITE;
  }
  
  /* 
   * Name: eat
   * Purpose: this just says whether or not the bear eats
   * Parameters: none
   * Return: boolean. eat. if true then the bear eats. 
   */
  public boolean eat() {
    return true;
  }
  
  /* 
   * Name: fight
   * Purpose: this is the constructor that tells the game how the bear will 
   * fight
   * Parameters: String. opponent. in this class, the parameter doesn't do 
   * anything.
   * Return: Attack. it's how the bear will attack. 
   */
  public Attack fight(String opponent) {
    return Attack.SCRATCH;
  }
  
  /* 
   * Name: getMove
   * Purpose: this constructor tels the game how the bear will move. if the bear
   * is on an odd move then it will move south, if it's an even move then it 
   * will move east
   * Parameters: none
   * Return: Direction. the direction that the bear moves in. 
   */
  public Direction getMove() {
    //increment move count every move
    this.moveC+=1;
    //to alternate use modulus 
    if(moveC % 2 == 1)
      //if odd return south
      return Direction.SOUTH;
    else
      //if even return east
      return Direction.EAST;
  }
  
  /* 
   * Name: toString
   * Purpose: this is what the bear will appear as when you run the simulator
   * Parameters: none
   * Return: String. B. for bear 
   */
  public String toString() {
    return "B";
  }
}
