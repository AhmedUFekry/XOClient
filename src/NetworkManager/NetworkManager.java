/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetworkManager;

import ClientServer.Client;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author DELL
 */
public class NetworkManager {
    private static Client client;
    private static InetAddress ipServer;
    // Private constructor to prevent instantiation
    private NetworkManager() {}
    public static void setIpServer(String host){
         try {
            NetworkManager.ipServer = InetAddress.getByName(host);
            System.out.println("valid host " + host);
        } catch (UnknownHostException e) {
            // Handle the case where the host is invalid
            System.out.println("Error: Invalid host " + host);
            e.printStackTrace();
        }

    }
    public static Client getClient() {
        if (client == null || !client.isAlive()) {
            if (ipServer == null) {
                throw new IllegalStateException("Server IP address not set. Call setServerIP() before getClient().");
            }
            client = new Client(ipServer);
            client.start();
        }
        return client;
    }
}
