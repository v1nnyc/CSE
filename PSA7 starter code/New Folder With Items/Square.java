/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 22, 2016
 * File:  Square.java 
 * Sources of Help: piazza
 * 
 *This is the  square class. It is responsible for making square objects.
 */
import java.awt.*;
import objectdraw.*;

public class Square extends ARectangle {
  private int side;
  
  
  /* 
   * Name: Square
   * Purpose: this is a square constructor. it sets the default side length
   * to 1
   * Parameters: none
   * Return: none 
   */
  public Square() {
    //call super to assign name to member variable
    super("Square",0,0);
    setSide(0);
  }
  
  
  /* 
   * Name: square
   * Purpose: this is a square constructor. it sets the upperleft point to 
   * x and y and initializes the side member variable
   * Parameters: ints x and y– for the upperleft parameter, and an int for side
   * Return: none 
   */
  public Square(int x, int y, int side) {
    //call super to assign name to member variable
    super("Square", x, y);
    setSide(side);
  }
  
  
  /* 
   * Name: square
   * Purpose: this is a square constructor. it sets the upperleft point to 
   * the parameter point and initializes the side member variable
   * Parameters: a point, the upperleft. and int side.
   * Return: none 
   */
  public Square(Point upperLeft, int side) {
    //call super to assign name to member variable
    //get x and y values from upperLeft point
    //nullornah checks if upperleft is null
    super("Square", nullOrNah(upperLeft).getX(), 
          nullOrNah(upperLeft).getY());
    setSide(side);
  }
  
  
  /* 
   * Name: square
   * Purpose: this is a square constructor. it makes a deep copy of another
   * square object.
   * Parameters: square, a square object.
   * Return: none 
   */
  public Square(Square square) {
    //call super to assign name to member variable
    //get x and y values from square's upperLeft point
    //nullornah checks if the passed square is null, and then if the 
    //points are null
    super(nullOrNah(square).getName(), 
          nullOrNah(square).getUpperLeft().getX(),
          nullOrNah(square).getUpperLeft().getY());
    //use nullornah to check square again
    int side = nullOrNah(square).getSide();
    setSide(side);
  }
  
  
  /* 
   * Name: getSide
   * Purpose: this is a getter. 
   * Parameters: none
   * Return: returns the side int.
   */
  public int getSide() {return this.side;}
  
  
  /* 
   * Name: setSide
   * Purpose: this is a setter. 
   * Parameters: int s
   * Return: none
   */
  private void setSide(int s) {
    this.side = s;
  }
  
  
  /* 
   * Name: nullOrNah
   * Purpose: this checks if the point passed through the Square
   * constructor is null. 
   * Parameters: Point, point.
   * Return: Point.
   */
  private static Point nullOrNah(Point point){
    //check if point is null
    if (point == null) {
      //if it is return new point
      return new Point();
    }
    //else return the original point
    return point;
  }
  
  
  /* 
   * Name: nullOrNah
   * Purpose: this checks if the square passed through the Square(Square)
   * constructor is null. 
   * Parameters: Square, o.
   * Return: A square. 
   */
  private static Square nullOrNah(Square o){
    //check if o is null
    if (o == null) {
      //if it is return square
      o = new Square();
    }
    //else return a square 
    return o;
  }
  
  
  /* 
   * Name: toString
   * Purpose: this converts the member variables and name into a string
   * Parameters: none
   * Return: String 
   */
  @Override
  public String toString() {
    return new String(getName()+": Upper Left Corner: Point: ("
                        +getUpperLeft()+ ") Sides: " + getSide() );
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
    return (o instanceof Square 
              && this.getSide() == ((Square) o).getSide()
              && this.getName() == ((Square) o).getName() 
              && this.getUpperLeft().equals(((Square) o).getUpperLeft()));
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
    //get x and y values form the upperLeft point
    int x = this.getUpperLeft().getX();
    int y = this.getUpperLeft().getY();
    //make square into a drawableinterface object
    DrawableInterface square;
    //if fill then make a filled shape
    if(fill){
      square = new FilledRect(x, y, side, side, canvas);
      square.setColor(c);
    }
    //else it is a framed shape
    else
      square = new FramedRect(x, y, side, side, canvas);
    square.setColor(c);
    
  }
}
