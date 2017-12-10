
package servidor;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.in;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import rtt.PingServidor;


/**
 *
 * @author jose
 */
public class ServidorTcp implements Runnable {
    private ServerSocket server;
    private Socket connection;
    private File file;
    private FileInputStream in;
    private int porta;
    private String ip;
    private String caminho;
    private long dadosEnviados=0;
    private long tamanhoInicial=0;
    private Socket entradaCod;
    private InetAddress iA;
    private PingServidor ping;
    private DatagramSocket socketRtt;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private long lengthFile;
    
    
    
    public ServidorTcp(int porta,String ip,String caminho){
        this.caminho=caminho;
        this.porta = porta;
        this.ip = ip;
       
    }
    public ServidorTcp(){
        //this.caminho = caminho;
    }
    public InetAddress getIp(){
        return this.iA;
    }
    
    public Socket getConnection(){
        return this.connection;
    }
    public long getDadosEnviados(){
        return dadosEnviados;
    }
    public long getTamanhoInicial(){
        return tamanhoInicial;
    }
    
    private void waitForConnection() throws IOException {
        System.out.println("escutando...");
        connection = server.accept();
        System.out.println(connection.getInetAddress().getHostAddress());
    }
    private void createConnection() throws IOException{
        server = new ServerSocket(porta,100);
       // socketRtt = new DatagramSocket(5050);
        //iA = InetAddress.getByName(ip);
        
    }
    public void getStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();  
        input = new ObjectInputStream(connection.getInputStream());
       
    }
    public void closeGetStreams() throws IOException{
        output.close();
        input.close();
    }
    public void toStringServidor(){
        System.out.println("Ip do cliente:"+connection.getInetAddress().getHostName()+""
        +"Tamanho do Arquivo:"+lengthFile);
    }
    
    public void sendLengthFile() throws IOException{
       // output.writeUTF("12345678910");
        output.flush();
        
    }
    
    public void tempoTermino(){
        //Quando nanosecondos envia um bit
        //multiplica pelo tamanho do pacote total
        //ao fim diminui um nanosecondo para o total final
    }
    public void sendArquivo() throws FileNotFoundException, IOException{
       /**
        * Envio de Arquivo
        */
        
        file = new File(caminho);
        in = new FileInputStream(file);
        OutputStream outputStream =  connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        BufferedWriter writer = new BufferedWriter(osw);
        writer.flush();
        lengthFile = in.available();
        System.out.println("tamanho do arquivo "+lengthFile);
        
        
        output = new ObjectOutputStream(connection.getOutputStream());
        output.writeLong(lengthFile);
        output.flush();
        
        input = new ObjectInputStream(connection.getInputStream());
        
        
        
        int controle;
        int tamanho = 1024;
        int somatorio=0;
        byte[] buffer = new byte[tamanho];
        double porcentagem;
        long tempoInicio, tempoFinal, tempoInicioMil,tempoFinalMil,miliSegundos,miliSegundosFin,estimative;
        estimative = 43646076;
        
          while((controle = in.read(buffer,0,tamanho))!=-1){
                  // tempoInicioMil = System.nanoTime();
                   tempoInicio = System.nanoTime();
                   
                   outputStream.write(buffer,0,controle);
                  // tempoFinalMil = System.nanoTime();
                   miliSegundos = ((lengthFile*estimative)/tamanho);
                  // System.out.println("Tempo para um pacote "+(tempoFinalMil-tempoInicioMil));
                   input.readInt();
                   
                   tempoFinal = System.nanoTime();
                   somatorio+=controle;
                   miliSegundosFin = (estimative);
                   
                   porcentagem = (somatorio*100)/lengthFile;
                   System.out.println("IP do cliente: "+connection.getInetAddress()+
                           
                           " Status de Transferencia: "+porcentagem+"%"+" RTT: "+(tempoFinal-tempoInicio)+
                           
                           " Tempo Estimado para Finalizar: "+(miliSegundos-miliSegundosFin));
          }
         
          System.out.println("ARQUIVO ENVIADO: "+somatorio);
         
    }
    /*
    public void rtt() throws IOException{
        int cont=0;
        InetAddress host = InetAddress.getByName(ip);
        while(cont<=in.available()){
            //socketRtt = new DatagramSocket(5050);
            long tempIni = System.nanoTime();
            String str = "";
            
            byte[] buff = new byte[1024];
            
            buff = str.getBytes();
            
            DatagramPacket ping = new DatagramPacket(buff,buff.length,host,3000);
            socketRtt.send(ping);
            
            DatagramPacket response = new DatagramPacket(new byte[1024],1024);
            
            socketRtt.receive(response);
            
            long tempFin = System.nanoTime();
            
            printData(response,tempFin-tempIni);
            
        
        }
    
    }
    public static void printData(DatagramPacket request,long rtt){
        
        byte[] buff = request.getData();
        ByteArrayInputStream bais = new ByteArrayInputStream(buff);
                
        InputStreamReader isr = new InputStreamReader(bais);
                
        BufferedReader br = new BufferedReader(isr);
        
        System.out.println("Received from "+request.getAddress().getHostName()+":"+" RTT: "+rtt);
    
    }*/
    @Override
        public void run(){
                
            try{
                createConnection();
                waitForConnection();
               // getStreams();
               // sendLengthFile();
                //closeGetStreams();
                sendArquivo();
               // rtt();
                }catch(IOException e){
                e.printStackTrace();
            }
    }
        
    private void processConnection() throws IOException {
    
}
    private void closeConnection() throws IOException{
          server.close();
          connection.close();
    }

    
}
