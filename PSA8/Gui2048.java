/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: January 25, 2016
 * File:  Gui2048.java 
 * Sources of Help: the textbook, piazza
 * 
 * This class is responsible for making the GUI for the 2048 game.
 */
/** Gui2048.java */
/** PSA8 Release */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Gui2048 extends Application
{
  private String outputBoard; // The filename for where to save the Board
  private Board board; // The 2048 Game Board
  
  private static final int TILE_WIDTH = 106;
  
  private static final int TEXT_SIZE_LOW = 55; // Low value tiles (2,4,8,etc)
  private static final int TEXT_SIZE_MID = 45; // Mid value tiles 
  //(128, 256, 512)
  private static final int TEXT_SIZE_HIGH = 35; // High value tiles 
  //(1024, 2048, Higher)
  
  // Fill colors for each of the Tile values
  private static final Color COLOR_EMPTY = Color.rgb(238, 228, 218, 0.35);
  private static final Color COLOR_2 = Color.rgb(238, 228, 218);
  private static final Color COLOR_4 = Color.rgb(237, 224, 200);
  private static final Color COLOR_8 = Color.rgb(242, 177, 121);
  private static final Color COLOR_16 = Color.rgb(245, 149, 99);
  private static final Color COLOR_32 = Color.rgb(246, 124, 95);
  private static final Color COLOR_64 = Color.rgb(246, 94, 59);
  private static final Color COLOR_128 = Color.rgb(237, 207, 114);
  private static final Color COLOR_256 = Color.rgb(237, 204, 97);
  private static final Color COLOR_512 = Color.rgb(237, 200, 80);
  private static final Color COLOR_1024 = Color.rgb(237, 197, 63);
  private static final Color COLOR_2048 = Color.rgb(237, 194, 46);
  private static final Color COLOR_OTHER = Color.BLACK;
  private static final Color COLOR_GAME_OVER = Color.rgb(238, 228, 218, 0.73);
  
  private static final Color COLOR_VALUE_LIGHT = Color.rgb(249, 246, 242); 
  // For tiles >= 8
  
  private static final Color COLOR_VALUE_DARK = Color.rgb(119, 110, 101); 
  // For tiles < 8
  
  private GridPane pane;
  
  /** Add your own Instance Variables here */
  
  private int Width;
  private int Height; 
  public int[][] grid;
  public int size;
  public StackPane stack = new StackPane();
  public int score;
  
  
  
  /* 
   * Name: start
   * Purpose: start method for primary stage
   * Parameters: Stage; primaryStage.
   * Return: void
   */
  @Override
  public void start(Stage primaryStage)
  {
    // Process Arguments and Initialize the Game Board
    processArgs(getParameters().getRaw().toArray(new String[0]));
    // Create the pane that will hold all of the visual objects
    pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    pane.setStyle("-fx-background-color: rgb(187, 173, 160)");
    // Set the spacing between the Tiles
    pane.setHgap(15); 
    pane.setVgap(15);
    //assigning score to new text
    Text score = getScore();
    //adding score to pane
    pane.add(score, 2, 0);
    //adding game
    pane.add(getGame(), 0, 0);
    //adding the pane to a stackpane
    stack.getChildren().add(pane);
    //initialize variables
    this.grid = board.getGrid();
    this.size = board.getGridSize();
    //set grid for first time
    setGrid();
    //assign stack to scene
    Scene scene = new Scene(stack);
    primaryStage.setTitle("Gui2048");
    primaryStage.setScene(scene);
    primaryStage.show();
    //only allow input from keyhandler when game is not over
    if(!board.isGameOver()){
      scene.setOnKeyPressed(new MyKeyHandler());
    }
    pane.requestFocus();  
  }
  
  
  
  /* 
   * Name: getGame
   * Purpose: this is the "2048" at the top of the GUI
   * Parameters: none
   * Return: text
   */
  public Text getGame(){
    Text game = new Text("2048");
    game.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
    game.setFill(Color.WHITE);
    return game;
  }
  
  
  /* 
   * Name: gameOver
   * Purpose: this is the transparent pane that appears when the game is over
   * Parameters: none
   * Return: a pane
   */
  public Pane gameOver(){
    Pane pane = new Pane();
    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    pane.setStyle("-fx-background-color: rgb(238, 228, 218, 0.73)");
    Text over = new Text("Game Over!");
    over.setFont(Font.font("Arial", FontWeight.BOLD, 60));
    //this makes sure that the x property is bound to the center of the pane
    over.xProperty().bind
      (stack.widthProperty().subtract
         (over.getLayoutBounds().getWidth()).divide(2));
    //this makes sure that the y property is bound to the center of the pane
    over.yProperty().bind(stack.heightProperty().divide(2));
    over.setFill(COLOR_VALUE_DARK);
    pane.getChildren().add(over);
    return pane;
  }
  
  
  /* 
   * Name: getRec
   * Purpose: this makes a new rectangle (square) it's all the tiles for the 
   * numbers
   * Parameters: a number
   * Return: a rectangle
   */
  public Rectangle getRec(int num){
    Rectangle rectangle = new Rectangle();
    rectangle.setWidth(100);
    rectangle.setHeight(100);
    //set the fill using the whatC(olor) method
    rectangle.setFill(whatC(num));
    return rectangle;
  }
  
  
  /* 
   * Name: setGrid
   * Purpose: assigns the board values from board to a new grid 
   * Parameters: none
   * Return: void
   */
  public void setGrid(){
    setScore();
    //clear the stack and panes so there's no overlap
    stack.getChildren().clear();
    pane.getChildren().clear();
    //make a score text with the score
    Text score = getScore();
    pane.add(score, 2, 0);
    //keep score in the top right
    pane.setConstraints(score, 2, 0, 3, 1, HPos.CENTER, VPos.TOP);
    pane.setHgrow(score, Priority.SOMETIMES);
    pane.add(getGame(), 0, 0);
    //loop that gets numbers from grid and puts them into pane
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        Rectangle rec = getRec(grid[i][j]);
        Text text = getText(grid[i][j]);
        pane.add(rec, i, j+1);
        pane.add(text, i, j+1);
        pane.setHalignment(text, HPos.CENTER);
        
      }
    }
    //add the pane
    stack.getChildren().add(pane);
    //if the game is over add the game over pane
    if(board.isGameOver()){
      stack.getChildren().add(gameOver());
    }
  }
  
  
  /* 
   * Name: getScore
   * Purpose: this gets the score and assigns it to a text
   * Parameters: none
   * Return: a text
   */
  public Text getScore(){
    Text amount = new Text();
    amount.setText("Score: " + score);
    amount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));
    amount.setFill(COLOR_VALUE_DARK);
    return amount;
  }
  
  
  /* 
   * Name: setScore
   * Purpose: this is a setter for score
   * Parameters: none
   * Return: void
   */
  public void setScore(){
    this.score = board.getScore();
  }
  
  
  /* 
   * Name: getText
   * Purpose: sets the color of the text for the tiles
   * Parameters: num
   * Return: text
   */
  public Text getText(int num){
    Text someText = new Text();
    //for numbers between (0,infinity]
    if(num > 0){
      someText.setText(Integer.toString(num));
      someText.setFill(COLOR_VALUE_DARK);
    }
    //if above 8 use light color
    if(num >= 8){
      someText.setText(Integer.toString(num));
      someText.setFill(COLOR_VALUE_LIGHT);
    }
    someText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
    return someText;
  }
  
  
  /* 
   * Name: whatC
   * Purpose: this is the method that determines what colors to use based on
   * the int value
   * Parameters: num
   * Return: color
   */
  public Color whatC(int num){
    if(num == 0){return COLOR_EMPTY;}
    else if (num == 2){return COLOR_2;}
    else if (num == 4){return COLOR_4;}
    else if (num == 8){return COLOR_8;}
    else if (num == 16){return COLOR_16;}
    else if (num == 32){return COLOR_32;}
    else if (num == 64){return COLOR_64;}
    else if (num == 128){return COLOR_128;}
    else if (num == 256){return COLOR_256;}
    else if (num == 512){return COLOR_512;}
    else if (num == 1024){return COLOR_1024;}
    else if (num == 2048){return COLOR_2048;}
    else return COLOR_OTHER;
  }
  
  
  /* 
   * Name: MyKeyHandler
   * Purpose: this is the event handler
   * Parameters: none
   * Return: none
   */
  public class MyKeyHandler implements EventHandler<KeyEvent> {
    @Override
    /* 
     * Name: handle
     * Purpose: this handles the keyevent
     * Parameters: keyevent e
     * Return: void
     */
      public void handle(KeyEvent e){
      switch (e.getCode()) {
        //for up key
        case UP: 
          if(board.canMove(Direction.UP)){
          System.out.println("Moving Up");
          board.move(Direction.UP);
          board.addRandomTile();
        }
          setGrid(); 
          break;
          //for down key
        case DOWN: 
          if(board.canMove(Direction.DOWN)){
          System.out.println("Moving Down");
          board.move(Direction.DOWN);
          board.addRandomTile();
        }
          setGrid(); 
          break;
          //for left key
        case LEFT: 
          if(board.canMove(Direction.LEFT)){
          System.out.println("Moving Left");
          board.move(Direction.LEFT);
          board.addRandomTile();
        }
          setGrid(); 
          break;
          //for right key
        case RIGHT: 
          if(board.canMove(Direction.RIGHT)){
          System.out.println("Moving Right");
          board.move(Direction.RIGHT);
          board.addRandomTile();
        }
          setGrid(); 
          break;
          //for s key
        case S:if(!board.isGameOver()){
          System.out.println("Saving Board to outputFile");
          try {
            board.saveBoard("outputFile");
          } catch (IOException o) { 
            System.out.println("saveBoard threw an Exception");
          }
        }
        break;
      }
    }
  }
  
 
  
  /** DO NOT EDIT BELOW */
  
  // The method used to process the command line arguments
  private void processArgs(String[] args)
  {
    String inputBoard = null;   // The filename for where to load the Board
    int boardSize = 0;          // The Size of the Board
    
    // Arguments must come in pairs
    if((args.length % 2) != 0)
    {
      printUsage();
      System.exit(-1);
    }
    // Process all the arguments 
    for(int i = 0; i < args.length; i += 2)
    {
      if(args[i].equals("-i"))
      {   // We are processing the argument that specifies
        // the input file to be used to set the board
        inputBoard = args[i + 1];
      }
      else if(args[i].equals("-o"))
      {   // We are processing the argument that specifies
        // the output file to be used to save the board
        outputBoard = args[i + 1];
      }
      else if(args[i].equals("-s"))
      {   // We are processing the argument that specifies
        // the size of the Board
        boardSize = Integer.parseInt(args[i + 1]);
      }
      else
      {   // Incorrect Argument 
        printUsage();
        System.exit(-1);
      }
    }
    // Set the default output file if none specified
    if(outputBoard == null)
      outputBoard = "2048.board";
    // Set the default Board size if none specified or less than 2
    if(boardSize < 2)
      boardSize = 4;
    
    // Initialize the Game Board
    try{
      if(inputBoard != null)
        board = new Board(inputBoard, new Random());
      else
        board = new Board(boardSize, new Random());
    }
    catch (Exception e)
    {
      System.out.println(e.getClass().getName() + 
                         " was thrown while creating a " +
                         "Board from file " + inputBoard);
      System.out.println("Either your Board(String, Random) " +
                         "Constructor is broken or the file isn't " +
                         "formated correctly");
      System.exit(-1);
    }
  }
  
  // Print the Usage Message 
  private static void printUsage()
  {
    System.out.println("Gui2048");
    System.out.println("Usage:  Gui2048 [-i|o file ...]");
    System.out.println();
    System.out.println("  Command line arguments come in pairs of the "+ 
                       "form: <command> <argument>");
    System.out.println();
    System.out.println("  -i [file]  -> Specifies a 2048 board that " + 
                       "should be loaded");
    System.out.println();
    System.out.println("  -o [file]  -> Specifies a file that should be " + 
                       "used to save the 2048 board");
    System.out.println("                If none specified then the " + 
                       "default \"2048.board\" file will be used");  
    System.out.println("  -s [size]  -> Specifies the size of the 2048" + 
                       "board if an input file hasn't been"); 
    System.out.println("                specified.  If both -s and -i" + 
                       "are used, then the size of the board"); 
    System.out.println("                will be determined by the input" +
                       " file. The default size is 4.");
  }
}
