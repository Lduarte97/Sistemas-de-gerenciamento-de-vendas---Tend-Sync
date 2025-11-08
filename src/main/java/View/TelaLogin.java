
package View;

import Controller.LoginController;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.Usuario;
import util.MensagensDialogo;

/**
 *
 * @author Lucas Duarte
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        //Chamada dos métodos ao carregar a  tela
        ocultarsenha.setIcon(new ImageIcon(getClass().getResource("/img/ocultar.png")));
        iconeTela();
        carregarDadosSalvos();
    }
    //Método para mudar o ícone da tela
    private void iconeTela(){
        try {
            Image iconeTitulo = ImageIO.read(getClass().getResource("/img/icone.png"));
            this.setIconImage(iconeTitulo);
          
        }catch(IOException ex){
            System.out.println("Erro ao importar icone: " + ex.getMessage());
        }
    }// fim do coneTela()
    
    //método para guardar os dados do usuário que está logando
    private void carregarDadosSalvos() {
        //variável criada para chamar a classe mantenhaConectado
        String[] dadosSalvos = MantenhaConectado.carregarLogin();
        if (dadosSalvos != null) {
            //campos de usuário e senha que serão salvos
            campo_usuario.setText(dadosSalvos[0]);
            campo_senha.setText(dadosSalvos[1]);
            // checkbox que se caso selecionado(true) os dados serão salvos
            mantenhaConc.setSelected(true);
        }//fim do if
        
    }// fim do método carregarDadosSalvos()
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_senha = new javax.swing.JLabel();
        campo_usuario = new javax.swing.JTextField();
        label_usuario = new javax.swing.JLabel();
        botao_login = new javax.swing.JButton();
        ocultarsenha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campo_senha = new javax.swing.JPasswordField();
        mantenhaConc = new javax.swing.JCheckBox();
        labelrodape = new javax.swing.JLabel();
        labelLink = new javax.swing.JLabel();
        labelRotulo1 = new javax.swing.JLabel();
        imagem_de_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 478));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(920, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_senha.setBackground(new java.awt.Color(255, 255, 255));
        label_senha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_senha.setForeground(new java.awt.Color(0, 0, 0));
        label_senha.setText("SENHA:");
        jPanel1.add(label_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 70, 20));

        campo_usuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campo_usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_usuarioActionPerformed(evt);
            }
        });
        jPanel1.add(campo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 320, 39));

        label_usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_usuario.setForeground(new java.awt.Color(0, 0, 0));
        label_usuario.setText("USUÁRIO:");
        jPanel1.add(label_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 90, -1));

        botao_login.setBackground(new java.awt.Color(51, 51, 255));
        botao_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botao_login.setForeground(new java.awt.Color(255, 255, 255));
        botao_login.setText("Login");
        botao_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botao_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_loginActionPerformed(evt);
            }
        });
        jPanel1.add(botao_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 140, 40));

        ocultarsenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ocultar.png"))); // NOI18N
        ocultarsenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        ocultarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarsenhaActionPerformed(evt);
            }
        });
        jPanel1.add(ocultarsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 150, 130));

        campo_senha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campo_senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_senhaActionPerformed(evt);
            }
        });
        jPanel1.add(campo_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 270, 40));

        mantenhaConc.setBackground(new java.awt.Color(255, 255, 255));
        mantenhaConc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mantenhaConc.setForeground(new java.awt.Color(0, 0, 0));
        mantenhaConc.setText("Mantenha-me conectado");
        jPanel1.add(mantenhaConc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        labelrodape.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelrodape.setForeground(new java.awt.Color(0, 0, 0));
        labelrodape.setText("© 2025 Tend Sync. Todos os direitos reservados. Desenvolvido por Lucas Duarte.");
        jPanel1.add(labelrodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, -1, -1));

        labelLink.setBackground(new java.awt.Color(255, 255, 255));
        labelLink.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLink.setForeground(new java.awt.Color(51, 0, 255));
        labelLink.setText("Clique aqui para se cadastrar.");
        labelLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLinkMouseClicked(evt);
            }
        });
        jPanel1.add(labelLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 210, -1));

        labelRotulo1.setBackground(new java.awt.Color(255, 255, 255));
        labelRotulo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelRotulo1.setForeground(new java.awt.Color(0, 0, 0));
        labelRotulo1.setText("Não tem conta? ");
        jPanel1.add(labelRotulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 120, -1));

        imagem_de_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        jPanel1.add(imagem_de_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_usuarioActionPerformed

    private void botao_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_loginActionPerformed
        String user = campo_usuario.getText();
        String password = new String(campo_senha.getPassword());
        // Criando um objeto da classe LoginController
        LoginController controller = new LoginController();
        // Variável do tipo boolean que recebe o retorno do método authenticate
        Usuario logou = controller.authenticate(user, password);
        // Lógica do "Manter-me Conectado"
        if (logou != null) {
            if (mantenhaConc.isSelected()) {
                MantenhaConectado.salvarLogin(user, password);
            } else {
                MantenhaConectado.limparLogin();
            }
        }
            if (logou != null) {
            String mensagem = String.format("Usuário logado com sucesso!\n Bem-vindo, %s", logou.getNome());
            MensagensDialogo.mostrarSucesso(mensagem, "Login Bem-Sucedido");

            // Abrir a tela Home
            TelaHome home = new TelaHome(logou);
            home.setVisible(true);
            // Fechando a tela de login
            dispose();
            } else { // se usuário ou senha incorretos
            MensagensDialogo.mostrarErro("Usuário ou senha incorretos!", "Verifique seus dados!");
            }
    }//GEN-LAST:event_botao_loginActionPerformed
    //Variável que oculta ou mostra asenha conforme é clicado no botão
    boolean oculto = true;
    private void ocultarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarsenhaActionPerformed
        //Variáveis criadas para chamar os ícones de ocultar e mostrar do botão ocultar senha
        ImageIcon iconOcultar = new ImageIcon(getClass().getResource("/img/ocultar.png"));
        ImageIcon iconMostrar = new ImageIcon(getClass().getResource("/img/mostrar.png"));
        
        if(oculto==true){
        campo_senha.setEchoChar((char)0);// desocultar senha
        oculto=false;// senha não está mais oculta
        ocultarsenha.setIcon(iconMostrar);
        }else{// se a senha não estiver oculta
        campo_senha.setEchoChar('\u2022');// ocultar senha
        oculto=true;// senha oculta novamente
        ocultarsenha.setIcon(iconOcultar);
        }// fim do else
    }//GEN-LAST:event_ocultarsenhaActionPerformed

    private void campo_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_senhaActionPerformed

    private void labelLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLinkMouseClicked
        // TODO add your handling code here:
        TelaCadastro cadastro = new TelaCadastro();
        cadastro.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_labelLinkMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_login;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel imagem_de_fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLink;
    private javax.swing.JLabel labelRotulo1;
    private javax.swing.JLabel label_senha;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JLabel labelrodape;
    private javax.swing.JCheckBox mantenhaConc;
    private javax.swing.JButton ocultarsenha;
    // End of variables declaration//GEN-END:variables
}
