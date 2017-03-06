/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: January 25, 2016
 * File:  Board.java 
 * Sources of Help: the textbook, piazza
 * 
 * This program does a lot of stuff! it can make a board object from nothing, or
 * it can load a previously saved board. there's a method that can save a baord
 * to a file and one that will add a random tile to the board you create. the 
 * tile is either 2 or 4. there's also a method that will rotate the board - 
 * clockwise if a passed boolean is true and counter clockwise if false.
 */
//------------------------------------------------------------------//
// Board.java                                                       //
//                                                                  //
// Class used to represent a 2048 game board                        //
//                                                                  //
// Author:  W16-CSE8B-TA group                                      //
// Date:    1/17/16                                                 //
//------------------------------------------------------------------//

/**
 * Sample Board
 * <p/>
 * 0   1   2   3
 * 0   -   -   -   -
 * 1   -   -   -   -
 * 2   -   -   -   -
 * 3   -   -   -   -
 * <p/>
 * The sample board shows the index values for the columns and rows
 * Remember that you access a 2D array by first specifying the row
 * and then the column: grid[row][column]
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/* 
 * Name: Board
 * Purpose: this is where all the boards for 2048 get made
 * Parameters: none
 * Return: void
 */
public class Board {
  public final int NUM_START_TILES = 2;
  public final int TWO_PROBABILITY = 90;
  public final int GRID_SIZE;
  
  
  private final Random random;
  private int[][] grid;
  private int score;
  private int tempScore;
  public int[][] tempGrid;
  
  /* 
   * Name: Board
   * Purpose: this constructor creates a board with a size of 
   * boardSizeXboardSize
   * it adds a certain amount of random tiles corresponding to the numstarttiles
   * variable
   * Parameters: boardsize, its an int. it is the size of the board. random is a 
   * random, it determines where and what tile will be placed when the addrandom
   * tile method is called
   * Return: none 
   */
  public Board(int boardSize, Random random) {
    this.GRID_SIZE = boardSize;
    this.random = random;
    this.grid = new int[GRID_SIZE][GRID_SIZE];
    this.score = 0;
    this.tempGrid=grid;
    //loop that executes addrandomtiles however many times numstarttiles is 
    //equal
    for(int i = 0; i<NUM_START_TILES; i++){
      this.addRandomTile();
    }
  }
  
  /* 
   * Name: Board
   * Purpose: this constructor loads a board from a saved file
   * Parameters: inputBoard. its a string. its the file name of the board
   * you want to load. random is a random. it initializes the random value
   * of the class but that's it.
   * Return: none 
   */
  public Board(String inputBoard, Random random) throws IOException {
    java.io.File file = new java.io.File(inputBoard);
    Scanner input = new Scanner(file);  
    //reading the grid size first and initializing
    this.GRID_SIZE = Integer.parseInt(input.next());
    //reading and initializing score
    this.score = Integer.parseInt(input.next());
    this.grid = new int[GRID_SIZE][GRID_SIZE];
    this.tempGrid=grid;
    //this loops through the string and assigns each number to a tile in grid
    for(int row = 0; row<GRID_SIZE; row++){
      for(int column = 0; column<GRID_SIZE; column++){
        this.grid[row][column]=Integer.parseInt(input.next());
      }
    }
    this.random = random;
  }
  
  /* 
   * Name: saveBoard
   * Purpose: this method can be used to save your 2048 board to a file when
   * you want to quit
   * Parameters: outputBoard. its a string. it is what the file will be called.
   * Return: void 
   */
  public void saveBoard(String outputBoard) throws IOException {
    java.io.File file = new java.io.File(outputBoard);
    java.io.PrintWriter output = new java.io.PrintWriter(file);
    //writing the grid size first
    output.print(Integer.toString(this.GRID_SIZE));
    output.print('\n');
    //writing the score below that
    output.print(Integer.toString(this.score));
    output.print('\n');
    //this loops through the grid and writes each number
    for(int row = 0; row<GRID_SIZE; row++){
      for(int column = 0; column<GRID_SIZE; column++){
        output.print(Integer.toString(this.grid[row][column])+ ' ');
      }
      //theres a new line after the last number
      output.print('\n');
    }
    output.close();
  }
  
