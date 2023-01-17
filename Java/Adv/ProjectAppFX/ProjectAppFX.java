/**************
Ruben Bautista
CS 56 (Java)
Project App
October 25, 2021
***************/
package projectappfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class ProjectAppFX extends Application {

    Polyline cur;

    @Override
    public void start(Stage primaryStage) {
        
        cur = null;
        BorderPane bord = new BorderPane();
        Pane pane = new Pane();
        Button clear = new Button("Clear");
        
        pane.setOnMouseClicked(mc -> {
            if (mc.getClickCount() == 1) {
                if (cur == null) {
                    cur = new Polyline(mc.getX(), mc.getY());
                    pane.getChildren().add(cur);
                } else {
                    cur.getPoints().addAll(mc.getX(), mc.getY());
                }
            } else {
                cur = null;
            }
        });
        
        clear.setOnAction(clr -> {
            pane.getChildren().clear();
            cur = null;
        });

        bord.setCenter(pane);
        bord.setRight(clear);
        Scene scene = new Scene(bord, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}