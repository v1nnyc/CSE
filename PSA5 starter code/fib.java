public class fib{
  public static void fib(int z){
    if (z>=1)
      System.out.println(z);
    fib.fib(z-1);
  }
}