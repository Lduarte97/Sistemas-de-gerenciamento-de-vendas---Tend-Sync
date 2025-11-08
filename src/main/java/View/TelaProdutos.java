
package View;

import Controller.ProdutosController;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produtos;
import model.Usuario;
import util.MensagensDialogo;
import util.ValidadorNomeProduto;
/**
 *
 * @author Lucas Duarte
 */
public class TelaProdutos extends javax.swing.JFrame {

    /**
     * Creates new form TelaProdutos
     */
    int idproduto;
    
    Usuario usuario;
    public TelaProdutos(Usuario user) {
        initComponents(); 
        Listagem();
        usuario = user;
        iconeTela();
        
    }
    // Aqui pegamos os dados do controller e jogamos na nossa tabela
    public void Listagem(){
        // Chamando o produtos controller
        ProdutosController controller = new ProdutosController();
        // Capturando a lista de produtos que vem do banco de dados
        List<Produtos> listaprodutos = controller.listarProdutos();
        
        // enquanto lista for diferente de nill ele executa
       
       DefaultTableModel modeloTabela = (DefaultTableModel) tabela_produto.getModel();
       
       modeloTabela.setRowCount(0);
       // Verificando se a lista não é nula
        if(listaprodutos != null && !listaprodutos.isEmpty()){
           // Jogando os dados para dentro da minha tabela
          for(Produtos produto: listaprodutos){
            // Criando uma nova linha para a tabela
            Object[] linha={
            produto.getId_produto(),
            produto.getNome_prod(),
            produto.getEstoque(),
            produto.getPreco(),
            produto.getTamanho(),
            };
          
            modeloTabela.addRow(linha);
          }
      }else{
        //Chamada da mensagem de alerta personalizada caso a lista retorne vazia
        MensagensDialogo.mostrarAlerta("Não foi possível listar os produtos cadastrados!", "Lista vazia");
      }
        
    }// fim do metodo Listagem()
    
    // Método que limpa os campos 
    private void LimparCampos(){
        campo_nome.setText("");
        campo_preco.setText("");
        campo_estoque.setSelectedIndex(0);
        campo_tamanho.setSelectedIndex(0);
    }//fim do método limpar campos
    
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

