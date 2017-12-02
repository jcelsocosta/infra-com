/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jose
 */
public class ServidorTcp {
    private ServerSocket server;
    private Socket connection;
    
    public void runServidor() throws IOException{
        try{
            server = new ServerSocket(12345,100);
            
            while(true){
                try{
                    waitForConnection();
                    processConnection();
                }catch(EOFException eofException){
                    
                }finally{
                    closeConnection();
                }
            }
        }catch(EOFException ioException){
            ioException.printStackTrace();
        }
    
    }

    private void waitForConnection() throws IOException {
        System.out.println("escutando...");
        connection = server.accept();
    }

    private void processConnection() throws IOException {
        
    }

    private void closeConnection() throws IOException{
       
    }
}
