/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 22, 2016
 * File:  Rectangle.java 
 * Sources of Help: piazza
 * 
 *This is the  rectangle class. It is responsible for making rectangle objects.
 */
import java.awt.*;
import objectdraw.*;

public class Rectangle extends ARectangle {
  private int width;
  private int height;
  
  
  /* 
   * Name: Rectangle
   * Purpose: this is a rectangle constructor. it sets the defualt height and
   * width to 1
   * Parameters: none
   * Return: none 
   */
  public Rectangle() {
    //call super to assign name to member variable
    super("Rectangle",0,0);
    //default values for default constructor
    setWidth(0);
    setHeight(0);
  }
  
  
  /* 
   * Name: Rectangle
   * Purpose: this is a rectangle constructor. it sets the height and width
   * to match the parameters
   * Parameters: ints x, and y– theyre the upperleft value and ints width and 
   * height
   * Return: none 
   */
  public Rectangle(int x, int y, int width, int height) {
    //call super to assign name to member variable
    super("Rectangle",x,y);
    setWidth(width);
    setHeight(height);
  }
  
  
  /* 
   * Name: Rectangle
   * Purpose: this is a rectangle constructor. it assigns the upperleft and 
   * width and height values.
   * Parameters: Point upperleft, ints width and height.
   * Return: none 
   */
  public Rectangle(Point upperLeft, int width, int height) {
    //call super to assign name to member variable
    //and get the x and y values from the upperleft point
    //nullornah checks if the point is a null reference
    super("Rectangle", nullOrNah(upperLeft).getX(),
          nullOrNah(upperLeft).getY());
    setWidth(width);
    setHeight(height);
  }
  

  /* 
   * Name: Rectangle
   * Purpose: this is a rectangle constructor. it makes a deep copy of another
   * rectangle object
   * Parameters: Rectangle r
   * Return: none 
   */
  public Rectangle(Rectangle r) {
    //call super to assign name to member variable
    //nullOrNah checks if r is null, and if the upperLeft point is null
    //get the x and y values from r's upperLeft point
    super(nullOrNah(r).getName(), nullOrNah(r).getUpperLeft().getX(),
          nullOrNah(r).getUpperLeft().getY());
    //check to see if r is null
    if (r == null) {
      r = new Rectangle();
    }
    setWidth(r.getWidth());
    setHeight(r.getHeight());
  }
  
  
  /* 
   * Name: getWidth
   * Purpose: this is a getter for width
   * Parameters: none
   * Return: int, the width 
   */
  public int getWidth() {return this.width;}
  
  
  /* 
   * Name: getHeight
   * Purpose: this is a getter for Height
   * Parameters: none
   * Return: int, height. 
   */
  public int getHeight() {return this.height;}
  
  
  /* 
   * Name: setWidth
   * Purpose: this is a setter for width
   * Parameters: int w
   * Return: none
   */
  private void setWidth(int w) {
    this.width = w;
  }
  
  
  /* 
   * Name: setHeight
   * Purpose: this is a setter for Height
   * Parameters: int h
   * Return: none
   */
  private void setHeight(int h) {
    this.height = h;
  }
  
  
  /* 
   * Name: nullOrNah
   * Purpose: this checks if the point passed through the 
   * Rectangle(Point, int, int) constructor is null. 
   * Parameters: Point, point
   * Return: Point. a point.
   */
  private static Point nullOrNah(Point point){
    //check if point is null
    if (point == null) {
      //if it is return new point
      return new Point();
    }
    //else return original point
    return point;
  }
  
  
  /* 
   * Name: nullOrNah
   * Purpose: this checks if the rectangle passed through the 
   * Rectangle(Rectangle) constructor is null. 
   * Parameters: Rectangle, o
   * Return: A rectangle
   */
  private static Rectangle nullOrNah(Rectangle o){
    //check if o is null
    if (o == null) {
      //if it is return new rectangle
      o = new Rectangle();
    }
    //else return the original rectangle
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
    return new String(getName() + ": Upper Left Corner: Point: ("
                        +getUpperLeft()+ ") Width: " 
                        + getWidth() + " Height: " +getHeight());
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
    return (o instanceof Rectangle 
              && this.getWidth() == ((Rectangle) o).getWidth()
              && this.getHeight() == ((Rectangle) o).getHeight()
              && this.getName() == ((Rectangle) o).getName() 
              && this.getUpperLeft().equals(((Rectangle) o).getUpperLeft()));
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
    //get x and y values from upperLeft point
    int x = this.getUpperLeft().getX();
    int y = this.getUpperLeft().getY();
    //make rectangle into a drawableinterface object
    DrawableInterface rectangle;
    //if fill make a filled shape
    if(fill){
      rectangle = new FilledRect(x, y, width, height, canvas);
      rectangle.setColor(c);
    }
    //else make a framed shape
    else{
      rectangle = new FramedRect(x, y, width, height, canvas);
      rectangle.setColor(c);
    }
  }
}