  /* 
   * Name: addRandomTile
   * Purpose: this method adds a random tile to your 2048 board. it uses the 
   * classes random variable to determine the location and value of the tile
   * Parameters: none
   * Return: void 
   */
  public void addRandomTile() {
    //this checks to see how many open spaces are left on the board
    int count = 0;
    for(int row = 0; row<GRID_SIZE; row++){
      for(int column = 0; column<GRID_SIZE; column++){
        if(this.grid[row][column]==0){
          count++;
        }
      }
    }
    //if there aren't open spaces, dont add tiles and return
    if (count == 0){
      return;
    }
    //this adds the tile
    else{
      //location and value are determined randomly
      int location = this.random.nextInt(count);
      int value = this.random.nextInt(100);
      int daOne = -1;
      //this loops through the grid to the location int and adds the tile there
      for(int row = 0; row<GRID_SIZE; row++){
        for(int column = 0; column<GRID_SIZE; column++){
          if(this.grid[row][column]==0){
            daOne++;
            if(daOne == location){
              //adds 2 or 4 depending on probability
              if(value<TWO_PROBABILITY){
                this.grid[row][column] = 2;
              }
              else{
                this.grid[row][column] = 4;
              }
            }
          }
        }
      }
    }
  }
  
  /* 
   * Name: rotate
   * Purpose: this method will rotate the board - clockwise if a passed boolean
   * is true and counter clockwise if false
   * Parameters: rotateClockwise, its a boolean. if its true the board is 
   * //rotated
   * clockwise, and counter clockwise if false.
   * Return: void 
   */
  public void rotate(boolean rotateClockwise) {
    //create a temp board
    Board shadow = new Board(this.GRID_SIZE, this.random);
    if(rotateClockwise == true){
      //this loop assigns the rotated valus to the temp grid
      for(int row = 0; row<GRID_SIZE; row++){
        for(int column = 0; column<this.GRID_SIZE; column++){
          shadow.grid[column][this.GRID_SIZE-row-1]=this.grid[row][column];
        }
      }
      //these loops assign the temp values back to the original grid
      for(int row = 0; row<GRID_SIZE; row++){
        for(int column = 0; column<this.GRID_SIZE; column++){
          this.grid[row][column]=shadow.grid[row][column];
        }
      }
    }
    //this rotate counter clockwise
    else if(rotateClockwise == false){
      //these loops assigns the rotated valus to the temp grid
      for(int row = 0; row<GRID_SIZE; row++){
        for(int column = 0; column<this.GRID_SIZE; column++){
          shadow.grid[this.GRID_SIZE-1-column][row]=this.grid[row][column];
        }
      }
      //these loops assign the temp values back to the original grid
      for(int row = 0; row<GRID_SIZE; row++){
        for(int column = 0; column<this.GRID_SIZE; column++){
          this.grid[row][column]=shadow.grid[row][column];
        }
      }
    }
  }
  
