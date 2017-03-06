/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 8, 2016
 * File:  Dragon.java 
 * Sources of Help: piazza
 * 
 *This is the dragon class. it is responsible for making the dragon objects. it 
 * assigns the color to the dragons, their eat value, how they attack
 * and the direction they will move in
 */
import java.awt.*;
import java.util.Random;
public class Dragon extends Critter{
  private int moveC;
  public Attack atta;
  public Attack lastMove;
  public int eaten;
  
  /* 
   * Name: Dragon
   * Purpose: this is the constructor for dragon objects. it initializes the 
   * lastMove, moveC[ount] and eaten variables.
   * Parameters: none
   * Return: none 
   */
  public Dragon(){
    this.lastMove = moveDecider();
    this.moveC = 1;
    this.eaten = 0;
  }
  
  /* 
   * Name: getColor
   * Purpose: this assigns the color to the dragon. if the dragon has eaten an 
   * odd amount of food then the color is white, if it is an even amount then 
   * black
   * Parameters: none
   * Return: Color. the color of the dragon. 
   */
  public Color getColor() {
    if(eaten % 2 == 0)
      //if eaten is even
      return Color.BLACK;
    else
      //if eaten is odd
      return Color.WHITE;
  }
  
  /* 
   * Name: eat
   * Purpose: this is the eat constructor. the dragon always eats. but this also
   * increments the amount of food the dragon has eaten.
   * Parameters: none
   * Return: boolean. always true. 
   */
  public boolean eat() {
    //increment eaten by one
    this.eaten  += 1;
    return true;
  }
  
  /* 
   * Name: getMove
   * Purpose: this is the constructor that determines what direction the dragon
   * will move in. I basically drew a picture and labeled the direction with the 
   * move count and assigned each direction to every number of moves in the 
   * path that the dragon makes.
   * Parameters: none
   * Return: Direction. the direction it will move. 
   */
  public Direction getMove() {
    //there are 40 moves in the dragon path so we use modulus 40
    int move = moveC %40;
    //these were all the moves when the dragon moves west
    if(move== 1||move == 3||move==5||move==7||move==9||move==32||move==34
         ||move==36||move==38||move==0){
      //increment move count
      this.moveC += 1;
      return Direction.WEST;
    }
    //these were all the moves when the dragon moves south
    else if(move==2||move==4||move==6||move==8||move==10||move==11||move==13
              ||move==15||move==17||move==19){
      //increment
      this.moveC += 1;
      return Direction.SOUTH;
    }
    //these were all the moves when the dragon moves east
    else if(move==12||move==14||move==16||move==18||move==20||move==21||move==23
              ||move==25||move==27||move==29){
      //increment
      this.moveC += 1;
      return Direction.EAST;
    }
    //these were all the moves when dragon moves north
    else if(move==22||move==24||move==26||move==28||move==30||move==31||move==33
              ||move==35||move==37||move==39){
      //increment
      this.moveC += 1;
      return Direction.NORTH;
    }
    return Direction.CENTER;
  }
  
  /* 
   * Name: fight
   * Purpose: this is the fight constructor. it has a different move depending 
   * on what the last opponent was
   * Parameters: String. opponent. its the opponent that the dragon fights. 
   * i use it to assign a new attack to the lastMove variable
   * Return: Attack. the dragon's attack  
   */
  public Attack fight(String opponent) {
    //reassigning the lastmove to attack variable
    this.atta = lastMove;
    // if it's a bear
    if(opponent.equals("B")){
      //assign roar to lastmove
      this.lastMove = Attack.ROAR;
      return atta;
    }
    //if its a lion
    else if(opponent.equals("L")){
      //assign pounce to lastmove
      this.lastMove = Attack.POUNCE;
      return atta;
    }
    else
      //assign scratch to lastmove
      this.lastMove = Attack.SCRATCH;
    return atta;
  }
  
  /* 
   * Name: toString
   * Purpose: this is how the dragon will appear on the board
   * Parameters: none
   * Return: String. D. for dragon 
   */
  public String toString() {
    return "D";
  }
  
  /* 
   * Name: moveDecider
   * Purpose: this assigns a random value to a random direction. and it gets 
   * returned to the Dragon constructor to the lastMove variable
   * Parameters: none
   * Return: Attack. the attack. 
   */
  public Attack moveDecider(){
    //new random
    Random isRandom = new Random();
    int random = isRandom.nextInt(3);
    //assigning the random ints to moves
    if(random == 0)
      return Attack.ROAR;
    else if(random == 1)
      return Attack.SCRATCH;
    else 
      return Attack.POUNCE;
  }
}