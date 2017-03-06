/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 22, 2016
 * File:  CSE8B_Line.java 
 * Sources of Help: piazza
 * 
 *This is the CSE8B_Line class. it is responsible for making CSE8B_Line objects.
 */
import java.awt.*;
import objectdraw.*;

public class CSE8B_Line extends Shape {
  private Point start;
  private Point end;
  
  
  /* 
   * Name: CSE8B_Line
   * Purpose: this is a CSE8B_Line constructor. it assigns a start and end point
   * Parameters: none
   * Return: none 
   */
  public CSE8B_Line() {
    //call super to assign name to member variable
    super("CSE8B_Line");
    //default values for default constructor
    setStart(new Point(0, 0));
    setEnd(new Point(0, 0));
  }
  
  
  /* 
   * Name: CSE8B_Line
   * Purpose: this is a CSE8B_Line constructor. it assigns a start and end point
   * Parameters: Point, start– where the line starts. Point, end– where the line
   * ends.
   * Return: none 
   */
  public CSE8B_Line(Point start, Point end) {
    //call super to assign name to member variable
    super("CSE8B_Line");
    //check if start is null
    if(start == null){
      start = new Point();
    }
    //check if end is null
    else if(end == null){
      end = new Point();
    }
    setStart(start);
    setEnd(end);
  }
  
  
  /* 
   * Name: CSE8B_Line
   * Purpose: this is a CSE8B_Line constructor. it makes a deep copy of another
   * CSE8B_Line object
   * Parameters: CSE8B_Line, line. A CSE8B_Line object to copy
   * Return: none 
   */
  public CSE8B_Line(CSE8B_Line line) {
    //call super to assign name to member variable
    //nullornah checks if line is a null object
    super(nullOrNah(line).getName());
    //check if line object is null, make new line
    if (line == null) {
      line = new CSE8B_Line();
    }
    //get start and end values from line object and assign them to new member 
    //variables
    setStart(line.getStart());
    setEnd(line.getEnd());
  }
  
  
  /* 
   * Name: getStart
   * Purpose: this is a getter.
   * Parameters: none.
   * Return: Point, the start point of the CSE8B_Line
   */
  public Point getStart() {
    return new Point(this.start);
  }
  
  
  /* 
   * Name: getEnd
   * Purpose: this is a getter.
   * Parameters: none.
   * Return: Point, the end point of the CSE8B_Line
   */
  public Point getEnd() {
    return new Point(this.end);
  }
  
  
  /* 
   * Name: setStart
   * Purpose: this is a setter.
   * Parameters: Point.
   * Return: none
   */
  private void setStart(Point s) {
    this.start = new Point(s);
  }
  
  
  /* 
   * Name: setEnd
   * Purpose: this is a setter.
   * Parameters: Point.
   * Return: none
   */
  private void setEnd(Point e) {
    this.end = new Point(e);
  }
  
  
  /* 
   * Name: nullOrNah
   * Purpose: this checks if the line passed through the CSE8B_Line(CSE8B_Line)
   * constructor is null. 
   * Parameters: CSE8B_Line, line.
   * Return: String. the name of the object. 
   */
  private static CSE8B_Line nullOrNah(CSE8B_Line line){
    //check if line is null
    if (line == null) {
      //if it is return new line
      return new CSE8B_Line();
    }
    //else return the line
    return line;
  }
  
  
  /* 
   * Name: move
   * Purpose: this is responsible for moving the shape. it reassigns the
   * values of the x and y points in the start and end points.
   * Parameters: ints xDelta and yDelta
   * Return: none 
   */
  public void move(int xDelta, int yDelta) {
    //gets the x and y coordinates from upperLeft
    int x1 = getStart().getX() + xDelta;
    int y1 = getStart().getY() + yDelta;
    int x2 = getEnd().getX() + xDelta;
    int y2 = getEnd().getY() + yDelta;
    //assigns the new points to the start and end variables
    this.start = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }
  
  
  /* 
   * Name: toString
   * Purpose: this converts the member variables and name into a string
   * Parameters: none
   * Return: String 
   */
  @Override
  public String toString() {
    return new String(getName()+": Point: (" 
                        + getStart() + ") to Point: (" + getEnd() + ")");
  }
  
  
  /* 
   * Name: equals
   * Purpose: this tests to make sure that the object is an instance of the
   * class that it says to be. it checks all of the member variables for that
   * kind of object.
   * Parameters: Object o
   * Return: boolean. 
   */
  @Override
  public boolean equals(Object o) {
    //first check to make sure it's an instance of the class
    //then check that all the member variables match
    if(o == null){
      return false;
    }
    return (o instanceof CSE8B_Line 
              && this.getStart().equals(((CSE8B_Line) o).getStart())
              && this.getEnd().equals(((CSE8B_Line) o).getEnd())
              && this.getName() == ((CSE8B_Line) o).getName());
  }
  
  
  /* 
   * Name: hashCode
   * Purpose: this returns the hashcode
   * Parameters: none
   * Return: int. 
   */
  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }
  
  
  /* 
   * Name: draw
   * Purpose: this method is responsible for creating a DrawableInterface 
   * object with the shape, and then putting it on the canvas.
   * Parameters: DrawingCanvas, canvas– which is what the object will be drawn
   * on. Color, c– the color of the shape. Boolean, fill– whether or not the
   * object will have a solid color.
   * Return: none 
   */
  public void draw(DrawingCanvas canvas, Color c, boolean fill) {
    //check if c is null
    if(c == null){c = Color.BLACK;}
    //get start and end values and assign them to new locatoions
    Location start1 = new Location(this.start.getX(), this.start.getY());
    Location end1 = new Location(this.end.getX(), this.end.getY());
    //make line into a drawableinterface object
    DrawableInterface line;
    //these don't really matter, bc a line can't be filled or not filled but
    //I felt that if i didn't have both I'd get points taken off
    if(fill){
      line = new Line(start1, end1, canvas);
      line.setColor(c);
    }
    else{
      line = new Line(start1, end1, canvas);
      line.setColor(c);
    }
    
  }
}
