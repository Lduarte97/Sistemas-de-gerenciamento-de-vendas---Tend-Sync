
package View;


import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import model.Usuario;
import javax.swing.JOptionPane;
import util.MensagensDialogo;

/**
 *
 * @author Lucas Duarte
 */
public final class TelaHome extends javax.swing.JFrame {

    
    public Usuario user;
    public TelaHome(Usuario usuario) {
    initComponents();
    user=usuario;
    nomeUsuario.setText("Bem-vindo, " + user.getNome());  // Concatenando "Bem-vindo" com o nome do usuário
    iconeTela();
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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaHome = new javax.swing.JPanel();
        nomeUsuario = new javax.swing.JLabel();
        produtos = new javax.swing.JButton();
        carrinho = new javax.swing.JButton();
        perfil = new javax.swing.JButton();
        compras = new javax.swing.JButton();
        botao_sair = new javax.swing.JButton();
        botaoAjuda = new javax.swing.JButton();
        botaoSobre = new javax.swing.JButton();
        labelrodape = new javax.swing.JLabel();
        jimagemDeFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 478));

        TelaHome.setMaximumSize(new java.awt.Dimension(920, 580));
        TelaHome.setMinimumSize(new java.awt.Dimension(920, 580));
        TelaHome.setPreferredSize(new java.awt.Dimension(920, 580));
        TelaHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nomeUsuario.setForeground(new java.awt.Color(0, 0, 0));
        nomeUsuario.setText("Nome usuário");
        TelaHome.add(nomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 280, 20));

        produtos.setBackground(new java.awt.Color(204, 204, 204));
        produtos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        produtos.setForeground(new java.awt.Color(0, 0, 0));
        produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produtos.png"))); // NOI18N
        produtos.setText("Produtos");
        produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosActionPerformed(evt);
            }
        });
        TelaHome.add(produtos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, 40));

        carrinho.setBackground(new java.awt.Color(204, 204, 204));
        carrinho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        carrinho.setForeground(new java.awt.Color(0, 0, 0));
        carrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrinho.png"))); // NOI18N
        carrinho.setText("Carrinho");
        carrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrinhoActionPerformed(evt);
            }
        });
        TelaHome.add(carrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, 40));

        perfil.setBackground(new java.awt.Color(204, 204, 204));
        perfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        perfil.setForeground(new java.awt.Color(0, 0, 0));
        perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil.png"))); // NOI18N
        perfil.setText("Perfil");
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        TelaHome.add(perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 40));

        compras.setBackground(new java.awt.Color(204, 204, 204));
        compras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        compras.setForeground(new java.awt.Color(0, 0, 0));
        compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compras.png"))); // NOI18N
        compras.setText("Compras");
        compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprasActionPerformed(evt);
            }
        });
        TelaHome.add(compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 140, 40));

        botao_sair.setBackground(new java.awt.Color(204, 204, 204));
        botao_sair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botao_sair.setForeground(new java.awt.Color(0, 0, 0));
        botao_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        botao_sair.setText("Sair");
        botao_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_sairActionPerformed(evt);
            }
        });
        TelaHome.add(botao_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 140, 40));

        botaoAjuda.setBackground(new java.awt.Color(204, 204, 204));
        botaoAjuda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoAjuda.setForeground(new java.awt.Color(0, 0, 0));
        botaoAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ajuda.png"))); // NOI18N
        botaoAjuda.setText("Ajuda");
        botaoAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAjudaActionPerformed(evt);
            }
        });
        TelaHome.add(botaoAjuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 140, 40));

        botaoSobre.setBackground(new java.awt.Color(204, 204, 204));
        botaoSobre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoSobre.setForeground(new java.awt.Color(0, 0, 0));
        botaoSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sobre.png"))); // NOI18N
        botaoSobre.setText("Sobre");
        botaoSobre.setActionCommand("Sobre");
        botaoSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSobreActionPerformed(evt);
            }
        });
        TelaHome.add(botaoSobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 40));

        labelrodape.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelrodape.setForeground(new java.awt.Color(0, 0, 0));
        labelrodape.setText("© 2025 Tend Sync. Todos os direitos reservados. Desenvolvido por Lucas Duarte.");
        TelaHome.add(labelrodape, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, -1, -1));

        jimagemDeFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        jimagemDeFundo.setFocusCycleRoot(true);
        jimagemDeFundo.setMaximumSize(new java.awt.Dimension(850, 478));
        jimagemDeFundo.setMinimumSize(new java.awt.Dimension(850, 478));
        jimagemDeFundo.setName(""); // NOI18N
        jimagemDeFundo.setPreferredSize(new java.awt.Dimension(850, 478));
        TelaHome.add(jimagemDeFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Chamada das telas através dos botões
    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        //Chamada da tela perfil
        TelaPerfil telaperfil = new TelaPerfil(user);
        //Deixa atela visível
        telaperfil.setVisible(true);
        //Fecha a tela home
        dispose();
    }//GEN-LAST:event_perfilActionPerformed

    private void produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosActionPerformed

        TelaProdutos telaprodutos = new TelaProdutos(user);
        telaprodutos.setVisible(true);
        dispose();
    }//GEN-LAST:event_produtosActionPerformed

    private void botao_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_sairActionPerformed
       //Criação de variável para receber a resposta do usuário e chamada da mensagem de diálogo personalizada
        int resposta = MensagensDialogo.mostrarPergunta(
               "Deseja encerrar sua sessão?",
               "Confirmação",
                JOptionPane.OK_CANCEL_OPTION // Tipo de botões que você quer: OK e Cancelar
                );

                // Verifica a resposta do usuário
                if (resposta == JOptionPane.OK_OPTION) {
                    // Voltar para a tela de login
                    TelaLogin login = new TelaLogin();
                    login.setVisible(true);
                    dispose(); // Fecha a tela atual
                }
                    // Caso clique em "Cancelar", nada acontece
    }//GEN-LAST:event_botao_sairActionPerformed

    private void carrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrinhoActionPerformed
        TelaCarrinho carrinho = new TelaCarrinho(user);
        carrinho.setVisible(true);
        dispose();
    }//GEN-LAST:event_carrinhoActionPerformed

    private void comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprasActionPerformed
        // TODO add your handling code here:
        TelaCompras compras = new TelaCompras(user);
        compras.setVisible(true);
        dispose();
    }//GEN-LAST:event_comprasActionPerformed

    private void botaoAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAjudaActionPerformed
        // TODO add your handling code here:
        String urlManual = "https://github.com/Lduarte97/Sistemas-de-gerenciamento-de-vendas---Tend-Sync/blob/aecd4db424c39418bbac0039559c4b70ee2a787b/Manual_de_usabilidade_do_Usu%C3%A1rio.md#tela-de-login";

            // Verifica se o recurso Desktop é suportado (necessário para abrir o navegador)
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    // Converte o String URL para um objeto URI
                    URI uri = new URI(urlManual);

                    // Abre o navegador padrão do sistema
                    Desktop.getDesktop().browse(uri);

                } catch (Exception e) {
                    // Trata qualquer erro (URL mal formatada, problema ao abrir o navegador, etc.)
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, 
                        "Não foi possível abrir o manual. Verifique o link: " + urlManual, 
                        "Erro de Acesso", JOptionPane.ERROR_MESSAGE);
                }//fim do catch
            } else {
                // Caso o ambiente não suporte a função Desktop (muito raro em desktops modernos)
                JOptionPane.showMessageDialog(this, 
                    "Seu sistema não suporta a abertura automática de navegadores.\nPor favor, acesse o link manualmente: " + urlManual, 
                    "Funcionalidade Indisponível", JOptionPane.WARNING_MESSAGE);
         }//fim do else
    }//GEN-LAST:event_botaoAjudaActionPerformed

    private void botaoSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSobreActionPerformed
        // TODO add your handling code here:
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_botaoSobreActionPerformed

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
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario user = null;
                new TelaHome(user).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TelaHome;
    private javax.swing.JButton botaoAjuda;
    private javax.swing.JButton botaoSobre;
    private javax.swing.JButton botao_sair;
    private javax.swing.JButton carrinho;
    private javax.swing.JButton compras;
    private javax.swing.JLabel jimagemDeFundo;
    private javax.swing.JLabel labelrodape;
    private javax.swing.JLabel nomeUsuario;
    private javax.swing.JButton perfil;
    private javax.swing.JButton produtos;
    // End of variables declaration//GEN-END:variables

    private TelaProdutos TelaProdutos(JButton produtos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
