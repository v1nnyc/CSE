/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 22, 2016
 * File:  Triangle.java 
 * Sources of Help: piazza
 * 
 *This is the triangle class. It is responsible for making triangle objects.
 */
import java.awt.*;
import objectdraw.*;

public class Triangle extends Shape {
  private Point p1;
  private Point p2;
  private Point p3;
  
  
  /* 
   * Name: Triangle
   * Purpose: this is a default constructor for a triangle. it initializes
   * the member variables to empty points.
   * Parameters: none
   * Return: none 
   */
  public Triangle() {
    //call super to assign name to member variable
    super("Triangle");
    //default values for default constructor
    setp1(new Point(0,0));
    setp2(new Point(0,0));
    setp3(new Point(0,0));
  }
  
  
  /* 
   * Name: Triangle
   * Purpose: this is a constructor for a triangle object. it initializes the
   * member variables.
   * Parameters: Points, p1, p2, and p3.
   * Return: none 
   */
  public Triangle(Point p1, Point p2, Point p3) {
    //call super to assign name to member variable
    super("Triangle");
    //use nullornah to check if the points are null
    setp1(nullOrNah(p1));
    setp2(nullOrNah(p2));
    setp3(nullOrNah(p3));
  }
  
  
  /* 
   * Name: Triangle
   * Purpose: this is a triangle constructor. it makes a deep copy of another
   * triangle object.
   * Parameters: Triangle tri.
   * Return: none 
   */
  public Triangle(Triangle tri) {
    //call super to assign name to member variable, use nullornah to check
    //if triangle is null
    super(nullOrNah(tri).getName());
    //account for edge case
    if(tri == null){
      tri = new Triangle();
    }
    //initialize variables
    setp1(tri.getp1());
    setp2(tri.getp2());
    setp3(tri.getp3());
  }
  
  
  /* 
   * Name: getp1
   * Purpose: this is a getter.
   * Parameters: none
   * Return: returns p1 
   */
  public Point getp1(){
    return new Point(this.p1);
  }
  
  
  /* 
   * Name: getp2
   * Purpose: this is a getter.
   * Parameters: none
   * Return: returns p2 
   */
  public Point getp2(){
    return new Point(this.p2);
  }
  
  
  /* 
   * Name: getp3
   * Purpose: this is a getter.
   * Parameters: none
   * Return: returns p3 
   */
  public Point getp3(){
    return new Point(this.p3);
  }
  
  /* 
   * Name: setp1
   * Purpose: this is a setter.
   * Parameters: point p1
   * Return: none  
   */
  private void setp1(Point p1){
    this.p1 = new Point(p1);
  }
  
  /* 
   * Name: setp2
   * Purpose: this is a setter.
   * Parameters: point p2
   * Return: none  
   */
  private void setp2(Point p2){
    this.p2 = new Point(p2);
  }
  
  /* 
   * Name: setp3
   * Purpose: this is a setter.
   * Parameters: point p3
   * Return: none  
   */
  private void setp3(Point p3){
    this.p3 = new Point(p3);
  }
  
  
  /* 
   * Name: nullOrNah
   * Purpose: this checks if the point passed through the Triangle
   * constructor is null. 
   * Parameters: Point, point
   * Return: String. the name of the object. 
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
   * Purpose: this checks if the triangle passed through the Triangle(Triangle)
   * constructor is null. 
   * Parameters: Triangle, o
   * Return: Triangle.
   */
  private static Triangle nullOrNah(Triangle o){
    //check if o is null
    if (o == null) {
      //if it is return new Triangle
      return new Triangle();
    }
    //else return original triangle.
    return o;
  }
  
  
  /* 
   * Name: move
   * Purpose: this is responsible for moving the shape. it reassigns the
   * values of the x and y points in the start and end points.
   * Parameters: ints xDelta and yDelta
   * Return: none 
   */
  public void move(int xDelta, int yDelta) {
    //get point1, get the x value and add delta, repeat with y value.
    this.p1 = new Point( (getp1().getX() + xDelta) , (getp1().getY() + yDelta));
    //get point2, get the x value and add delta, repeat with y value.
    this.p2 = new Point( (getp2().getX() + xDelta) , (getp2().getY() + yDelta));
    //get point3, get the x value and add delta, repeat with y value.
    this.p3 = new Point( (getp3().getX() + xDelta) , (getp3().getY() + yDelta));
  }
  
  
  /* 
   * Name: toString
   * Purpose: this converts the member variables and name into a string
   * Parameters: none
   * Return: String 
   */
  @Override
  public String toString() {
    return new String(getName()+": Point: (" + getp1() +"), Point: (" 
                        + getp2() +"), Point: (" + getp3() +")");
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
    return (o instanceof Triangle 
              && this.getp1().equals(((Triangle) o).getp1())
              && this.getp2().equals(((Triangle) o).getp2())
              && this.getp3().equals(((Triangle) o).getp3())
              && this.getName() == ((Triangle) o).getName());
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
    if(c == null){c = Color.BLACK;}
    Location p1 = new Location(this.p1.getX(), this.p1.getY());
    Location p2 = new Location(this.p2.getX(), this.p2.getY());
    Location p3 = new Location(this.p3.getX(), this.p3.getY());
    DrawableInterface line;
    if(fill){
      line = new Line(p1, p2, canvas);
      line.setColor(c);
      line = new Line(p2, p3, canvas);
      line.setColor(c);
      line = new Line(p1, p3, canvas);
      line.setColor(c);
    }
    else{
      line = new Line(p1, p2, canvas);
      line.setColor(c);
      line = new Line(p2, p3, canvas);
      line.setColor(c);
      line = new Line(p3, p1, canvas);
      line.setColor(c);
    }
  }
  
}
