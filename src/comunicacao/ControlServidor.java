
package comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class ControlServidor implements Runnable {

    private Socket socket;
    private DataOutputStream saida;
    private DataInputStream entrada;
    
    
    public ControlServidor(String address,int porta) throws IOException{
        socket = new Socket(address,porta);
        saida = new DataOutputStream(socket.getOutputStream());
        entrada = new DataInputStream(socket.getInputStream());
    }
    
    public String receivedString() throws IOException{
        return entrada.readUTF();
    }
    public void send(String s) throws IOException{
        saida.writeUTF(s);
    }
    
    @Override
    public void run() {
        System.out.println("Controle Servidor Aberto ");
        Scanner in = new Scanner(System.in);
            try{
                ControlServidor controlServidor = new ControlServidor("localhost",2017);
                
                    while(true){
                        
                        controlServidor.send(in.nextLine());
                    }
            }catch(IOException e){
            }
        
    }
    
    
    
}
