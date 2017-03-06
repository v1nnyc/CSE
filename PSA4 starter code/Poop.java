public class Poop{
  public static int doSomething(int n){
    if (n==0)
      return n;
    else
      return n + doSomething(n-1);
  }

public static void main(String [] args){
  int x = doSomething(4);
  System.out.println(x);
}
}