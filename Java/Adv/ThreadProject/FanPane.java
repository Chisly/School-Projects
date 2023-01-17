package ThreadFx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class FanPane extends Pane {
    public Circle c;
    public Arc[] blades = new Arc[4];
    public double increment = 1;

    Button playPause = new Button("Play/Pause");
    Button reverse = new Button("Reverse");

    HBox hButtons = new HBox(playPause, reverse);
    Timeline fanTimeline;

    Slider mSlider = new Slider();
    HBox scrollPane = new HBox(mSlider);

    FanPane(double radius) {
        double w = radius * 4;
        double h = radius * 2;

        setMinWidth(w);
        setMinHeight(h + radius);
        c = new Circle(w / 2, h / 2 + (radius / 2), radius, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);

        double bladeRadius = radius * 0.9;
        for (int i = 0; i < blades.length; i++) {
            blades[i] = new Arc(
                    c.getCenterX(), c.getCenterY(),
                    bladeRadius, bladeRadius,
                    (i * 90) + 30, 35);
            blades[i].setFill(Color.RED);
            blades[i].setType(ArcType.ROUND);
        }

        getChildren().addAll(c);
        getChildren().addAll(blades);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> spin());

        fanTimeline = new Timeline(keyFrame);
        fanTimeline.setCycleCount(Timeline.INDEFINITE);

        playPause.setOnAction(e -> {
            if (fanTimeline.getStatus() == Animation.Status.RUNNING) {
                fanTimeline.pause();
            } else {
                fanTimeline.play();
            }
        });

        mSlider.setMin(0);
        mSlider.setMax(35);
        mSlider.valueProperty().addListener(e -> {
            final double direction = (fanTimeline.getCurrentRate() >= 0) ? 1 : -1;
            fanTimeline.setRate(mSlider.getValue() * direction);
        });
        
        mSlider.setMinWidth(200);
        scrollPane.setAlignment(Pos.CENTER);
        scrollPane.setPadding(new Insets(5));

        reverse.setOnAction(e -> increment *= -1);
        hButtons.setSpacing(5);
        hButtons.setAlignment(Pos.CENTER);
        hButtons.setPadding(new Insets(2, 2, 2, 2));

    }

    public void spin() {
        for (Arc blade : blades) {
            double prevStartAngle = blade.getStartAngle();
            blade.setStartAngle(prevStartAngle - increment);
        }
    }

    public void stop() {
        fanTimeline.stop();
    }
}
