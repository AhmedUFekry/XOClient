/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
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
        } catch (IOException ex) {
            ex.printStackTrace();
           notifyCallback("Error: " + ex.getMessage());
        } finally {
            closeResources();
        }
    }

    public Client(InetAddress ipServer) {
        this.ipServer = ipServer;
    }
    
    public void setCallback(CompletableFuture<String> callback) {
        this.callback = callback;
    }
    // get the answer from the server and notify the result and call setCallback to take action
    private void notifyCallback(String result) {
        if (callback != null) {
            callback.complete(result);
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
            if (skt != null) skt.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