  //Complete this method ONLY if you want to attempt at getting the extra credit
  //Returns true if the file to be read is in the correct format, else return
  //false
  public static boolean isInputFileCorrectFormat(String inputFile) {
    
//The try and catch block are used to handle any exceptions
    //Do not worry about the details, just write all your conditions inside the
    //try block
    try {
      
      //write your code to check for all conditions and return true if it 
      //satisfies
      //all conditions else return false
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  /* 
   * Name: move
   * Purpose: this method will move the tiles in a certain direction based on
   * the parameter
   * Parameters: direction. it is a direction. this determines which method is
   * used to move the tiles
   * Return: boolean. it returns true if the tiles were moved in that direction
   */
  public boolean move(Direction direction) {
    //calling on tempGrid method to make a tempgrid
    tempGrid();
    //initializing tempScore variable
    this.tempScore= score;
    if(canMove(direction) ==true){
      //calling on method to move down
      if(direction == Direction.DOWN){
        moveTilesRight();
        return true;
      }
      //calling on method to move up
      else if(direction == Direction.UP){
        moveTilesLeft();
        return true;
      }
      //calling on method to move right
      else if(direction == Direction.RIGHT){
        moveTilesDown();
        return true;
      }
      //calling method to move left
      else if(direction == Direction.LEFT){
        moveTilesUp();
        return true;
      }
    }
    //return false if no moves worked
    return false;
  }
  
  /* 
   * Name: moveTilesUp
   * Purpose: this method calls on moveRowsUp to move any tiles, then
   * calls on combineTiles to combine any available tiles, and then recalls
   * on moveRowsUp to move tiles right after they're combined
   * Parameters: none
   * Return: moved. boolean. if the method moves or combines any tiles moved is
   * returned as true
   */
  public boolean moveTilesUp() {
    boolean moved = false;
    //calling on moveRowsUp 
    if (moveRowsUp()==true){
      //signifying that tiles were moved
      moved = true;
    }
    for (int col = 0; col < GRID_SIZE; col++) {
      for (int row = 0; row < (GRID_SIZE - 1); row++) {
        int row2 = row + 1;
        //calling on combineTiles for rows/columns
        moved = combineTiles(row2, col, row, col);
      }
    }
    //if the moveRowsUp loop is true, then the board was moved (moved = true)
    if (moveRowsUp()==true){
      moved = true;
    }
    return moved;
  }
  
  /* 
   * Name: moveRowsUp
   * Purpose: this method loops through all the tiles and determines if any
   * can be moved up. it calls on the moveTiles method.
   * Parameters: none
   * Return: moved. boolean. if the method moves any tiles moved is returned
   * as true
   */
  private boolean moveRowsUp() {
    boolean moved = false;
    //because we're moving rows up we have to start with columns
    for (int col = 0; col < GRID_SIZE; col++) {
      boolean rowMoved = false;
      //perform this loop at least once, and then for every time that rowMoved
      //is true
      do{
        rowMoved = false;
        for (int row = 0; row < (GRID_SIZE - 1); row++) {
          int row2 = row + 1;
          boolean tileMoved = moveTile(row2, col, row, col);
          //when there are no more tiles to move rowMoved becomes false and the 
          //loop will end
          if (tileMoved==true) {
            rowMoved = true;
            moved = true;
          }
        }
      }while(rowMoved==true);     
    }
    return moved;
  }
  
  /* 
   * Name: moveTilesDown
   * Purpose: this method calls on moveRowsDown to move any tiles, then
   * calls on combineTiles to combine any available tiles, and then recalls
   * on moveRowsDown to move tiles right after they're combined
   * Parameters: none
   * Return: moved. boolean. if the method moves or combines any tiles moved is
   * returned as true
   */
  public boolean moveTilesDown() {
    boolean moved = false;
    //if moveRowsDown is performed then the board has been moved
    if (moveRowsDown()){
      moved = true;
    }
    //this assigns combination of the rows and columns we want to have moved
    //by combineTiles
    for (int col = 0; col < GRID_SIZE; col++) {
      for (int row = GRID_SIZE - 1; row > 0; row--) {
        int row2 = row - 1;
        moved = combineTiles(row2, col, row, col);
      }
    }
    //if the moveRowsDown loop is true, then the board was moved (moved = true)
    if (moveRowsDown()==true){
      moved = true;
    }
    return moved;
  }
  
  /* 
   * Name: moveRowsDown
   * Purpose: this method loops through all the tiles and determines if any
   * can be moved down. it calls on the moveTiles method.
   * Parameters: none
   * Return: moved. boolean. if the method moves any tiles moved is returned
   * as true
   */
  private boolean moveRowsDown() {
    boolean moved = false;
    //because we're moving rows we have to start with columns
    for (int col = 0; col < GRID_SIZE; col++) {
      boolean rowMoved = false;
      //perform this loop at least once, and then for every time that rowMoved
      //is true
      do{
        rowMoved = false;
        for (int row = GRID_SIZE - 1; row > 0; row--) {
          int row2 = row - 1;
          boolean tileMoved = moveTile(row2, col, row, col);
          //when there are no more tiles to move rowMoved becomes false and the 
          //loop will end
          if (tileMoved==true) {
            rowMoved = true;
            moved = true;
          }
        }
      }while(rowMoved==true);     
    }
    return moved;
  }
  
  /* 
   * Name: moveTilesLeft
   * Purpose: this method calls on moveColumnsLeft to move any tiles, then
   * calls on combineTiles to combine any available tiles, and then recalls
   * on moveColumnsLeft to move tiles right after they're combined
   * Parameters: none
   * Return: moved. boolean. if the method moves or combines any tiles moved is
   * returned as true
   */
  public boolean moveTilesLeft() {
    boolean moved = false;
    //if moveColumnsLeft is performed then the board has been moved
    if (moveColumnsLeft()==true){
      moved = true;
    }
    //this assigns combination of the rows and columns we want to have moved
    //by combineTiles
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int col = 0; col < (GRID_SIZE - 1); col++) {
        int col2 = col + 1;
        moved = combineTiles(row, col2, row, col);
      }
    }
    //if the moveColumnsLeft loop is true, then the board was moved 
    //(moved = true)
    if (moveColumnsLeft()==true){
      moved = true;
    }
    return moved;
  }
  
