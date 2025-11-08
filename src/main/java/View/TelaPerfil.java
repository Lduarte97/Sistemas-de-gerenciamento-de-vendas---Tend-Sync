
package View;

import Controller.UsuarioController;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Usuario;
import util.MensagensDialogo;

/**
 *
 * @author Lucas Duarte
 */
public class TelaPerfil extends javax.swing.JFrame {

    Usuario usuario;
    public TelaPerfil(Usuario user) {
        initComponents();
        usuario=user;
        // Chamada para os campos já carregarem com os dados do usuário logado
        campo_nome.setText(user.getNome());
        campo_email.setText(user.getEmail());
        campo_senha.setText(user.getSenha());
        campo_cpf.setText(user.getCpf());
        campo_data_nasc.setText(converterData(user.getDataNascimento()));
        ocultarsenha.setIcon(new ImageIcon(getClass().getResource("/img/ocultar.png")));
        iconeTela();
        
        
    }//fim do initComponents()
    
    //Método para mudar o ícone da tela
    private void iconeTela(){
        try {
            Image iconeTitulo = ImageIO.read(getClass().getResource("/img/icone.png"));
            this.setIconImage(iconeTitulo);
          
        }catch(IOException ex){
            System.out.println("Erro ao importar icone: " + ex.getMessage());
        }
    }// fim do coneTela()
    
