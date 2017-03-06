/*
 * Test Driver given to the students to drive the methods
 * they write in class ReverseRecurse.
 *
 */

import java.util.*;

/**
 * Test class used just as a driver to call the methods of RecurseReverse
 * written by the students.
 */

public class TestReverseRecurse
{

  /**
   * Main method to drive the test calls.
   */

  public static void main( String[] args )
  {

    int[] array = null;
    int[] copyOfArray = null;
    int[] arrayReversed = null;

    ReverseRecurse reverseRecurseRef = new ReverseRecurse();

    /*
     * Initialize the array with user (stdin) input.
     */

    array = reverseRecurseRef.initArray();

    /*
     * Make a copy of the original array for second recursive reverse() test.
     */

    copyOfArray = new int[array.length];
    System.arraycopy( array, 0, copyOfArray, 0, array.length );

    /*
     * Display the contents of the original array before we start
     * manipulating it.
     */

    System.out.println( "\nThe original array:" );
    reverseRecurseRef.printArray( array );

    /*
     * Recursive reverse() that manipulates the passed in array directly
     * with lower and upper bounds.
     */

    reverseRecurseRef.reverse( array, 0, array.length - 1 );

    System.out.println( "The array reversed (manipulating array directly):" );
    reverseRecurseRef.printArray( array );

    /*
     * Let's reverse() again to get the original ordering back
     */

    reverseRecurseRef.reverse( array, 0, array.length - 1 );

    System.out.println( "The array reversed again " +
                        "(manipulating array directly)\n" +
			"(should be back in original order):" );
    reverseRecurseRef.printArray( array );

    /*
     * Set the array reference we are passing to all the methods to our
     * copy of the original array to test with second recursive reverse().
     */

    array = copyOfArray;

    System.out.println( "The copy of the original array:" );
    reverseRecurseRef.printArray( array );

   /*
    * Recursive reverse() that returns a new array that is the reverse
    * of passed in array.  No hi/lo bounds passed in.
    */

    arrayReversed = reverseRecurseRef.reverse( array );

    System.out.println( "The array reversed " +
                        "(reversed array returned vs. direct manipulation):" );
    reverseRecurseRef.printArray( arrayReversed );

    System.out.println( "The original array showing original NOT modified:" );
    reverseRecurseRef.printArray( array );




    /*
     * Neither of the reverse() methods should do anything if a null object was
     * passed in instead of a valid array. The following tests tests for whether
     * there are any null array object checks within the reverse() methods.
     */
    try{
      System.out.println("Testing reverse method (direct manipulation)"
		          + " with null array input:");
      reverseRecurseRef.reverse(null, 0, 1);

      System.out.println("  SUCCESS: No NullPointerException thrown.");
    }
    catch(NullPointerException e)
    {
      System.err.println("  FAIL: NullPointerException - Fix me!");
    }

    try{
      System.out.println("\nTesting reverse method (returned reversed" +
		          " array) with null array input:");
      reverseRecurseRef.reverse(null);

      System.out.println("  SUCCESS: No NullPointerException thrown.");
    }
    catch(NullPointerException e)
    {
      System.err.println("  FAIL: NullPointerException - Fix me!");
    }






  } // End main()

} // End ReverseRecurseTestDriver
