/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 8, 2016
 * File:  Lion.java 
 * Sources of Help: piazza
 * 
 *This is the lion class. it is responsible for making the lion objects. it 
 * assigns the color to the lions, their eat value, how they attack
 * and the direction they will move in
 */
import java.awt.*;
public class Lion extends Critter{
  public boolean isFull;
  private int moveC;
  
  /* 
   * Name: Lion
   * Purpose: this is the lion constructor. it assigns values to the isFull and
   * moveC variables.
   * Parameters: none
   * Return: none 
   */
  public Lion(){
    this.isFull = true;
    this.moveC = 0;
  }
  
  /* 
   * Name: getColor
   * Purpose: this assigns the color value to the lion
   * Parameters: none
   * Return: Color. color of the lion. 
   */
  public Color getColor() {
    return Color.RED;
  }
  
  /* 
   * Name: eat
   * Purpose: this is the eat constructor that determines whether or not the 
   * lion
   * will eat. if the lion has been in a fight since the last time it ate it 
   * will
   * eat again. otherwise it wont
   * Parameters: none
   * Return: boolean. if it's true the lion will eat. 
   */
  public boolean eat() {
    //if the lion has not eaten then return true
    if(isFull == false){
      this.isFull = true;
      return true;
    }
    else
      return false;
  }
  
  /* 
   * Name: fight
   * Purpose: this is the fight constructor. it determines what move the lion 
   * will
   * use. if the opponent is a bear the lion will use roar. otherwise pounce.
   * Parameters: String. opponent. the opponent determines which move will be 
   * used
   * Return: Attack. the lion's attack. 
   */
  public Attack fight(String opponent) {
    //when the lion fights it becomes "hungry" again 
    //assign false to isFull
    this.isFull = false;
    //if the opponent is a bear then use roar
    if(opponent.equals("B"))
      return Attack.ROAR;
    else 
      return Attack.POUNCE;
  }
  
  /* 
   * Name: getMove
   * Purpose: this determines which direction the lion will move. it move south 
   * for the first 5 moves, then west, then north, and then west. then it 
   * repeats.
   * Parameters: none
   * Return: Direction. the direction that the lion moves. 
   */
  public Direction getMove() {
    //there are 20 moves in a lion path so use modulus 20
    int moveDecide = moveC % 20;
    //for the first 5 moves, move south
    if(0<=moveDecide && moveDecide<=4){
      //incrememnt move count
      this.moveC += 1;
      return Direction.SOUTH;
    }
    //next 5 moves move west
    else if(5<=moveDecide && moveDecide<=9){
      //increment
      this.moveC += 1;
      return Direction.WEST;
    }
    //next 5 moves move north
    else if(10<=moveDecide && moveDecide<=14){
      //increment
      this.moveC += 1;
      return Direction.NORTH;
    }
    //next 5 moves move east
    else if(15<=moveDecide && moveDecide<=19){
      //increment
      this.moveC += 1;
      return Direction.EAST;
    }
    this.moveC += 1;
    return Direction.CENTER;
  }
  
  /* 
   * Name: toString
   * Purpose: this is what the lion will appear as in the simulator.
   * Parameters: none
   * Return: String. L. for lion. 
   */
  public String toString() {
    return "L";
  } 
}