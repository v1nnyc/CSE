public class FunWithIntArrays {
/*
 * Name:  Vincent Cannalla
 * Login: cs8bwals 
 * Date:  January 11, 2016
 * File:  Caesar.java
 */
 /*
  * Name:       findMax
  * Purpose:    finds the max value in array of ints
  * Parameters: an array
  * Return:     max int
  */ 
 public static int findMax(int[] array) {
  //short circuit protects null access
  if (array == null || array.length == 0)
   return -1;

  int max = array[0];

  for (int i = 0; i < array.length; i++) {
   if (array[i] > max) {
    max = array[i];
   }
  }

  return max;
 }

  /*
  * Name:       findMin
  * Purpose:    finds the min value in array of ints
  * Parameters: an array
  * Return:     min int
  */ 
 public static int findMin(int array[]) {
  //short circuit protects null access
  if (array == null || array.length == 0)
   return -9;

  int min = array[0];

  for (int i = 0; i < array.length; i++) {
   if (array[i] < min) {
    min = array[i];
   }
  }

  return min;
 }


 /*
  * Name:       arrayCopy
  * Purpose:    copies an array into a new array
  * Parameters: an array
  * Return:     an array of ints
  */ 
 public static int[] arrayCopy(int array[]) {
  if (array == null)
   return null;

  int[] result = new int[array.length];

  for (int i = 0; i < array.length; i++) {
   result[i] = array[i];
  }
  return result;
 }

 /*
  * Name:       printArray
  * Purpose:    to print each value in an array
  * Parameters: an array
  * Return:     void
  */ 
 public static void printArray(int[] array) {
  if (array == null)
   return;

  for (int i = 0; i < array.length; i++) {
   System.out.print(array[i] + ", ");
  }

  System.out.println();
 }

 /*
  * Name:       arraySort
  * Purpose:    sorts ints in an array from lowest to greatest value
  * Parameters: an array
  * Return:     an array of sorted ints
  */ 
 public static int[] arraySort(int[] array) {
  if (array == null)
   return null;

  int[] result = new int[array.length];

  for (int i = 0; i < array.length - 1; ++i) {
   for (int j = 0; j < array.length - i - 1; j++) {
    if (array[j] > array[j + 1]) {
     //swapping array[j] and array[j+1]
     int temp = array[j+1];
     array[j + 1] = array[j];
     array[j] = temp;
    }
   }
  }
  return array;
 }
}
