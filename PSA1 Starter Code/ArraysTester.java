/* 
 *  Name: John Doe
 *  Login: cs8baXX
 *  Date: January 8, 2016
 *  File: ArraysTester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 1.
 *  This tests the class FunWithIntArrays.  FunWithIntArrays is buggy, so
 *  you may wish to test with just pieces of this code before testing
 *  all of it.  We will use our own copy of this file, so when you do
 *  your final testing, ensure it is with the original.
 *  
 */

/*
 * Name:    ArraysTester
 * Purpose: To test the class FunWithIntArrays.
 */
public class ArraysTester {
    
  /*
   * Name:       main
   * Purpose:    To call methods in FunWithIntArrays and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main(String[] args) {
    
    int [] tester = {7,4,8,12,32,64,13};
    System.out.println("Creating Initial Array:");
    FunWithIntArrays.printArray(tester);

    // check array copy
    System.out.println("\nCreating Array Copy:");
    int [] copy = FunWithIntArrays.arrayCopy(tester);
    FunWithIntArrays.printArray(copy);

    //check min
    System.out.println("\nMin element is: "+
    FunWithIntArrays.findMin(tester));

    //check max
    System.out.println("\nMax element is: "+
    FunWithIntArrays.findMax(tester));

    //check sort
    System.out.println("\nTesting Sorted Array");
    int [] sort = FunWithIntArrays.arraySort(tester);
    FunWithIntArrays.printArray(sort);
  }
}
