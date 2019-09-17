/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychatapp.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mychatapp.gui.MainScreen;

/**
 *
 * @author shahriardhruvo
 */
public class MessageTransmitter extends Thread {
    
    String message, hostName, userName;
    int port;
    
    public MessageTransmitter(String message, String hostName, String userName, int port){
        this.message = message;
        this.hostName = hostName;
        this.userName = userName + ": ";
        this.port = port;
    }
    
    public MessageTransmitter(){
        
    }
    
    @Override
    public void run(){
        try {
            Socket s = new Socket(hostName, port);
            s.getOutputStream().write(userName.getBytes());
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
