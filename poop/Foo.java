public class Foo {   
  public Foo() {
    
    System.out.println( "Foo ctor #1" ); }   public Foo( int x, int y ) {     this();     System.out.println( "Foo ctor #2" );   }   public String toString() {     System.out.println( "Foo.toString" );     return "Foo"; } }