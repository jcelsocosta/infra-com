/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        
        InputStream in = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        File file = new File("C:\\Users\\jose\\Desktop\\infracomMini\\"+reader.readLine());
        FileOutputStream out = new FileOutputStream(file);
        int tamanho = 1024;
        byte[] buffer = new byte[tamanho];
        
        System.out.println("Tamanho"+in.read());
        int controle;
        while((controle = in.read(buffer,0,tamanho))!=-1){
            System.out.println(file.getUsableSpace());
            out.write(buffer,0,controle);
        }
        
    }

    private void closeConnection() throws IOException{
       
    }
}