  /* 
   * Name: moveColumnsLeft
   * Purpose: this method loops through all the tiles and determines if any
   * can be moved to the left. it calls on the moveTiles method.
   * Parameters: none
   * Return: moved. boolean. if the method moves any tiles moved is returned
   * as true
   */
  
  private boolean moveColumnsLeft() {
    boolean moved = false;
    //because we're moving columns we have to start with rows
    for (int row = 0; row < GRID_SIZE; row++) {
      boolean colMoved = false;
      //perform this loop at least once, and then for every time that rowMoved
      //is true
      do{
        colMoved = false;
        for (int col = 0; col < (GRID_SIZE - 1); col++) {
          int col2 = col + 1;
          boolean tileMoved = moveTile(row, col2, row, col);
          //when there are no more tiles to move rowMoved becomes false and the 
          //loop will end
          if (tileMoved==true) {
            colMoved = true;
            moved = true;
          }
        }
      }while(colMoved==true);      
    }
    return moved;
  }
  
  /* 
   * Name: moveTilesRight
   * Purpose: this method calls on moveColumnsRight to move any tiles, then
   * calls on combineTiles to combine any available tiles, and then recalls
   * on moveColumnsRight to move tiles right after they're combined
   * Parameters: none
   * Return: moved. boolean. if the method moves or combines any tiles moved is
   * returned as true
   */
  public boolean moveTilesRight() {
    boolean moved = false;
    //if moveColumnsRight is performed then the board has been moved
    if (moveColumnsRight()==true){
      moved = true;
    }
    //this assigns combination of the rows and columns we want to have moved
    //by combineTiles
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int col = (GRID_SIZE - 1); col > 0; col--) {
        int col2 = col - 1;
        moved = combineTiles(row, col2, row, col);
      }
    }
    //if the moveColumnsRight loop is true, then the board was moved 
    //(moved = true)
    if (moveColumnsRight()==true){
      moved = true;
    }
    return moved;
  }
  
  /* 
   * Name: moveColumnsRight
   * Purpose: this method loops through all the tiles and determines if any
   * can be moved to the right. it calls on the moveTiles method.
   * Parameters: none
   * Return: moved. boolean. if the method moves any tiles moved is returned
   * as true
   */
  private boolean moveColumnsRight() {
    boolean moved = false;
    //because we're moving columns we have to start with rows
    for (int row = 0; row < GRID_SIZE; row++) {
      boolean colMoved=false;
      //perform this loop at least once, and then for every time that rowMoved
      //is true
      do{
        colMoved = false;
        for (int col = (GRID_SIZE - 1); col > 0; col--) {
          int col2 = col - 1;
          boolean tileMoved = moveTile(row, col2, row, col);
          //when there are no more tiles to move rowMoved becomes false and the 
          //loop will end
          if (tileMoved==true) {
            colMoved = true;
            moved = true;
          }
        }
      }while (colMoved==true);   
    }
    return moved;
  }
  
  /* 
   * Name: combineTiles
   * Purpose: this method will combine similar tiles and increment the score
   * Parameters: row1, col1, row2, col2, they are all ints. they represent
   * the tiles that can be combined with each other
   * Return: moved. boolean. if the method combines any tiles moved is returned
   * as true
   */
  private boolean combineTiles(int row1, int col1, int row2, int col2) {
    boolean moved=false;
    //make sure that the adjacent tile to be combined is NOT zero
    if (grid[row1][col1]!=0) {
      //reference that value of the tile
      int value = grid[row1][col1];
      //if the adjacent tiles are the same value:
      if (grid[row2][col2] == value) {
        //a new value will be double the value
        int newValue = value + value;
        //one adjacent tile is replaced with the newValue
        grid[row2][col2]= newValue;
        //other adjacent tile becomes zero
        grid[row1][col1]=0;
        //increment score
        score = score + newValue;
        moved = true;
      }
    }
    return moved;
  }
  
  /* 
   * Name: movetile
   * Purpose: this method will move all the tiles on the board in a certain
   * direction
   * Parameters: row1, col1, row2, col2, they are all ints. they represent
   * the tiles that can be moved/switched with each other
   * Return: moved. boolean. if the method moves any tiles moved is returned
   * as true
   */
  private boolean moveTile(int row1, int col1, int row2, int col2) {
    boolean moved = false;
    //make sure that the tile you're moving is NOT zero
    //make sure that the spot you're moving the tile to IS zero
    if (grid[row1][col1]!=0
          && (grid[row2][col2]==0)) {
      //reference to the value of the tile
      int value = grid[row1][col1];
      //assign the empty spot with the other value
      grid[row2][col2]=value;
      //old tile becomes zero
      grid[row1][col1]=0;
      moved = true;
    }
    return moved;
  }
  
  /* 
   * Name: isGameOver
   * Purpose: this method will determine whether or not the game is over. it
   * calls the gridFull and movesLeft methods
   * Parameters: none
   * Return: boolean. if it's true then the game is over. 
   */
  public boolean isGameOver() {
    //game is over when you can't move AND there are no empty spots
    if(gridFull()&&!movesLeft()){
      return true;
    }
    return false;
  }
  
  /* 
   * Name: gridFull
   * Purpose: this method checks if the grid is full
   * Parameters: none
   * Return: boolean. it returns false if there are any zeros in the grid
   */
  private boolean gridFull(){
    //cycle through columns by rows
    for(int row=0;row<GRID_SIZE;row++){
      for(int col=0;col<GRID_SIZE;col++){
        //if any of the spots == 0, then the grid isn't full
        if(grid[row][col]==0){
          return false;
        }
      }
    }
    return true;
  }
  
  /* 
   * Name: movesLeft
   * Purpose: this method checks if there are any tiles that can be merged
   * Parameters: none
   * Return: boolean. it returns true if there are, indeed, any tiles that can
   * be merged
   */
  private boolean movesLeft(){
    //cycle through columns by rows
    for(int row=0;row<GRID_SIZE;row++){
      for(int col=0;col<GRID_SIZE-1;col++){
        //if any tile is the same value as the tile to the right then there are
        //moves left
        if(grid[row][col]==grid[row][col+1]){
          return true;
        }
      }
    }
    //cycle through rows by columns
    for(int row=0;row<GRID_SIZE-1;row++){
      for(int col=0;col<GRID_SIZE;col++){
        //if any tile is equal to the tile below it then there are moves left
        if(grid[row][col]==grid[row+1][col]){
          return true;
        }
      }
    }
    return false;
  }
  
  /* 
   * Name: canMove
   * Purpose: this method determines whether an inputted move is valid
   * Parameters: direction. its a direction. 
   * Return: boolean. true if you can move in the parameter direction
   */
  public boolean canMove(Direction direction) { 
    //checks if you can move down
    if(direction == Direction.DOWN){
      return canMoveDown();
    }
    //checks if you can move up
    if(direction == Direction.UP){
      return canMoveUp();
    }
    //checks if you can move right
    if(direction == Direction.RIGHT){
      return canMoveRight();
    }
    //checks if you can move left
    if(direction == Direction.LEFT){
      return canMoveLeft();
    }
    return false;
  }
  
  /* 
   * Name: canMoveDown
   * Purpose: this method checks if you can move in a certain direction.
   * it checks if theres an open space or if there are two tiles that
   * can merge
   * Parameters: none
   * Return: boolean. it returns true if theres an open space or if there are
   * two tiles that can merge
   */
  private boolean canMoveDown(){
    //loop through rows by columns
    for(int col =0;col<GRID_SIZE;col++){
      for(int row=GRID_SIZE-1;row>0;row--){
        //if adjacent tile is equal, can move down
        if(grid[row][col]!=0 && grid[row][col]==grid[row-1][col]){
          return true;
        }
        //if adjacent spot is empty, can move down
        if(grid[row][col]==0 && grid[row-1][col]!=0){
          return true;
        }
      }
    }
    return false;
  }
  
  /* 
   * Name: canMoveUp
   * Purpose: this method checks if you can move in a certain direction.
   * it checks if theres an open space or if there are two tiles that
   * can merge
   * Parameters: none
   * Return: boolean. it returns true if theres an open space or if there are
   * two tiles that can merge
   */
  private boolean canMoveUp(){
    //loop through rows by columns
    for(int col =0;col<GRID_SIZE;col++){
      for(int row=0;row<GRID_SIZE-1;row++){
        //if adjacent tile is equal, can move up
        if(grid[row][col]!=0 && grid[row][col]==grid[row+1][col]){
          return true;
        }
        //if adjacent spot is empty, can move up
        if(grid[row][col]==0 && grid[row+1][col]!=0){
          return true;
        }
      }
    }
    return false;
  }
  
  /* 
   * Name: canMoveRight
   * Purpose: this method checks if you can move in a certain direction.
   * it checks if theres an open space or if there are two tiles that
   * can merge
   * Parameters: none
   * Return: boolean. it returns true if theres an open space or if there are
   * two tiles that can merge
   */
  private boolean canMoveRight(){
    //loop through columns by rows
    for(int row = 0; row<GRID_SIZE;row++){
      for(int col = GRID_SIZE-1;col>0;col--){
        //if adjacent tile is equal, can move right
        if(grid[row][col]!=0&&grid[row][col]==grid[row][col-1]){
          return true;
        }
        //if adjacent spot is empty, can move right
        if(grid[row][col]==0 && grid[row][col-1]!=0){
          return true;
        }
      }
    }
    return false;
  }
  
  /* 
   * Name: canMoveLeft
   * Purpose: this method checks if you can move in a certain direction.
   * it checks if theres an open space or if there are two tiles that
   * can merge
   * Parameters: none
   * Return: boolean. it returns true if theres an open space or if there are
   * two tiles that can merge
   */
  private boolean canMoveLeft(){
    //loop through columns by rows
    for(int row = 0; row<GRID_SIZE;row++){
      for(int col = 0;col<GRID_SIZE-1;col++){
        //if adjacent tile is equal, can move left
        if(grid[row][col]!=0&&grid[row][col]==grid[row][col+1]){
          return true;
        }
        //if adjacent spot if empty, can move left
        if(grid[row][col]==0 && grid[row][col+1]!=0){
          return true;
        }
      }
    }
    return false;
  }
  
  /* 
   * Name: getGrid
   * Purpose: this method returns the current state of the 2048 board.
   * Parameters: none
   * Return: int[][]. it is a 2d array of the board. 
   */
  public int[][] getGrid() {
    return grid;
  }
  
  /* 
   * Name: getScore
   * Purpose: this method will return the instance variable score.
   * Parameters: none
   * Return: int. the score. 
   */
  public int getScore() {
    return score;
  }
  
  
   /* 
   * Name: getGridSize
   * Purpose: this method will return the instance variable GRID_SIZE.
   * Parameters: none
   * Return: int. the gridsize. 
   */
  public int getGridSize() {
    return GRID_SIZE;
  }
  
  /* 
   * Name: undo
   * Purpose: this method will undo your last move
   * Parameters: none
   * Return: none
   */
  public void undo(){
    //assign value of temp score to the score instance variable
    this.score=tempScore;
    //assign tempGrid to grid instance variable
    this.grid=tempGrid;
  }
  
  /* 
   * Name: tempGrid
   * Purpose: this method initializes the tempGrid variable and then assigns
   * all the values from grid to tempGrid
   * Parameters: none
   * Return: none
   */
  public void tempGrid(){
    //creates a new grid of the same size
    this.tempGrid = new int[GRID_SIZE][GRID_SIZE];
    //loop through columns by rows
    for(int row = 0; row<GRID_SIZE; row++){
      for(int column = 0; column<GRID_SIZE; column++){
        //copies every tile from old grid to temp grid
        this.tempGrid[row][column]=this.grid[row][column];
      }
    }
  }
  
  /* 
   * Name: toString
   * Purpose: i am not surewhat this is? it looks like it translates the board
   * into a string to be saved. 
   * Parameters: none
   * Return: string 
   */
  @Override
  public String toString() {
    StringBuilder outputString = new StringBuilder();
    outputString.append(String.format("Score: %d\n", score));
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int column = 0; column < GRID_SIZE; column++)
        outputString.append(grid[row][column] == 0 ? "    -" :
                              String.format("%5d", grid[row][column]));
      
      outputString.append("\n");
    }
    return outputString.toString();
  }
}

