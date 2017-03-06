public class Increment {   
  public static void mystery( int a ) {     
    int b = a % 10;     
    System.out.println( a );     
    if ( a >= 10 ) {       
      mystery( a / 10 );     
    } 
    else {       
      System.out.println( "Stop" ); 
    }     
    System.out.println( b );   
  }
  public static void main(String[] args) {
    mystery(932);
  }
}