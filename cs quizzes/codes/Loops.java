public class Loops {   
  public static void main( String[] args ) { 
    final int MAX = 8, MIN = 6;       int i = -2, j = -3;       for ( i = MAX; i > MIN; --i ) {          j = 7;          while ( j <= MAX ) {             System.out.println( i + " " + j );              ++j; } }       System.out.println( i + " " + j );     } }