        painel = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        estoque = new javax.swing.JLabel();
        preco = new javax.swing.JLabel();
        tamanho = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        campo_preco = new javax.swing.JTextField();
        campo_estoque = new javax.swing.JComboBox<>();
        campo_tamanho = new javax.swing.JComboBox<>();
        botao_cadastrar = new javax.swing.JButton();
        titulo_tela = new javax.swing.JLabel();
        botao_voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_produto = new javax.swing.JTable();
        botao_atualizar = new javax.swing.JButton();
        botao_excluir = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        imagem_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 580));

        painel.setMaximumSize(new java.awt.Dimension(920, 580));
        painel.setMinimumSize(new java.awt.Dimension(920, 580));
        painel.setPreferredSize(new java.awt.Dimension(1080, 1080));
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nome.setForeground(new java.awt.Color(0, 0, 0));
        nome.setText("NOME");
        painel.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 60, 30));

        estoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        estoque.setForeground(new java.awt.Color(0, 0, 0));
        estoque.setText("ESTOQUE");
        painel.add(estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        preco.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        preco.setForeground(new java.awt.Color(0, 0, 0));
        preco.setText("PREÇO");
        painel.add(preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        tamanho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tamanho.setForeground(new java.awt.Color(0, 0, 0));
        tamanho.setText("TAMANHO");
        painel.add(tamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        campo_nome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        painel.add(campo_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 330, 40));

        campo_preco.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        campo_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_precoActionPerformed(evt);
            }
        });
        painel.add(campo_preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 330, 40));

        campo_estoque.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campo_estoque.setForeground(new java.awt.Color(0, 0, 0));
        campo_estoque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sel. estoque", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));
        painel.add(campo_estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 90, 40));

        campo_tamanho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campo_tamanho.setForeground(new java.awt.Color(0, 0, 0));
        campo_tamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sel. tamanho", "34", "36", "38", "40", "42", "44", "46", "48" }));
        painel.add(campo_tamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 90, 40));

        botao_cadastrar.setBackground(new java.awt.Color(51, 0, 255));
        botao_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        botao_cadastrar.setText("CADASTRAR");
        botao_cadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botao_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrarActionPerformed(evt);
            }
        });
        painel.add(botao_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 110, 30));

        titulo_tela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo_tela.setForeground(new java.awt.Color(0, 0, 0));
        titulo_tela.setText("CADASTRO DE PRODUTOS");
        painel.add(titulo_tela, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 280, -1));

        botao_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/voltar.png"))); // NOI18N
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });
        painel.add(botao_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 40));

        tabela_produto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabela_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Estoque", "Preço", "Tamanho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_produto);

        painel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 750, 180));

        botao_atualizar.setBackground(new java.awt.Color(204, 204, 204));
        botao_atualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_atualizar.setForeground(new java.awt.Color(0, 0, 0));
        botao_atualizar.setText("ATUALIZAR");
        botao_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_atualizarActionPerformed(evt);
            }
        });
        painel.add(botao_atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 110, 30));

        botao_excluir.setBackground(new java.awt.Color(255, 0, 51));
        botao_excluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_excluir.setForeground(new java.awt.Color(255, 255, 255));
        botao_excluir.setText("EXCLUIR");
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });
        painel.add(botao_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 110, 30));

        botaoLimpar.setBackground(new java.awt.Color(0, 255, 204));
        botaoLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoLimpar.setForeground(new java.awt.Color(0, 0, 0));
        botaoLimpar.setText("LIMPAR");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });
        painel.add(botaoLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 110, 30));

        imagem_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        painel.add(imagem_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Parei aqui nos comentários e na implementação final
    private void campo_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_precoActionPerformed

    private void botao_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrarActionPerformed
       // 1ª Verificação - para saber se o campo nome está vazio
        if (campo_nome.getText().trim().isEmpty()){
            //Chamada da mensagem de alerta da classe Mensagens Dialogo (aqui vamos nomear essa chamada de CCMD)
            MensagensDialogo.mostrarAlerta("O campo nome é obrigatório!", "Aviso");
          return;
       // 2ª Verificação - Para saber se o nome informado é válido ou não
       }else if (!ValidadorNomeProduto.isValidProductName(campo_nome.getText())){
           String mensagemErro = "O nome do produto informado é inválido. \n " +
                                 "Por favor, use um nome válido, contendo apenas letras";
           MensagensDialogo.mostrarErro(mensagemErro, "nome inválido");//CCMD
           return;
       }//fim do else if
        
       // 1ª Verificação para ver se o campo está vazio ou não
       if (campo_preco.getText().trim().isEmpty()){
           MensagensDialogo.mostrarAlerta("O campo preço é obrigatório!", "Aviso");//CCMD
           return;
       }else {
           try {
               // 2ª Verificação para ver se o dado informado é um número
               Float.parseFloat(campo_preco.getText());
           } catch(NumberFormatException e){
               MensagensDialogo.mostrarErro("O valor informado deve ser do tipo numérico", "Erro");//CCMD
               return;
           }//fim do catch
        
       }//fim do else if
       
       //criação de variável do tipo String que recebe o valor selecioando pelo usuário no combobox
       String itemEstoqueSelecionado = (String) campo_estoque.getSelectedItem();
       //verificação para ver se o usuário selecionou um valor ou se está o padrão quando carrega a tela "Sel. Estoque"
       if (itemEstoqueSelecionado == null || itemEstoqueSelecionado.equals("Sel. estoque")){
           MensagensDialogo.mostrarAlerta("Selecione a quantidade de estoque do produto!", "Aviso");//CCMD
           return;
       }// fim do if
       
       //Variável que recebe o valor selecionado pelo usuário no combobox
       String itemTamanhoSelecionado = (String) campo_tamanho.getSelectedItem();
       //verificação para ver se o usuário selecionou um valor ou se está o padrão quando carrega a tela "Sel. tamanho"
       if (itemTamanhoSelecionado == null || itemTamanhoSelecionado.equals("Sel. tamanho")){
           MensagensDialogo.mostrarAlerta("Selecione o tamanho do produto!", "Aviso");//CCMD
       }//fim do if
      
        ProdutosController controller = new ProdutosController();
        // Convertendo preço para tipo float
        float prc= Float.parseFloat(campo_preco.getText());
        
        // Convertendo estoque para inteiro
        int est= Integer.parseInt((String)campo_estoque.getSelectedItem());
        
        // Convertendo tamanho para inteiro
        int tmn= Integer.parseInt((String)campo_tamanho.getSelectedItem());
        try{
           // Criando objeto do tipo produtos
           Produtos produto = new Produtos();
           produto.setNome_prod(campo_nome.getText());
           produto.setEstoque(est);
           produto.setPreco(prc);
           produto.setTamanho(tmn);
           // mandando os dados do produto para o metodo de cadastro
           boolean cadastrou = controller.cadastrandoProduto(produto);
           
           //Verificando se foi cadastrado
           if(cadastrou){
              MensagensDialogo.mostrarSucesso("O produto foi cadastrado com sucesso!", "Sucesso");//CCMD
              Listagem();// listar novos produtos assim que são cadastrados
              LimparCampos(); // Limpa os campos após a exclusão
           }else{
              MensagensDialogo.mostrarErro("Erro ao cadastrar o produto!","Erro");//CCMD
           }// fim do else
        }catch(Exception e){
           System.err.print("Erro ao cadastrar"+e);
        }//fim do catch
    }//GEN-LAST:event_botao_cadastrarActionPerformed

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltarActionPerformed

        // Flag para verificar se algum campo foi preenchido
        boolean camposPreenchidos = false;

        // Verifique se algum campo de texto ou JComboBox tem conteúdo alterado
        if (!campo_nome.getText().trim().isEmpty() ||
            !campo_preco.getText().trim().isEmpty() ||
            campo_estoque.getSelectedIndex() != 0 ||
            campo_tamanho.getSelectedIndex() != 0) {

            camposPreenchidos = true;
        }

        // Se algum campo estiver preenchido, mostre a confirmação
        if (camposPreenchidos) {
            int resposta = MensagensDialogo.mostrarPergunta(
                "Deseja cancelar e voltar a tela home?",
                "Confirmação",
                JOptionPane.OK_CANCEL_OPTION
            );

            // Se o usuário confirmar, volte para a tela Home
            if (resposta == JOptionPane.OK_OPTION) {
                TelaHome home = new TelaHome(usuario);
                home.setVisible(true);
                dispose();
            }
        } else {
            // Se nenhum campo estiver preenchido, volte diretamente para a tela Home
            TelaHome home = new TelaHome(usuario);
            home.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_botao_voltarActionPerformed

    private void tabela_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtoMouseClicked
        
        // Capturar qual linha o usuário clicou
        int linhaSelecionada = tabela_produto.getSelectedRow();
        
       // verificando se alguma linha foi selecionada
       if(linhaSelecionada>=0){
       
       DefaultTableModel modelotabela = (DefaultTableModel) tabela_produto.getModel();
       
       // jogando os dados da tabela para os campos de texto
        this.idproduto = Integer.parseInt(modelotabela.getValueAt(linhaSelecionada,0).toString());
       campo_nome.setText(modelotabela.getValueAt(linhaSelecionada,1).toString());
       campo_estoque.setSelectedItem(modelotabela.getValueAt(linhaSelecionada,2).toString());
       campo_preco.setText(modelotabela.getValueAt(linhaSelecionada,3).toString());
       campo_tamanho.setSelectedItem(modelotabela.getValueAt(linhaSelecionada,4).toString());
           
       }//fim do if
    }//GEN-LAST:event_tabela_produtoMouseClicked

    private void botao_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_atualizarActionPerformed
        ProdutosController controller = new ProdutosController();
        // Convertendo preço para tipo float
        float prc= Float.parseFloat(campo_preco.getText());
        
        // Convertendo estoque para inteiro
        int est= Integer.parseInt((String)campo_estoque.getSelectedItem());
        
        // Convertendo tamanho para inteiro
        int tmn= Integer.parseInt((String)campo_tamanho.getSelectedItem());
        try{
           // Criando objeto do tipo produtos
           Produtos produto = new Produtos();
           produto.setNome_prod(campo_nome.getText());
           produto.setEstoque(est);
           produto.setPreco(prc);
           produto.setTamanho(tmn);
           produto.setId_produto(this.idproduto);
           // mandando os dados do produto para o metodo de cadastro
           boolean atualizou = controller.editarProdutos(produto);
           
          //Verificação para saber se os dados foram atualizados ou não
           if(atualizou){
              MensagensDialogo.mostrarSucesso("A atualização foi realizada com sucesso!", "Sucesso");//CCMD
              Listagem();// listar novos produtos assim que são cadastrados
              LimparCampos(); // Limpa os campos após a exclusão
           }else{
              MensagensDialogo.mostrarErro("Erro ao atualizar os dados!", "Erro");//CCMD
           }// fim do else
        }catch(Exception e){
           System.err.print("Erro ao atualizar"+e);
        }// fim do catch
    }//GEN-LAST:event_botao_atualizarActionPerformed

    private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
        ProdutosController controller = new ProdutosController();

            // Exibe a caixa de diálogo de confirmação com a classe MensagensDialogo
        int resposta = MensagensDialogo.mostrarPergunta(
            "Tem certeza de que deseja excluir este produto?",
            "Confirmação de exclusão",
            JOptionPane.YES_NO_OPTION
        );

        // Se o usuário confirmar a exclusão
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                // Chamando o método excluir
                boolean excluido = controller.excluirProdutos(this.idproduto);

                if (excluido) {
                    // Mensagem de sucesso personalizada
                    MensagensDialogo.mostrarSucesso("Produto excluído com sucesso!", "Sucesso");

                    Listagem(); // Atualiza a listagem após exclusão
                    LimparCampos(); // Limpa os campos após a exclusão

                } else {
                    // Mensagem de erro personalizada
                    MensagensDialogo.mostrarErro(
                        "Erro ao excluir o produto. Verifique se ele está vinculado a outros registros.",
                        "Erro"
                    );
                }// fim do else
            } catch (Exception e) {
                // Mensagem de erro personalizada para a exceção
                MensagensDialogo.mostrarErro(
                    "Erro ao excluir o produto! " + e.getMessage(),
                    "Erro"
                );
            }//fim do catch
        }//fim do if resposta
    }//GEN-LAST:event_botao_excluirActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        // TODO add your handling code here:
        //Chamada do método de limpar os campos
        LimparCampos();
    }//GEN-LAST:event_botaoLimparActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = null;
                new TelaProdutos(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JButton botao_cadastrar;
    private javax.swing.JButton botao_excluir;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JComboBox<String> campo_estoque;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JTextField campo_preco;
    private javax.swing.JComboBox<String> campo_tamanho;
    private javax.swing.JLabel estoque;
    private javax.swing.JLabel imagem_fundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel preco;
    private javax.swing.JTable tabela_produto;
    private javax.swing.JLabel tamanho;
    private javax.swing.JLabel titulo_tela;
    // End of variables declaration//GEN-END:variables
}
