
package gui;

import cliente.ClienteTcp;
import java.io.IOException;
import servidor.ServidorTcp;

/**
 *
 * @author jose
 */
public class InterfaceGui extends javax.swing.JFrame {

    public InterfaceGui() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        portaServidorText = new javax.swing.JTextField();
        ipServidorText = new javax.swing.JTextField();
        CriarServerBtn = new javax.swing.JButton();
        caminhoArquivoText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portaClienteText = new javax.swing.JTextField();
        conectarServerBtn = new javax.swing.JButton();
        ipCliente = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        IniciarBarra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("Servidor");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 36, 120, 14);

        portaServidorText.setText("Porta Servidor");
        portaServidorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portaServidorTextActionPerformed(evt);
            }
        });
        jPanel1.add(portaServidorText);
        portaServidorText.setBounds(10, 61, 163, 20);

        ipServidorText.setText("Ip");
        ipServidorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipServidorTextActionPerformed(evt);
            }
        });
        jPanel1.add(ipServidorText);
        ipServidorText.setBounds(10, 92, 163, 20);

        CriarServerBtn.setText("Criar");
        CriarServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarServerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CriarServerBtn);
        CriarServerBtn.setBounds(14, 167, 120, 23);

        caminhoArquivoText.setText("Caminho do arquivo");
        jPanel1.add(caminhoArquivoText);
        caminhoArquivoText.setBounds(10, 123, 163, 20);

        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(482, 36, 130, 14);

        portaClienteText.setText("Porta Cliente");
        portaClienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portaClienteTextActionPerformed(evt);
            }
        });
        jPanel1.add(portaClienteText);
        portaClienteText.setBounds(466, 61, 189, 20);

        conectarServerBtn.setText("conectar");
        conectarServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarServerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(conectarServerBtn);
        conectarServerBtn.setBounds(466, 161, 170, 23);

        ipCliente.setText("Ip");
        jPanel1.add(ipCliente);
        ipCliente.setBounds(466, 92, 189, 20);

        jProgressBar1.setStringPainted(true);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(10, 225, 531, 30);

        jLabel3.setText("Barra de progresso Servidor");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(14, 208, 330, 14);

        jLabel4.setText("Barra de progresso Cliente");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 273, 330, 14);

        jProgressBar2.setStringPainted(true);
        jPanel1.add(jProgressBar2);
        jProgressBar2.setBounds(10, 293, 531, 43);

        IniciarBarra.setText("Barras");
        IniciarBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarBarraActionPerformed(evt);
            }
        });
        jPanel1.add(IniciarBarra);
        IniciarBarra.setBounds(590, 220, 140, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void portaServidorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portaServidorTextActionPerformed
       
    }//GEN-LAST:event_portaServidorTextActionPerformed

    private void ipServidorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipServidorTextActionPerformed
       
    }//GEN-LAST:event_ipServidorTextActionPerformed

    private void CriarServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarServerBtnActionPerformed
        int portaServidor = Integer.parseInt( portaServidorText.getText());
        String ipServidor = ipServidorText.getText();
        String caminhoArquivo = caminhoArquivoText.getText();
        ServidorTcp servidor = new ServidorTcp(portaServidor,ipServidor,caminhoArquivo);
        new Thread(servidor).start();
        
        
        
    }//GEN-LAST:event_CriarServerBtnActionPerformed

    private void portaClienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portaClienteTextActionPerformed
        
    }//GEN-LAST:event_portaClienteTextActionPerformed

    private void IniciarBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarBarraActionPerformed
        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<=100;i++){
                    try{
                        sleep(100);
                        jProgressBar1.setValue(i);
                        jProgressBar2.setValue(i);
                    }catch(InterruptedException e){
                    
                    }
                }
                
            }
        
        }.start();
    }//GEN-LAST:event_IniciarBarraActionPerformed

    private void conectarServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarServerBtnActionPerformed
        String ip = ipCliente.getText();
        int porta = Integer.parseInt(portaClienteText.getText());
        ClienteTcp clienteTcp = new ClienteTcp(ip,porta);
        new Thread(clienteTcp).start();
        
    }//GEN-LAST:event_conectarServerBtnActionPerformed

    public static void main(String args[]) throws IOException {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGui().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CriarServerBtn;
    private javax.swing.JButton IniciarBarra;
    private javax.swing.JTextField caminhoArquivoText;
    private javax.swing.JButton conectarServerBtn;
    private javax.swing.JTextField ipCliente;
    private javax.swing.JTextField ipServidorText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JTextField portaClienteText;
    private javax.swing.JTextField portaServidorText;
    // End of variables declaration//GEN-END:variables
}
