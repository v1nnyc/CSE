public class fibonacci{
  public static int fibonacci(int n){
    if(n <= 1){
      return n;
    }
    else{
      return fibonacci(n-2)+fibonacci(n-1);
    }
  }
  
}