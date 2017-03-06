import turtleClasses.*;
import java.awt.Color;
import java.util.concurrent.*;

public class CS8BTurtle_Threaded1{
  
  
  public static void main(String[] args){
    
    
    World w = new World(800,500);
    ExecutorService executor = Executors.newCachedThreadPool();
    
    executor.execute(new Cturtle(w, 'C', 100, 90, 500));
    executor.execute(new Cturtle(w, 'S', 180, 90, 500));
    executor.execute(new Cturtle(w, '8', 260, 90, 500));
    executor.execute(new Cturtle(w, 'B', 340, 90, 500));
    executor.execute(new Cturtle(w, 'W', 420, 90, 500));
    executor.execute(new Cturtle(w, 'A', 500, 90, 500));
    executor.execute(new Cturtle(w, 'L', 580, 90, 500));
    executor.execute(new Cturtle(w, 'S', 660, 90, 500));
    executor.execute(new Cturtle(w, 'W', 180, 210, 500));
    executor.execute(new Cturtle(w, 'I', 260, 210, 500));
    executor.execute(new Cturtle(w, 'N', 340, 210, 500));
    executor.execute(new Cturtle(w, 'T', 420, 210, 500));
    executor.execute(new Cturtle(w, 'E', 500, 210, 500));
    executor.execute(new Cturtle(w, 'R', 580, 210, 500));
    executor.execute(new Cturtle(w, '2', 260, 330, 500));
    executor.execute(new Cturtle(w, '0', 340, 330, 500));
    executor.execute(new Cturtle(w, '1', 420, 330, 500));
    executor.execute(new Cturtle(w, '6', 500, 330, 500));
    
    executor.shutdown();
  }
}

class Cturtle extends CS8BTurtle implements Runnable{
  
  
  private final static int PEN_WIDTH = 10;
  private final static Color PEN_COLOR = Color.BLUE;
  private char ch;
  private int x;
  private int y;
  
  
  public Cturtle(World w, char ch, int x, int y, int delay) {
    super(w, delay);
    this.ch = ch;
    this.x = x;
    this.y = y;
  }
  
  @Override
  public void run() {
    this.setPenWidth(PEN_WIDTH);
    this.setPenColor(PEN_COLOR);
    switch(ch) {
      case 'C': this.drawC(x, y); break;
      case 'S': this.drawS(x, y); break;
      case '8': this.draw8(x, y); break;
      case 'B': this.drawB(x, y); break;
      case 'W': this.drawW(x, y); break;
      case 'A': this.drawA(x, y); break;
      case 'L': this.drawL(x, y); break;
      case 'I': this.drawI(x, y); break;
      case 'N': this.drawN(x, y); break;
      case 'T': this.drawT(x, y); break;
      case 'E': this.drawE(x, y); break;
      case 'R': this.drawR(x, y); break;
      case '2': this.draw2(x, y); break;
      case '0': this.draw0(x, y); break;
      case '1': this.draw1(x, y); break;
      case '6': this.draw6(x, y); break;
    }
  }
}
