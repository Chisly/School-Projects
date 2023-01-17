/** ************
 * Ruben Bautista
 * CS 56 (Java)
 * Project Thread
 * November 15, 2021
 ************** */
package ThreadFx;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreadFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BorderPane[] borderPanes = new BorderPane[6];
        FanPane[] fanPanes = new FanPane[6];
        ClockPane[] clockPane = new ClockPane[6];

        
        for (int i = 0; i < borderPanes.length; i++) {
                fanPanes[i] = new FanPane(100);
                borderPanes[i] = new BorderPane(fanPanes[i]);
                borderPanes[i].setTop(fanPanes[i].hButtons);
                borderPanes[i].setBottom(fanPanes[i].scrollPane);
                borderPanes[i].setStyle("-fx-border-color: black;");
        }
        for (int i = 0; i < borderPanes.length; i++) {
                if(i == 0){
                    clockPane[i] = new ClockPane();
                    borderPanes[i] = new BorderPane(clockPane[i]);
                    Text zone = new Text(10, 50, "California, United States");
                    zone.setFont(new Font(20));
                    borderPanes[i].setBottom(zone);
                    borderPanes[i].setTop(clockPane[i].hButtons);
                    borderPanes[i].setStyle("-fx-border-color: black;");
                    clockPane[i].start();
                }if(i == 2){
                    clockPane[i] = new ClockPane("JST");
                    borderPanes[i] = new BorderPane(clockPane[i]);
                    Text zone = new Text(10, 50, "Tokyo, Japan");
                    zone.setFont(new Font(20));
                    borderPanes[i].setBottom(zone);
                    borderPanes[i].setTop(clockPane[i].hButtons);
                    borderPanes[i].setStyle("-fx-border-color: black;");
                    clockPane[i].start();
                }if(i == 4){
                    clockPane[i] = new ClockPane("GMT");
                    borderPanes[i] = new BorderPane(clockPane[i]);
                    Text zone = new Text(10, 50, "England, United Kingdom");
                    zone.setFont(new Font(20));
                    borderPanes[i].setBottom(zone);
                    borderPanes[i].setTop(clockPane[i].hButtons);
                    borderPanes[i].setStyle("-fx-border-color: black;");
                    clockPane[i].start();
                }
        }
        
        HBox hFan = new HBox(borderPanes);
        
        Button btStartAll = new Button("Start All");
        btStartAll.setOnAction(e -> {
            for (FanPane fan : fanPanes) {
                if (fan.fanTimeline.getStatus() != Animation.Status.RUNNING) {
                    fan.playPause.fire();
                }
            }
        });
        Button btStopAll = new Button("Stop All");
        btStopAll.setOnAction(e -> {
            for (FanPane fan : fanPanes) {
                if (fan.fanTimeline.getStatus() == Animation.Status.RUNNING) {
                    fan.stop();
                }
            }
        });
        HBox bottomPane = new HBox(btStartAll, btStopAll);
        bottomPane.setSpacing(10);
        bottomPane.setPadding(new Insets(10, 10, 10, 10));
        bottomPane.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(new BorderPane(hFan, null, null, bottomPane, null), 1960, 500));
        primaryStage.setTitle("Thread");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
