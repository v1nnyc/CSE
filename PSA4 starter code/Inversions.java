public class Inversions{
  public static void main( String[] args ){
    int[] poop = new int[8];
    poop[0] = 1;
    poop[1] = 2;
    poop[2] = 23;
    poop[3] = 6;
    poop[4] = 4;
    poop[5] = 5;
    poop[6] = 7;
    poop[7] = 8;
    int hey = inversions(poop);
    System.out.println(hey);
    }
  public static int inversions(int [] array){
    int positionOfMax = 0;
    int tempMax = array[0];
    int tempPos = 0;
    for(int i = 1; i<array.length; i++){
        if ( array[i]>tempMax ) {       
          tempMax = array[i];
          tempPos= i;
  }
    }
  return array[tempPos];
  }
}