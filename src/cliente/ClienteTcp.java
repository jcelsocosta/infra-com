
package cliente;

import java.io.EOFException;
import java.io.IOException;
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

    private void processConnection() {
        String ipServidor = (String) cliente.getInetAddress().getHostName();
        System.out.println(ipServidor);
    }

    private void closeConnection() {
        
            try{
                cliente.close();
            }catch(IOException ioException){
                ioException.printStackTrace();
            
            }
    }
}
