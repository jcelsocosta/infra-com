
package projeto.infracom;

import cliente.ClienteTcp;
import comunicacao.ControlServidor;
import java.io.IOException;
import servidor.ServidorTcp;

public class Main2 {

   
    public static void main(String[] args) throws IOException {
       
        ServidorTcp servidor = new ServidorTcp(2017,"","C:\\Users\\jose\\Desktop\\eirck nautico\\bq.mp3");
        new Thread(servidor).start();
         ClienteTcp cliente = new ClienteTcp("127.0.0.1",2017);
        //cliente.runClient();
        new Thread(cliente).start();
    }
    
}
