/** ************
 * Ruben Bautista
 * CS 56 (Java)
 * Bank Project
 * November 29, 2021
 ************** */
package bankfx;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class BankServer extends Application {

    private TextArea ta = new TextArea();

    private int clientNo = 0;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("BankServer");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("BankServer started at "
                        + new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept();

                    clientNo++;

                    Platform.runLater(() -> {
                        ta.appendText("Starting thread for client " + clientNo
                                + " at " + new Date() + '\n');

                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "'s host name is "
                                + inetAddress.getHostName() + "\n");
                        ta.appendText("Client " + clientNo + "'s IP Address is "
                                + inetAddress.getHostAddress() + "\n");
                    });

                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {

        private Socket socket;
        private double getMoney;
        private double total;
        private int getAccNum;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                while (true) {
                    int accNum = inputFromClient.readInt();
                    double money = inputFromClient.readDouble();
                    int bool = inputFromClient.readInt();

                    getAccNum = accNum;
                    getMoney = money;
                    if (bool == 1) {
                        total -= money;
                        if (total < 0) {
                            total += money;
                            int checker = 1;
                            ta.appendText("Insufficient Funds. \n");
                            outputToClient.writeInt(checker);
                            outputToClient.writeInt(getAccNum);
                            outputToClient.writeDouble(getMoney);
                            outputToClient.writeDouble(total);
                        } else {
                            int checker = 0;
                            outputToClient.writeInt(checker);
                            outputToClient.writeInt(getAccNum);
                            outputToClient.writeDouble(getMoney);
                            outputToClient.writeDouble(total);

                            Platform.runLater(() -> {
                                ta.appendText("Client: Account Number is "
                                        + getAccNum + '\n');
                                ta.appendText("Balance: " + total + '\n');
                            });
                        }
                    } else {
                        total += money;
                        outputToClient.writeInt(getAccNum);
                        outputToClient.writeDouble(getMoney);
                        outputToClient.writeDouble(total);

                        Platform.runLater(() -> {
                            ta.appendText("Client: Account Number is "
                                    + getAccNum + '\n');
                            ta.appendText("Balance: " + total + '\n');
                        });
                    }
                }
            } catch (IOException ex) {
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
