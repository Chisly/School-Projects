package bankfx;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BankClient extends Application {

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) {

        BorderPane account = new BorderPane();
        account.setPadding(new Insets(5, 5, 5, 5));
        account.setStyle("-fx-border-color: green");
        account.setLeft(new Label("Account Number: "));

        BorderPane amount = new BorderPane();
        amount.setPadding(new Insets(5, 5, 5, 5));
        amount.setStyle("-fx-border-color: green");
        amount.setLeft(new Label("Amount $: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        account.setCenter(tf);

        TextField tf2 = new TextField();
        tf2.setAlignment(Pos.BOTTOM_RIGHT);
        amount.setCenter(tf2);

        Button button1 = new Button("Balance");
        Button button2 = new Button("Deposit");
        Button button3 = new Button("Withdraw");
        Button button4 = new Button("Quit");

        GridPane gridPane = new GridPane();
        TextArea ta = new TextArea();
        gridPane.add(account, 0, 0, 4, 4);
        gridPane.add(amount, 0, 4, 4, 4);
        gridPane.add(button1, 0, 8, 1, 1);
        gridPane.add(button2, 1, 8, 1, 1);
        gridPane.add(button3, 2, 8, 1, 1);
        gridPane.add(button4, 3, 8, 1, 1);
        gridPane.add(new ScrollPane(ta), 0, 12, 4, 4);

        Scene scene = new Scene(gridPane, 480, 283);
        primaryStage.setTitle("BankClient");
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setOnAction(e -> {
            try {
                int accNum = Integer.parseInt(tf.getText().trim());
                int bool = 0;

                toServer.writeInt(accNum);
                toServer.flush();
                toServer.writeDouble(0);
                toServer.flush();
                toServer.writeInt(bool);
                toServer.flush();

                int getAccNum = fromServer.readInt();
                double getMoney = fromServer.readDouble();
                double getTotal = fromServer.readDouble();

                ta.appendText("Account Number: "
                        + getAccNum + '\n');
                ta.appendText("Balance: " + getTotal + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });
        button2.setOnAction(e -> {
            try {
                int accNum = Integer.parseInt(tf.getText().trim());
                double money = Double.parseDouble(tf2.getText().trim());
                int bool = 0;

                toServer.writeInt(accNum);
                toServer.flush();
                toServer.writeDouble(money);
                toServer.flush();
                toServer.writeInt(bool);
                toServer.flush();

                int getAccNum = fromServer.readInt();
                double getMoney = fromServer.readDouble();
                double getTotal = fromServer.readDouble();

                ta.appendText("Account Number: "
                        + getAccNum + '\n');
                ta.appendText("Deposited: " + getMoney + '\n');
                ta.appendText("New Balance: " + getTotal + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });
        button3.setOnAction(e -> {
            try {
                int accNum = Integer.parseInt(tf.getText().trim());
                double money = Double.parseDouble(tf2.getText().trim());
                int bool = 1;

                toServer.writeInt(accNum);
                toServer.flush();
                toServer.writeDouble(money);
                toServer.flush();
                toServer.writeInt(bool);
                toServer.flush();

                int check = fromServer.readInt();
                int getAccNum = fromServer.readInt();
                double getMoney = fromServer.readDouble();
                double getTotal = fromServer.readDouble();

                if (check == 1) {
                    ta.appendText("Insufficient Funds.\n");
                } else {
                    ta.appendText("Account Number: "
                            + getAccNum + '\n');
                    ta.appendText("Withdrew: " + getMoney + '\n');
                    ta.appendText("New Balance: " + getTotal + '\n');
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });
        button4.setOnAction(e -> {
            System.exit(0);
        });
        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
