
package projeto.infracom;

import cliente.ClienteTcp;
import java.io.IOException;
import servidor.ServidorTcp;


public class Main {

    public static void main(String[] args) throws IOException {
        
        ServidorTcp servidor = new ServidorTcp();
        servidor.runServidor();
        //ClienteTcp cliente = new ClienteTcp("127.0.0.1");
       // cliente.runClient();
    }

    
}
