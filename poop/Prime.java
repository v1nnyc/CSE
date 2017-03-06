public class Prime{
  public static void main(String[] args){
    for(int i =0; i<500; i++){
      int n = ((i*i)+i+41);
      if(!isPrime(n))
        System.out.println(i);
    }
  }
  public static boolean isPrime(int n) {
    //check if n is a multiple of 2
    if (n%2==0) return false;
    //if not, then just check the odds
    for(int i=3;i*i<=n;i+=2) {
      if(n%i==0)
        return false;
    }
    return true;
  }
}