    // Método para converter a string digitada pelo usuário em data
    public String converterData(java.sql.Date data){
        try{
        // Conferindo o formato desejado para exibição
        
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yyyy");
        // Convertendo a data para formato desejado
        
        String dataFormatada = formatoData.format(data);
        // Exibindo a data no JTextField
        
        return dataFormatada;
        
        }catch(Exception e){
            
            System.err.print("Data não pode ser convertida"+e);
            
           return null;
        }
    }//Fim do metodo converterData

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        perfil_usuario = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        data_de_nasc = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        campo_email = new javax.swing.JTextField();
        campo_senha = new javax.swing.JPasswordField();
        ocultarsenha = new javax.swing.JButton();
        campo_data_nasc = new javax.swing.JFormattedTextField();
        botao_atualizar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        campo_cpf = new javax.swing.JFormattedTextField();
        excluir_conta = new javax.swing.JButton();
        imagem_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 580));

        jPanel1.setMaximumSize(new java.awt.Dimension(920, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        perfil_usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        perfil_usuario.setForeground(new java.awt.Color(0, 0, 0));
        perfil_usuario.setText("PERFIL DO USUÁRIO");
        jPanel1.add(perfil_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 190, -1));

        nome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nome.setForeground(new java.awt.Color(0, 0, 0));
        nome.setText("NOME");
        jPanel1.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 56, 26));

        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));
        email.setText("E-MAIL");
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 56, 26));

        cpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cpf.setForeground(new java.awt.Color(0, 0, 0));
        cpf.setText("CPF");
        jPanel1.add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 30, 26));

        senha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        senha.setForeground(new java.awt.Color(0, 0, 0));
        senha.setText("SENHA");
        jPanel1.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 56, 26));

        data_de_nasc.setBackground(new java.awt.Color(255, 255, 255));
        data_de_nasc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        data_de_nasc.setForeground(new java.awt.Color(0, 0, 0));
        data_de_nasc.setText("DATA NASC.");
        jPanel1.add(data_de_nasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 90, 26));

        campo_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nomeActionPerformed(evt);
            }
        });
        jPanel1.add(campo_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 400, 40));

        campo_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(campo_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 400, 40));

        campo_senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_senhaActionPerformed(evt);
            }
        });
        jPanel1.add(campo_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 350, 40));

        ocultarsenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ocultarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarsenhaActionPerformed(evt);
            }
        });
        jPanel1.add(ocultarsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 50, 40));

        campo_data_nasc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            campo_data_nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(campo_data_nasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 130, 40));

        botao_atualizar.setBackground(new java.awt.Color(51, 51, 255));
        botao_atualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_atualizar.setForeground(new java.awt.Color(255, 255, 255));
        botao_atualizar.setText("ATUALIZAR");
        botao_atualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botao_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_atualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botao_atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 100, 30));

        voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/voltar.png"))); // NOI18N
        voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        jPanel1.add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 40));

        campo_cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            campo_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(campo_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 160, 40));

        excluir_conta.setBackground(new java.awt.Color(255, 51, 51));
        excluir_conta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        excluir_conta.setForeground(new java.awt.Color(255, 255, 255));
        excluir_conta.setText("EXCLUIR CONTA");
        excluir_conta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        excluir_conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_contaActionPerformed(evt);
            }
        });
        jPanel1.add(excluir_conta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 110, 30));

        imagem_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        jPanel1.add(imagem_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_atualizarActionPerformed
        // TODO add your handling code here:
        
        //Chamada da classe controller para atualizar os dados
         UsuarioController controller = new UsuarioController();
        try{
            
            //Configurando o formato da data
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            // Convertendo o texto do campo em um objeto java.util.Date
            java.util.Date ParsedDate =  dateFormat.parse(campo_data_nasc.getText());
            // Convertendo java.util.Date para java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date (ParsedDate.getTime());

            Usuario user;
            user = new Usuario(
                    this.usuario.getId(),
                    campo_email.getText(),
                    new String(campo_senha.getPassword()),
                    campo_cpf.getText(),
                    campo_nome.getText(),
                    
                    sqlDate
            );
            
            boolean sucesso = controller.atualizarUsuario(user);
            
            if (sucesso){
                MensagensDialogo.mostrarSucesso("Dados atualizados com sucesso!","Atualização");
            }else {
                MensagensDialogo.mostrarErro("Erro ao atualizar os dados!", "Erro de atualização");
            }

        }catch(Exception e){
            MensagensDialogo.mostrarErro("Não foi possível atualizar os dados! Detalhes: " + e.getMessage(),"Erro de Atualização");
        }//fim do catch
    }//GEN-LAST:event_botao_atualizarActionPerformed
        boolean oculto = true;
    private void campo_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_senhaActionPerformed

    private void ocultarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarsenhaActionPerformed
      
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

    private void campo_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nomeActionPerformed
        
    }//GEN-LAST:event_campo_nomeActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed

        // Voltar para a tela Home
        TelaHome home = new TelaHome(usuario);
        home.setVisible(true);
        dispose(); // Fecha a tela atual
        
    }//GEN-LAST:event_voltarActionPerformed

    private void excluir_contaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_contaActionPerformed
      
    // Mostra um diálogo de confirmação antes de tentar excluir a conta
    int resposta = MensagensDialogo.mostrarPergunta(
        "Tem certeza que deseja excluir sua conta permanentemente? Esta ação não pode ser desfeita.",
        "Confirmação de Exclusão",
        JOptionPane.YES_NO_OPTION // Opções "Sim" e "Não"
    );

    // Se o usuário clicar em "Sim"
    if (resposta == JOptionPane.YES_OPTION) {
        UsuarioController controller = new UsuarioController();

        try {
            boolean deletou = controller.deletarUsuario(usuario.getId());

            if (deletou) {
                MensagensDialogo.mostrarSucesso("A conta foi excluída com sucesso!", "Sucesso");
                // Após a exclusão, o usuário é levado de volta a tela de login
                TelaLogin login = new TelaLogin();
                login.setVisible(true);
                dispose();
            } else {
                MensagensDialogo.mostrarAlerta("Não foi possível excluir a conta!", "Alerta");
            } // final do else

        } catch (Exception e) {
            MensagensDialogo.mostrarErro("Erro ao excluir a conta! Detalhes: " + e.getMessage(), "Erro");
        }
      }
    }//GEN-LAST:event_excluir_contaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario user = null;
                new TelaPerfil(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JFormattedTextField campo_cpf;
    private javax.swing.JFormattedTextField campo_data_nasc;
    private javax.swing.JTextField campo_email;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JLabel cpf;
    private javax.swing.JLabel data_de_nasc;
    private javax.swing.JLabel email;
    private javax.swing.JButton excluir_conta;
    private javax.swing.JLabel imagem_fundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nome;
    private javax.swing.JButton ocultarsenha;
    private javax.swing.JLabel perfil_usuario;
    private javax.swing.JLabel senha;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
