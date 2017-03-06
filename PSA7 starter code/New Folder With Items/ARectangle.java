/* 
 * Name: Vincent Cannalla 
 * Login: cs8bwals  <<< --- Use your cs8b course-specific account name 
 * Date: February 22, 2016
 * File:  ARectangle.java 
 * Sources of Help: piazza
 * 
 *This is the abstract rectangle class. It is responsible for setting methods
 * for the rectangle and square classes.
 */
import objectdraw.*;

public abstract class ARectangle extends Shape {
  private Point upperLeft;
  
  
   /* 
   * Name: ARectangle
   * Purpose: this is a rectangle constructor. it assigns a point value to
   * the upperLeft member variable
   * Parameters: none
   * Return: none 
   */
  public ARectangle() {
    //call super to initialize member variable
    super("ARectangle");
    this.upperLeft = new Point(0,0);
  }
  
  
   /* 
   * Name: ARectangle
   * Purpose: this is a rectangle constructor. it assigns a name using the
   * super method and assigns a point value to the upperLeft member variable
   * Parameters: String, a name. ints x and y
   * Return: none 
   */
  public ARectangle(String name, int x, int y) {
    //call super to initialize name
    super(name);
    this.upperLeft = new Point(x,y);
  }
  
  
  /* 
   * Name: ARectangle
   * Purpose: this is a rectangle constructor. it assigns a name using the
   * super method and assigns a point value to the upperLeft member variable
   * Parameters: String, a name. A point, which is upperLeft
   * Return: none 
   */
  public ARectangle(String name, Point upperLeft) {
    //call super to initialize name
    super(name);
    this.upperLeft = upperLeft;
  }
  
  
  /* 
   * Name: ARectangle
   * Purpose: this is a rectangle constructor. it assigns a name using the
   * super method and assigns a point value to the upperLeft member variable.
   * It basically makes a deep copy of another rectangle
   * Parameters: String, a name. ARectangle, r.
   * Return: none 
   */
  public ARectangle(ARectangle r) {
    //call super to initialize name
    super(r.getName());
    //assigning the points from r's upperLeft x and y coordinates to a new point
    //and then to upperLeft member variable
    this.upperLeft = new Point((r.getUpperLeft().getX()),
                               (r.getUpperLeft().getY()));
  }
  
  
  /* 
   * Name: move
   * Purpose: this is responsible for moving the shape. it reassigns the
   * values of the x and y points in upperLeft.
   * Parameters: ints xDelta and yDelta
   * Return: none 
   */
  public void move(int xDelta, int yDelta) {
    //gets the x and y coordinates from upperLeft and then adds the delta
    //values to them
    int x = getUpperLeft().getX() + xDelta;
    int y = getUpperLeft().getY() + yDelta;
    this.upperLeft = new Point(x, y);
  }
  
  
  /* 
   * Name: getUpperLeft
   * Purpose: this is a getter.
   * Parameters: none
   * Return: Point, the upperLeft member variable. 
   */
  public Point getUpperLeft() {
    return new Point(this.upperLeft);
  }
  
  
  /* 
   * Name: setUpperLeft
   * Purpose: this is a setter.
   * Parameters: Ints x and y
   * Return: Point, upperLeft. 
   */
  public Point setUpperLeft(int x, int y){
    this.upperLeft = new Point(x,y);
    return new Point(x,y);
  }
  
  
  /* 
   * Name: toString
   * Purpose: this converts the member variables and name into a string
   * Parameters: none
   * Return: String 
   */
  @Override
  public String toString() {
    return new String(getName()+": Upper Left Corner: Point: ("+ getUpperLeft()+ ")");
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
    return (o instanceof ARectangle 
              && this.getUpperLeft() == ((ARectangle) o).getUpperLeft()
              && this.getName() == ((ARectangle) o).getName());
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
}
