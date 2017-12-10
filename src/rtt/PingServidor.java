
package rtt;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class PingServidor {
    
    private int port;
    private DatagramSocket socket;
   
    
    
    
    public PingServidor(int port){
        this.port = port;
    
    }
        public void pingServer() throws SocketException, IOException{
            //cria um servidor
            socket = new DatagramSocket(port);
                while(true){
                    
                    DatagramPacket request = new DatagramPacket(new byte[1024],1024);
                    socket.receive(request);
                    
                    printData(request);
                    
                    InetAddress clientHost = request.getAddress();
                    int clientPort = request.getPort();
                    byte[] buf = request.getData();
                    DatagramPacket reply = new DatagramPacket(buf, buf.length, clientHost, clientPort);
                    socket.send(reply);

                    System.out.println("   Reply sent.");
                }
            
        }
        
        private static void printData(DatagramPacket request) throws IOException{
        
            byte[] buf = request.getData();
            
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            
            InputStreamReader isr = new InputStreamReader(bais);
            
            BufferedReader br = new BufferedReader(isr);
            
            String line = br.readLine();
            
            System.out.println(
         "Received from " +
         request.getAddress().getHostAddress() +
         ": " +
         new String(line) );
        }
    
}
