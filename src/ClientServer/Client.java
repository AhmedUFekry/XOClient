/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import ExtraComponent.ExtraComponent;
import GameScreen.GameScreenController;
import LoginScreen.LoginScreenController;
import StartScreen.StartScreenController;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import xoclient.Navigate;

public class Client extends Thread {

    private DataInputStream ears;
    private Socket skt;
    private PrintStream ps;
    private String sendDataToServer;
    private String recieveDatafromServer;
    private CompletableFuture<String> callback;
    private InetAddress ipServer;
    private volatile boolean isRunning = true; // Flag to control the client thread

    public void setSendDataToServer(String send) {
        this.sendDataToServer = send;
    }

    public String getDataFromServer() {
        return recieveDatafromServer;
    }

    public DataInputStream getEars() {
        return ears;
    }

    public void run() {
        try {
            if (ipServer != null) {
                this.skt = new Socket(ipServer, 5050);
                System.out.println("ClientServer.Client.run()");
                this.ears = new DataInputStream(this.skt.getInputStream());
                this.ps = new PrintStream(this.skt.getOutputStream());

                Thread thread = new Thread(() -> {
                    while (isRunning) {
                        synchronized (this) {
                            if (sendDataToServer != null) {
                                ps.println(sendDataToServer);
                            }
                            sendDataToServer = null;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.setDaemon(true);
                thread.start();
                System.out.println("sendDataToserver " + sendDataToServer);
                while (isRunning) {
                    recieveDatafromServer = ears.readLine();
                    if (recieveDatafromServer != null) {
                        System.out.println("recieveDatafromServer " + recieveDatafromServer);
                        if (recieveDatafromServer.equals("Server is closing")) {
                            System.out.println("server closed");
                            // notifyCallback(recieveDatafromServer);
                            stopClient(); // Stop the client when server is closing
                            showServerClosedAlert();
                            break;
                        }
                        if ("client exit".equalsIgnoreCase(recieveDatafromServer)) {
                            notifyCallback(recieveDatafromServer);
                            stopClient();
                            break;
                        }
                        if (recieveDatafromServer.equals("user invited")) {
                            System.out.println("Cuser invited ");
                            notifyCallback(recieveDatafromServer);
                            Platform.runLater(() -> {
                                Alert alert = ExtraComponent.showAlert(
                                        Alert.AlertType.CONFIRMATION,
                                        "Request",
                                        "You have been invited to a game."
                                );

                                ButtonType acceptButton = new ButtonType("Accept", ButtonBar.ButtonData.OK_DONE);
                                ButtonType rejectButton = new ButtonType("Reject", ButtonBar.ButtonData.CANCEL_CLOSE);

                                alert.getButtonTypes().setAll(acceptButton, rejectButton);
                                Optional<ButtonType> resultButton = alert.showAndWait();
                                                                
                                if (resultButton.isPresent()) {
                                    if (resultButton.get() == acceptButton) {
                                        this.setSendDataToServer("start the game");
                                        
                                        
                                        System.out.println("User clicked Accept");
                                    } else if (resultButton.get() == rejectButton) {
                                        this.setSendDataToServer("rejected the game");
                                        System.out.println("User clicked Reject");
                                    }
                                } else {
                                    System.out.println("User closed the alert without clicking a button");
                                }
                            });

                            //  break;
                        }
                        // Notify the callback with the received data
                        notifyCallback(recieveDatafromServer);
                        System.out.println("after notify call back");
                    }else{
                       //System.out.println("recieved data null");
                       
                    }
                }
            } else {
                System.out.println("Error: InetAddress is null. Please set a valid host using setIpServer.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            notifyCallback("Error: Unknown Host Exception - Enter the correct IP.");
        } catch (ConnectException ex) {
            notifyCallback("Error: Connection refused: The server may not be running or is unreachable.");
        } catch (SocketException es) {
            notifyCallback("Error: Network is unreachable: connect");
        } catch (IOException ex) {
            ex.printStackTrace();
            notifyCallback("Error: " + ex.getMessage());
        } finally {
            closeResources();
        }
    }
// Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "Unknown Host Exception: Enter the correct IP."); alert.show();

    public Client(InetAddress ipServer) {
        this.ipServer = ipServer;
    }

    public void setCallback(CompletableFuture<String> callback) {
        this.callback = callback;
    }

    // get the answer from the server and notify the result and call setCallback to take action
    private void notifyCallback(String result) {
        if (callback != null) {
            //if excepion throws catch it and send it to the caller
            if (result.startsWith("Error:")) {
                // If the result starts with "Error:", it indicates an exception occurred
                callback.completeExceptionally(new RuntimeException(result));
            } else {
                callback.complete(result);
            }
        }
    }

    public void setEars(DataInputStream ears) {
        this.ears = ears;
    }

    public Socket getSkt() {
        return skt;
    }

    public void setSkt(Socket skt) {
        this.skt = skt;
    }

    public PrintStream getPs() {
        return ps;
    }

    public void setPs(PrintStream ps) {
        this.ps = ps;
    }

    private void closeResources() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (ears != null) {
                ears.close();
            }
            if (skt != null && !skt.isClosed()) {
                skt.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopClient() {
        isRunning = false; // Set the flag to stop the client
        closeResources();
    }

    private void showServerClosedAlert() {
        Platform.runLater(() -> {
            Alert alert = ExtraComponent.showAlert(
                    Alert.AlertType.ERROR,
                    "Error",
                    "The server is closing. Please try again later.");
            alert.showAndWait();
            // Get the controller for the StartScreen
            //navigate here
        }
        );
    }
    
  /*  public void goToOnlineGameScreen(){
        try {
            Stage primaryStage = new Stage();
            GameScreenController controller = new GameScreenController(1);
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
            loader.setController(controller);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

            // Close the current stage (ListPlayer stage)
            ((Stage) goToGameButton.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    

}
