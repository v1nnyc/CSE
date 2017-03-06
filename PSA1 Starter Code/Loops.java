public class Loops {
  public static void main(String[] args) {
    int a = 7;
    int b = 13;
    change(b,a);
    System.out.println(a+ " " + b);
  }
  public static void change(int a, int b){
    System.out.println(a + " " + b);
    a = 22;
    b =44;
    System.out.println(a + " " + b);
  }
}
      