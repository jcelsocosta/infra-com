
package projeto.infracom;

import cliente.ClienteTcp;

public class Main2 {

   
    public static void main(String[] args) {
        
        ClienteTcp cliente = new ClienteTcp("127.0.0.1",12345);
        //cliente.runClient();
        new Thread(cliente).start();
    }
    
}
