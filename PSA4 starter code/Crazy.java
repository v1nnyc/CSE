public class Crazy {   
  private int n;   
  private boolean bool;   
  public Crazy() {}   
  public Crazy(int n, boolean bool) { 
    this.n = n++;     
    this.bool = bool;   
  }   
  public Crazy(int n){     
    this.n = n++ * 2;  
    System.out.println(n);
    if(n == 20) {       
      this.bool = true;
    }     
    else {       
      this.n = ++n;       
      this.bool = false; 
    } 
  }   
  public String toString() {     
    return this.n + ", " + this.bool;   
  }   
  public static void main(String[] args)   {
    int n = 10;     
    boolean bool = true;    
    Crazy var1 = new Crazy();   
    System.out.println(var1);  
    Crazy var2 = new Crazy(n, bool);  
    System.out.println(var2);   
    Crazy var3 = new Crazy(n);    
    System.out.println(var3);   
  }
}