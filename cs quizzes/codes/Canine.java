public class Canine extends Animal {  
  public void makeNoise() {   
    System.out.println("Growl!");  
  } 
  public void eat() {  
    makeNoise();  
    System.out.println("We eat bones!");  
    super.eat();
  } 
} 
