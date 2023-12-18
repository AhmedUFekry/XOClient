/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {

    private DataInputStream ears;
    private Socket skt;
    private PrintStream ps;
    // private String in;
    private String out;

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public DataInputStream getEars() {
        return ears;
    }

    public void run(){
        try {
           
            this.skt = new Socket("192.168.137.1", 5048);
            this.ears = new DataInputStream(this.skt.getInputStream());
            this.ps = new PrintStream(this.skt.getOutputStream());
            ps.println("Test >>>>>>>>");
            String result = ears.readLine();
            System.out.println(result);
        } catch (IOException ex) {
        
            try {
                ps.close();
                ears.close();
                skt.close();
            } catch (IOException ex1) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }
    }

    public Client() {
     this.run();
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
}
