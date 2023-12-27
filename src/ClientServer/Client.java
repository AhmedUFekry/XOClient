/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {

   private DataInputStream ears;
    private Socket skt;
    private PrintStream ps;
    private String sendDataToServer;
    private String recieveDatafromServer;
    private CompletableFuture<String> callback;
    private InetAddress ipServer;

    public Client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    public void setSendDataToServer(String send){
        this.sendDataToServer = send;
    }
    public String getDataFromServer(){
        return recieveDatafromServer;
    }

    public DataInputStream getEars() {
        return ears;
    }

    public void run(){
        try {
            if (ipServer != null) {
                this.skt = new Socket(ipServer, 5050);
                System.out.println("ClientServer.Client.run()");
                this.ears = new DataInputStream(this.skt.getInputStream());
                this.ps = new PrintStream(this.skt.getOutputStream());
                ps.println(sendDataToServer);
                System.out.println("sendDataToserver "+sendDataToServer);
                recieveDatafromServer = ears.readLine();
                System.out.println("recieveDatafromServer "+recieveDatafromServer);
                // Notify the callback with the received data
                notifyCallback(recieveDatafromServer);
          } else {
               System.out.println("Error: InetAddress is null. Please set a valid host using setIpServer.");
          }
        } catch(UnknownHostException e){
             e.printStackTrace();
           notifyCallback("Error: Unknown Host Exception - Enter the correct IP.");
        } catch(ConnectException ex){
            notifyCallback("Error: Connection refused: The server may not be running or is unreachable.");
        }catch(SocketException es){
            notifyCallback("Error: Network is unreachable: connect");
        }
        catch (IOException ex) {
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
            if(result.startsWith("Error:")){
                // If the result starts with "Error:", it indicates an exception occurred
                callback.completeExceptionally(new RuntimeException(result));
            }else{
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
            if (ps != null) ps.close();
            if (ears != null) ears.close();
            if (skt != null && !skt.isClosed()) skt.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
