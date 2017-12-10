
package cliente;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rtt.PingCliente;


public class ClienteTcp implements Runnable{
    
    private Socket cliente;
    private String addressIp;
    private File file;
    private int porta;
    private boolean flag=false;
    private Socket envioCod;
    private BufferedReader  reader;
    private PingCliente ping;
    private DatagramSocket socket;
    private long lengthFile;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public ClienteTcp(){}
    public ClienteTcp(String host,int porta){
        
        this.addressIp = host;
        this.porta = porta;
    }
    private void connectToServer() throws IOException {
        
        cliente = new Socket(InetAddress.getByName(addressIp).getHostName(),porta);
        System.out.println(InetAddress.getByName(addressIp).getHostName());
        System.out.println("Conectado a porta "+porta);
        
        //socket = new DatagramSocket(5050);
        
        
    }
    public Socket getConnection(){
        return this.cliente;
    }
    public String getIpHost(){
        return this.addressIp;
    }
    
    
    public void toStringCliente() throws UnknownHostException{
        System.out.println("Ip do Servidor:"+InetAddress.getByName(addressIp).getHostName()+""
        +" Tamanho do arquivo:"+lengthFile
        );
    }
    
    public void getStreams() throws IOException{
        output = new ObjectOutputStream(cliente.getOutputStream());
        output.flush();
        
        input = new ObjectInputStream(cliente.getInputStream());
        
        
    }
    
    public void closeGetStreams() throws IOException{
        output.close();
        input.close();
    }
    public void receivedLengthFile() throws IOException, ClassNotFoundException{
        
        String llengthFile = (String) input.readObject();
        System.out.println(llengthFile);
    }
    
    public void receberArquivo() throws IOException, ClassNotFoundException{
    
            
            InputStream in = cliente.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            reader = new BufferedReader(isr);
            File file = new File("C:\\Users\\jose\\Desktop\\infracomMini\\bq.mp3");
            FileOutputStream out = new FileOutputStream(file);
            long tam=0;
            
            input = new ObjectInputStream(cliente.getInputStream());
            tam = (long) input.readLong();
            System.out.println("tamanho do arquivo cliente "+tam);
            //System.out.println("tamanho do arquivo cliente "+lenght);
            
            output = new ObjectOutputStream(cliente.getOutputStream());
            
            int tamanho = 1024;
            byte[] buffer = new byte[tamanho];
            long tempoInicio,tempoFinal,tempoInicioMil,tempoFinalMil,miliSegundos,miliSegundosFin,estimative;
            estimative = 216746;
            int controle;
            int somatorio=0;
            boolean band = false;
            double porcentagem=0;
            
                    System.out.println("Arquivo sendo recebido");
                   
                    while((controle= in.read(buffer,0,tamanho))!=0){
                        
                        tempoInicio = System.nanoTime();
                        out.write(buffer,0,controle);
                        output.writeInt(controle);
                        output.flush();
                        
                        miliSegundos = ((tam*estimative)/tamanho)/1000000;
                        
                        tempoFinal = System.nanoTime();
                        
                        miliSegundosFin = (estimative)/1000000;
                        somatorio+=controle;
                        
                        porcentagem = (somatorio*100)/tam;
                        
                        System.out.println("Ip do Servidor: "+InetAddress.getByName(addressIp).getHostName()+
                                " Status de Transferencia:"+porcentagem+"% "+
                                " RTT: "+(tempoFinal-tempoInicio)+
                                " Tempo Estimado para Finalizar: "+(miliSegundos-miliSegundosFin)
                                );
                    }
                    //rtt();
                    
                }
    /*
    public void rtt() throws IOException{
            
        while(true){
            long timeIni = System.nanoTime();
            DatagramPacket request = new DatagramPacket(new byte[1024],1024);
            socket.receive(request);
            
            
                    
            InetAddress clientHost = request.getAddress();
            int clientPort = request.getPort();
            byte[] buf = request.getData();
            DatagramPacket reply = new DatagramPacket(buf, buf.length, clientHost, clientPort);
            socket.send(reply);
            long timeFin = System.nanoTime();
            
            printData(request,timeFin-timeIni);
        }
    }
    
    public static void printData(DatagramPacket response,long rtt){
            byte[] buf = response.getData();
            
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            
            InputStreamReader isr = new InputStreamReader(bais);
            
            BufferedReader br = new BufferedReader(isr);
            
            //String line = br.readLine();
            
            System.out.println(
         "Received from " +
         response.getAddress().getHostAddress() +
         ": RTT" +rtt );
        }
    */
    
    
    @Override
    public void run(){
         
        try{
                    connectToServer();
                   // getStreams();
                    
                   // receivedLengthFile();
                    receberArquivo();
                    closeConnection();
                    
                    
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteTcp.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    private void processConnection() throws IOException {
   
    }
    public void closeConnection() throws IOException {
        
            try{
                cliente.close();
            }catch(IOException ioException){
                
                ioException.printStackTrace();
            
            }
    }
}
