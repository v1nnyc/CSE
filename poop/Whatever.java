import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import objectdraw.*;
import java.awt.*;

public class Whatever extends Application{
  @Override
  public void start(Stage primaryStage){
    Button btOK = new Button("OK");
    Scene scene = new Scene(btOK, 200, 250);
    primaryStage.setTitle("MyJavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args){
    Application.launch(args);
  }
}