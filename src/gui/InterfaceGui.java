
package gui;

import cliente.ClienteTcp;
import comunicacao.ControlCliente;
import comunicacao.ControlServidor;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import servidor.ServidorTcp;

/**
 *
 * @author jose
 */
public class InterfaceGui extends javax.swing.JFrame {

    private ClienteTcp clienteTcp;
    private ServidorTcp servidor;
    
    public InterfaceGui() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        portaServidorText = new javax.swing.JTextField();
        CriarServerBtn = new javax.swing.JButton();
        caminhoArquivoText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portaClienteText = new javax.swing.JTextField();
        conectarServerBtn = new javax.swing.JButton();
        ipCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pauseBtn = new javax.swing.JButton();
        reiniciarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        ipHostCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Servidor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        portaServidorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portaServidorTextActionPerformed(evt);
            }
        });
        jPanel1.add(portaServidorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 163, -1));

        CriarServerBtn.setText("Criar");
        CriarServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarServerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CriarServerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));
        jPanel1.add(caminhoArquivoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 163, -1));

        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 130, -1));

        portaClienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portaClienteTextActionPerformed(evt);
            }
        });
        jPanel1.add(portaClienteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 189, -1));

        conectarServerBtn.setText("iniciar");
        conectarServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarServerBtnActionPerformed(evt);
            }
        });
        jPanel1.add(conectarServerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 130, -1));

        ipCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipClienteActionPerformed(evt);
            }
        });
        jPanel1.add(ipCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 189, -1));

        jLabel5.setText("Porta do Servidor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel7.setText("Caminho do Arquivo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel8.setText("Porta Cliente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        jLabel9.setText("Ip");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 80, -1));

        pauseBtn.setText("pause");
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });
        jPanel1.add(pauseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 150, -1));

        reiniciarBtn.setText("reiniciar");
        reiniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(reiniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 130, -1));

        cancelarBtn.setText("cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 150, -1));
        jPanel1.add(ipHostCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 150, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void portaServidorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portaServidorTextActionPerformed
       
    }//GEN-LAST:event_portaServidorTextActionPerformed

    private void CriarServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarServerBtnActionPerformed
        int portaServidor = Integer.parseInt( portaServidorText.getText());
        String ipServidor="ee";
        String caminhoArquivo = caminhoArquivoText.getText();
        servidor = new ServidorTcp(portaServidor,ipServidor,caminhoArquivo);
        new Thread(servidor).start();
         
        
        
    }//GEN-LAST:event_CriarServerBtnActionPerformed

    private void portaClienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portaClienteTextActionPerformed
        
    }//GEN-LAST:event_portaClienteTextActionPerformed

    private void conectarServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarServerBtnActionPerformed
        String ip = ipCliente.getText();
        int porta = Integer.parseInt(portaClienteText.getText());
        clienteTcp = new ClienteTcp(ip,porta);
        ipHostCliente.setText(ip);
        new Thread(clienteTcp).start();
        
        
    }//GEN-LAST:event_conectarServerBtnActionPerformed

    private void ipClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipClienteActionPerformed
        
    }//GEN-LAST:event_ipClienteActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        
        
    }//GEN-LAST:event_pauseBtnActionPerformed

    private void reiniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarBtnActionPerformed
        
    }//GEN-LAST:event_reiniciarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        
    }//GEN-LAST:event_cancelarBtnActionPerformed

    public static void main(String args[]) throws IOException {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGui().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CriarServerBtn;
    private javax.swing.JTextField caminhoArquivoText;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton conectarServerBtn;
    private javax.swing.JTextField ipCliente;
    private javax.swing.JLabel ipHostCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JTextField portaClienteText;
    private javax.swing.JTextField portaServidorText;
    private javax.swing.JButton reiniciarBtn;
    // End of variables declaration//GEN-END:variables
}
