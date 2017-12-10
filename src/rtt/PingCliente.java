
package rtt;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;


public class PingCliente {

    
    private static final int MAX_TIMEOUT = 1000;
    private int port;
    private String ip;
    private InetAddress server;
    
    public PingCliente(int port,String ipHost) throws UnknownHostException{
        this.port = port;
        this.server = InetAddress.getByName(ipHost);
    }
    
    public void pingCliente() throws UnknownHostException, SocketException, IOException{
        
        //server = InetAddress.getByName(ipHost);
        //Cria um servidor
        DatagramSocket socket = new DatagramSocket(port);
        int sequence_number =0;
        
            while(sequence_number<10){
                
                Date now = new Date();
                
                long msSend = now.getTime();
                
                String str = "PING "+sequence_number+" "+msSend+" \n";
                
                byte[] buf = new byte[1024];
                buf = str.getBytes();
                
                DatagramPacket ping = new DatagramPacket(buf,buf.length,server,port);
                
                socket.send(ping);
                
                    try{
                        socket.setSoTimeout(MAX_TIMEOUT);
                        DatagramPacket response = new DatagramPacket(new byte[1024],1024);
                        socket.receive(response);
                        now = new Date();
                        long msReceived = now.getTime();
                        printData(response,msReceived-msSend);
                        
                    }catch(IOException e){
                        
                    }
                sequence_number++;
            }
        
            
    }
    
    private static void printData(DatagramPacket request,long delayTime) throws IOException{
            
                byte[] buf = request.getData();
                
                ByteArrayInputStream bais = new ByteArrayInputStream(buf);
                
                InputStreamReader isr = new InputStreamReader(bais);
                
                BufferedReader br = new BufferedReader(isr);
                
                String line = br.readLine();
                
                System.out.println("Received from "+request.getAddress().getHostName()+": "+new String(line)+" Delay: "+delayTime);
            
            }
            
    
    
    
    
    
}
