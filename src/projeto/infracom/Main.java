
package projeto.infracom;

import cliente.ClienteTcp;
import java.io.IOException;
import servidor.ServidorTcp;


public class Main {

    public static void main(String[] args) throws IOException {
        
        ServidorTcp servidor = new ServidorTcp(123,"127.0.0.","");
       // servidor.runServidor();
        new Thread(servidor).start();
       ClienteTcp cliente = new ClienteTcp("127.0.0.1",12345);
       new Thread(cliente).start();
       
    }

    
}
