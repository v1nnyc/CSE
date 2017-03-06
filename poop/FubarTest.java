public class FubarTest{
  public static int mystery(int a){
    int b = a - 3;
    if (b>=5){
      System.out.println(a + " " + b);
      a = b - mystery(b+1);
    }
    else{
      System.out.println("stop");
      b = a + 2;
    }
    System.out.println( a + " " + b);
    return a+b;
  }
}