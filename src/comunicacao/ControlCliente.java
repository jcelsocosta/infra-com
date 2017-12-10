//Criando um servidor
package comunicacao;

import com.sun.corba.se.spi.activation.Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ControlCliente implements Runnable{

    private ServerSocket server;
    private Socket connection;
    private File file;
    private String ip;
    private int porta;
    private DataInputStream entrada;
    private DataOutputStream saida;
    private ControlCliente cl;
    
    
    public ControlCliente(int porta) throws IOException{
            this.porta = porta;
           
    }

    public void entradaSaida() throws IOException{
        entrada = new DataInputStream(connection.getInputStream());
        saida = new DataOutputStream(connection.getOutputStream());
    }
    public void createConnectionCliente() throws IOException{
        server = new ServerSocket(porta,100);
        
    }
    public void waitConnectionCliente() throws IOException{
        connection = server.accept();
    }   
    public String receivedString() throws IOException{
        return entrada.readUTF();
    } 
    public void send(String s) throws IOException{
        saida.writeUTF(s);
    }
    @Override
    public void run() {
        
        System.out.println("Cliente Controle Aberto");
        try{
                createConnectionCliente();
                waitConnectionCliente();
                entradaSaida();
                ControlCliente controlCliente = new ControlCliente(this.porta);
                while(true){
                    System.out.println("oi");
                    System.out.println("Mensagem recebida: "+receivedString());
                }
        }catch(IOException e){
        }
    }
    
}
