/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author jose
 */
public class ServidorTcp implements Runnable {
    private ServerSocket server;
    private Socket connection;
    private File file;
    private File file2;
    private int porta;
    private String ip;
    private String caminho;
            
    public ServidorTcp(int porta,String ip,String caminho){
        this.porta =porta;
        this.ip = ip;
        this.caminho = caminho;
    }
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
    
    @Override
        public void run(){
            
            try{
                server = new ServerSocket(porta,100);
                waitForConnection();
                file = new File(caminho);
                FileInputStream in = new FileInputStream(file);
                OutputStream  outputStream = connection.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(outputStream);
                BufferedWriter writer = new BufferedWriter(osw);
                writer.write(file.getName()+"\n");
                writer.flush();

                System.out.println("Tamanho: "+in.available());
                int controle ;
                int tamanho =1024;
                byte[] buffer = new byte[tamanho];
                while((controle = in.read(buffer,0,tamanho))!= -1){

                     outputStream.write(buffer,0,controle);
                    }
                }catch(IOException e){
                e.printStackTrace();
            }
    }
    private void processConnection() throws IOException {
    /*
        public void run(){
        file = new File("C:\\Users\\jose\\Desktop\\eirck nautico\\Warcraft III.rar");
        FileInputStream in = new FileInputStream(file);
        OutputStream  outputStream = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        BufferedWriter writer = new BufferedWriter(osw);
        writer.write(file.getName()+"\n");
        writer.flush();
        
        System.out.println("Tamanho: "+in.available());
        int controle ;
        int tamanho =1024;
        byte[] buffer = new byte[tamanho];
        while((controle = in.read(buffer,0,tamanho))!= -1){
             
             outputStream.write(buffer,0,controle);
        }
        
        
    }*/
}
    private void closeConnection() throws IOException{
       
    }
    
}
