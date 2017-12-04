
package cliente;

import arquivo.TransferFile;
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
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTcp implements Runnable{
    
    private Socket cliente;
    private String addressIp;
    private File file;
    private int porta;
    public ClienteTcp(String host,int porta){
        
        this.addressIp = host;
        this.porta = porta;
    }
            
    public void runClient(){
            try{
                connectToServer();
                processConnection();
            }catch(EOFException eofException){
                
            }catch(IOException ioException){
                ioException.printStackTrace();
            }finally{
                closeConnection();
            }
    }

    private void connectToServer() throws IOException {
        
        cliente = new Socket(InetAddress.getByName(addressIp).getHostName(),porta);
        
    }
    @Override
    public void run(){
        
        try{
            cliente = new Socket(InetAddress.getByName(addressIp).getHostName(),porta);
            String ipServidor = (String) cliente.getInetAddress().getHostName();
            System.out.println(ipServidor);
        
            InputStream in = cliente.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);
            File file = new File("C:\\Users\\jose\\Desktop\\infracomMini\\"+reader.readLine());
            FileOutputStream out = new FileOutputStream(file);
            int tamanho = 1024;
            byte[] buffer = new byte[tamanho];

            System.out.println("Tamanho"+in.read());
            int controle;
            while((controle = in.read(buffer,0,tamanho))!=-1){
                //System.out.println(file.getUsableSpace());
                out.write(buffer,0,controle);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    private void processConnection() throws IOException {
        
        
        String ipServidor = (String) cliente.getInetAddress().getHostName();
        System.out.println(ipServidor);
        
        InputStream in = cliente.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        File file = new File("C:\\Users\\jose\\Desktop\\infracomMini\\"+reader.readLine());
        FileOutputStream out = new FileOutputStream(file);
        int tamanho = 1024;
        byte[] buffer = new byte[tamanho];
        
        System.out.println("Tamanho"+in.read());
        int controle;
        while((controle = in.read(buffer,0,tamanho))!=-1){
            //System.out.println(file.getUsableSpace());
            out.write(buffer,0,controle);
        }
        
       
        
    }

    private void closeConnection() {
        
            try{
                cliente.close();
            }catch(IOException ioException){
                ioException.printStackTrace();
            
            }
    }
}
