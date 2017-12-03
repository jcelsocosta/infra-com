
package cliente;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTcp {
    
    private Socket cliente;
    private String addressIp;
    
    public ClienteTcp(String host){
        
        this.addressIp = host;
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
        
        cliente = new Socket(InetAddress.getByName(addressIp).getHostName(),12345);
    }

    private void processConnection() throws IOException {
        String ipServidor = (String) cliente.getInetAddress().getHostName();
        System.out.println(ipServidor);
        
        
        File file = new File("C:\\Users\\jose\\Desktop\\eirck nautico\\Warcraft III.rar");
        FileInputStream in = new FileInputStream(file);
        OutputStream  outputStream = cliente.getOutputStream();
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
        
    }

    private void closeConnection() {
        
            try{
                cliente.close();
            }catch(IOException ioException){
                ioException.printStackTrace();
            
            }
    }
}
