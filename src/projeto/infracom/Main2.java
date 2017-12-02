
package projeto.infracom;

import cliente.ClienteTcp;

public class Main2 {

   
    public static void main(String[] args) {
        
        ClienteTcp cliente = new ClienteTcp("127.0.0.1");
        cliente.runClient();
    }
    
}
