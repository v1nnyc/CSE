//package chessboardtest;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class ChessboardTest extends Application {

    final int size = 10;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();

        final GridPane chessboard = new GridPane();
        fillChessboard(chessboard, size);

        ChangeListener<Number> resizeListener = new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                double newWidth = chessboard.getWidth() / size;
                double newHeight = chessboard.getHeight() / size;

                for(Node n: chessboard.getChildren()) {
                    Canvas canvas = (Canvas)n;
                    canvas.setWidth(newWidth);
                    canvas.setHeight(newHeight);
                }
            }
        };

        chessboard.widthProperty().addListener(resizeListener);
        chessboard.heightProperty().addListener(resizeListener);

        root.getChildren().add(chessboard);
        root.setPadding(new Insets(10));
        VBox.setVgrow(chessboard, Priority.ALWAYS);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("chessboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void fillChessboard(GridPane pane, int size) {
        class RedrawListener implements ChangeListener<Number> {
            Color color;
            Canvas canvas;
            public RedrawListener(Canvas c, int i) {
                if(i % 2 == 0) {
                    color = Color.BLACK;
                }
                else {
                    color = Color.WHITE;
                }
                canvas = c;
            }

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                canvas.getGraphicsContext2D().setFill(color);
                canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            }
        }

        for(int row = 0; row < size; row++) {
            for(int col = 0, i = row; col < size; col++, i++) {
                Canvas c = new Canvas();
                RedrawListener rl = new RedrawListener(c, i);
                c.widthProperty().addListener(rl);
                c.heightProperty().addListener(rl);

                pane.add(c, row, col);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}