public class BasicCode{
  public int x;
  public BasicCode(){
    x = 10;
  }
  public void bar()
  {
    int x = 25;
    System.out.println("x = "+x);
  }
  public static void main(String [ ] args)
  {
    BasicCode test = new BasicCode();
    test.bar();
  }
}