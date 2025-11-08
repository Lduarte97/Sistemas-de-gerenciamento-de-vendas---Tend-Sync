/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ClientesController;
import Controller.ProdutosController;
import Controller.VendasController;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.Produtos;
import model.Usuario;
import model.Vendas;
import util.MensagensDialogo;
import util.ValidadorCPF;
import util.ValidadorEmail;
import util.ValidadorNome;
import util.ValidadorTelefone;

/**
 *
 * @author Lucas Duarte
 */
public class TelaCarrinho extends javax.swing.JFrame {

    /**
     * Creates new form TelaCarrinho
     */
   
    private int idproduto;
    private int idcliente;
    Usuario usuario;// objeto com os dados do vendedor
    private float precoproduto;
    private float valortotalcompra;
    
    public TelaCarrinho(Usuario user) {
        initComponents();
        PesquisarProduto();
        CadastrandoUsuario();
        PesquisarClientes();
        usuario = user;
        iconeTela();
        
    }//fim do metodo TelaCarrinho
    
    public void calculandoPrecoDaVenda(){
      this.valortotalcompra = this.precoproduto*Integer.parseInt(quantidadeProduto.getSelectedItem().toString());
        // passar o resultado para o totalVendas
        totalVendas.setText(String.valueOf(valortotalcompra)); 
    }// fim do método calculandoPrecoDaVenda()
    
    public void PesquisarProduto(){
        campoPesquisaProduto.getDocument().addDocumentListener(new DocumentListener(){
         @Override
         public void insertUpdate(javax.swing.event.DocumentEvent e){
             Pesquisar();
         }//final do insertUpdate
         
         @Override
         public void removeUpdate(javax.swing.event.DocumentEvent e){
             Pesquisar();
         }// fim do removeUpdate
         
         @Override
         public void changedUpdate(javax.swing.event.DocumentEvent e){
             Pesquisar();
         }// fim do changedUpdate
         
        private void Pesquisar(){
           Listagem(campoPesquisaProduto.getText());
        }//fim do metodo pesquisar
        
        });// fim do método de captura
}
    
    public void PesquisarClientes(){
        campoPesquisaUsuario.getDocument().addDocumentListener(new DocumentListener(){
         @Override
         public void insertUpdate(javax.swing.event.DocumentEvent e){
             Pesquisar();
         }//final do insertUpdate
         
         @Override
         public void removeUpdate(javax.swing.event.DocumentEvent e){
             Pesquisar();
         }// fim do removeUpdate
         
         @Override
         public void changedUpdate(javax.swing.event.DocumentEvent e){
             Pesquisar();
         }// fim do changedUpdate
         
        private void Pesquisar(){
           ListagemDeClientes(campoPesquisaUsuario.getText());
        }//fim do metodo pesquisarClientes
        
        });// fim do método de captura
}
    
    public void Listagem(String nomeproduto){
        // Chamando o produtos controller
        ProdutosController controller = new ProdutosController();
        // Capturando a lista de produtos que vem do banco de dados
        List<Produtos> listaprodutos = controller.listarProdutosNome(nomeproduto);
        
        // enquanto lista for diferente de nill ele executa
       
       DefaultTableModel modeloTabela = (DefaultTableModel) tabela_produtos.getModel();
       
       modeloTabela.setRowCount(0);
       // Verificando se a lista não é nula
        if(listaprodutos != null && !listaprodutos.isEmpty()){
           // Jogando os dados para dentro da minha tabela
          for(Produtos produto: listaprodutos){
            // Criando uma nova linha para a tabela
            Object[] linha={
            produto.getId_produto(),
            produto.getNome_prod(),
            produto.getPreco(),
            produto.getTamanho(),
            produto.getEstoque(),
            };
          
            modeloTabela.addRow(linha);
          }
      }else{
         MensagensDialogo.mostrarAlerta("Nenhum produto encontrado!", "Aviso");
      }
        
    }// fim do metodo Listagem()
    
    public void ListagemDeClientes(String nomecliente){
        // Chamando o Clientescontroller
        ClientesController controller = new ClientesController();
        // Capturando a lista de clientes que vem do banco de dados
        List<Clientes> listaClientes = controller.listarClientes(nomecliente);
        
        // enquanto lista for diferente de null ele executa
       
       DefaultTableModel modeloTabela = (DefaultTableModel) tabela_usuario.getModel();
       
       modeloTabela.setRowCount(0);
       // Verificando se a lista não é nula
        if(listaClientes != null && !listaClientes.isEmpty()){
           // Jogando os dados para dentro da minha tabela
          for(Clientes cliente: listaClientes){
            // Criando uma nova linha para a tabela
            Object[] linha={
                cliente.getId_clientes(),
                cliente.getNome_cliente(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone()
            };
          
            modeloTabela.addRow(linha);
          }
      }else{
         MensagensDialogo.mostrarAlerta("Nenhum cliente encontrado!", "Aviso");
      }
        
    }// fim do metodo ListagemDeClientes()
    
    // Verificar esse método depois porque ele é novo 01/08/2025
    public void CadastrandoUsuario(){
    tabela_usuario.addKeyListener(new KeyAdapter(){
        @Override
        public void keyPressed(KeyEvent e){
            // Se o usuário clicou no enter
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                int coluna = tabela_usuario.getSelectedColumn();
                int linha = tabela_usuario.getSelectedRow();
                
                // verificar se o usuário digitou todos os dados na última coluna
                if(coluna == tabela_usuario.getColumnCount() - 1) {
                    
                    // --- Passo 1: Obter os dados da linha da tabela ---
                    // Note que a coluna 0 (id_clientes) é ignorada aqui para cadastro
                    String nomeCliente = String.valueOf(tabela_usuario.getValueAt(linha, 1));
                    String cpfCliente = String.valueOf(tabela_usuario.getValueAt(linha, 2));
                    String emailCliente = String.valueOf(tabela_usuario.getValueAt(linha, 3));
                    String telefoneCliente = String.valueOf(tabela_usuario.getValueAt(linha, 4));

                    // --- Passo 2: Criar a variável para acumular os erros ---
                    StringBuilder mensagensDeErro = new StringBuilder();

                    // --- Passo 3: Fazer TODAS as validações, acumulando as mensagens ---

                    // Validação do NOME
                    if (nomeCliente.trim().isEmpty()) {
                        mensagensDeErro.append("- O campo Nome é obrigatório!\n");
                    } else if (!ValidadorNome.isValidFullName(nomeCliente)) {
                        mensagensDeErro.append("- O nome completo informado não é válido.\n");
                    }
                    
                    // Validação do CPF
                    if (cpfCliente.trim().isEmpty()) {
                        mensagensDeErro.append("- O campo CPF é obrigatório!\n");
                    } else if (!ValidadorCPF.isValidCPF(cpfCliente)) {
                        mensagensDeErro.append("- O CPF informado é inválido.\n");
                    }
               
                    else{
                        ClientesController controller = new ClientesController();
                        //Chamada o método para verificar se o CPF já está cadastrado
                        if(controller.verificarCpfExistente(cpfCliente)){
                           mensagensDeErro.append("- O CPF informado já está cadastrado.\n");
                        }//fim do if
                    }//fim do else
                    
                    // Validação do EMAIL
                    if (emailCliente.trim().isEmpty()) {
                        mensagensDeErro.append("- O campo E-mail é obrigatório!\n");
                    } else if (!ValidadorEmail.isValidEmail(emailCliente)) {
                        mensagensDeErro.append("- O e-mail informado não é válido.\n");
                    }

                    // Validação do TELEFONE
                    if (telefoneCliente.trim().isEmpty()) {
                        mensagensDeErro.append("- O campo Telefone é obrigatório!\n");
                    } else if (!ValidadorTelefone.isValidTelefone(telefoneCliente)) {
                        mensagensDeErro.append("- O telefone informado não é válido.\n");
                    }
                    
                    // --- Passo 4: Exibir os erros ou prosseguir com o cadastro ---
                    if (mensagensDeErro.length() > 0) {
                        // Se houver mensagens de erro, exibe-as de uma vez
                        MensagensDialogo.mostrarErro(mensagensDeErro.toString(), "Erros de Validação");
                        return; // Interrompe o método aqui
                    }

                    // Se chegou até aqui, os dados são válidos, então pode prosseguir com o cadastro
                    try {
                        Clientes cl = new Clientes();
                        cl.setNome_cliente(nomeCliente);
                        cl.setCpf(cpfCliente);
                        cl.setEmail(emailCliente);
                        cl.setTelefone(telefoneCliente);
                        
                        ClientesController controller = new ClientesController();
                        boolean cadastrou = controller.cadastrarCliente(cl);
                        
                        if(cadastrou){
                            MensagensDialogo.mostrarSucesso("Cliente cadastrado com sucesso!", "Cadastro Realizado");
                            // Recarrega a listagem de clientes para mostrar o novo cliente
                            ListagemDeClientes("");
                        } else {
                            MensagensDialogo.mostrarErro("Erro ao cadastrar o cliente. Tente novamente.", "Erro no Cadastro");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        MensagensDialogo.mostrarErro("Ocorreu um erro inesperado ao tentar cadastrar o cliente.", "Erro Interno");
                    }
                } // fim do 1º if (coluna)
              } // fim do if (KeyEvent.VK_ENTER)
            } // fim do metodo keyPressed
        });
    } // fim do metodo CadastrandoUsuario()
    
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_usuario = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        campoPesquisaUsuario = new javax.swing.JTextField();
        campoPesquisaProduto = new javax.swing.JTextField();
        cliente = new javax.swing.JLabel();
        produto = new javax.swing.JLabel();
        carrindoCompras = new javax.swing.JLabel();
        quantidadeProduto = new javax.swing.JComboBox<>();
        formaPagamento = new javax.swing.JComboBox<>();
        precoTotal = new javax.swing.JLabel();
        totalVendas = new javax.swing.JTextField();
        botao_finalizar_venda = new javax.swing.JButton();
        botao_voltar = new javax.swing.JButton();
        imagem_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 580));

        jPanel1.setMaximumSize(new java.awt.Dimension(920, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela_usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CPF", "E-MAIL", "TELEFONE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_usuario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 790, 160));

        tabela_produtos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "PREÇO", "TAMANHO", "ESTOQUE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_produtos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 790, 160));

        campoPesquisaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campoPesquisaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(campoPesquisaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 360, 30));

        campoPesquisaProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campoPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPesquisaProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(campoPesquisaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 290, 30));

        cliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cliente.setForeground(new java.awt.Color(0, 0, 0));
        cliente.setText("CLIENTE:");
        jPanel1.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 70, 20));

        produto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        produto.setForeground(new java.awt.Color(0, 0, 0));
        produto.setText("PRODUTO:");
        jPanel1.add(produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 80, -1));

        carrindoCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        carrindoCompras.setForeground(new java.awt.Color(0, 0, 0));
        carrindoCompras.setText("CARRINHO DE COMPRAS");
        jPanel1.add(carrindoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 230, 30));

        quantidadeProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantidadeProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        quantidadeProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        quantidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(quantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, -1, 30));

        formaPagamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        formaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PIX", "CARTÃO CRÉDITO", "VARTÃO DÉBITO" }));
        formaPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        formaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaPagamentoActionPerformed(evt);
            }
        });
        jPanel1.add(formaPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 150, 30));

        precoTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        precoTotal.setForeground(new java.awt.Color(0, 0, 0));
        precoTotal.setText("Total da Venda: ");
        jPanel1.add(precoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 120, -1));

        totalVendas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalVendas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totalVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalVendasActionPerformed(evt);
            }
        });
        jPanel1.add(totalVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 170, 30));

        botao_finalizar_venda.setBackground(new java.awt.Color(0, 102, 255));
        botao_finalizar_venda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_finalizar_venda.setForeground(new java.awt.Color(255, 255, 255));
        botao_finalizar_venda.setText("FINALIZAR VENDA");
        botao_finalizar_venda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botao_finalizar_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_finalizar_vendaActionPerformed(evt);
            }
        });
        jPanel1.add(botao_finalizar_venda, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 140, 30));

        botao_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/voltar.png"))); // NOI18N
        botao_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });
        jPanel1.add(botao_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 40));

        imagem_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        jPanel1.add(imagem_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalVendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalVendasActionPerformed

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        int linhaselecionada = tabela_produtos.getSelectedRow();

        if (linhaselecionada >= 0) {
            DefaultTableModel modelotabela = (DefaultTableModel) tabela_produtos.getModel();

            Object idProdutoObj = modelotabela.getValueAt(linhaselecionada, 0);
            if (idProdutoObj != null) {
                this.idproduto = Integer.parseInt(idProdutoObj.toString());
            } else {
                MensagensDialogo.mostrarErro("Erro: ID do produto nulo na tabela.", "Erro de Dados");
                this.idproduto = -1; // Defina um valor que indique erro ou ignore a seleção
                return; // Saia do método se o ID for nulo
            }

            Object precoProdutoObj = modelotabela.getValueAt(linhaselecionada, 2);
            if (precoProdutoObj != null) {
                this.precoproduto = Float.parseFloat(precoProdutoObj.toString());
            } else {
                MensagensDialogo.mostrarErro("Erro: ID do produto nulo na tabela.", "Erro de Dados");
                this.precoproduto = 0.0f; // Defina um valor padrão
                return; // Saia do método se o preço for nulo
            }

            Object estoqueProdutoObj = modelotabela.getValueAt(linhaselecionada, 4);
            int estoqueproduto = 0;
            if (estoqueProdutoObj != null) {
                estoqueproduto = Integer.parseInt(estoqueProdutoObj.toString());
            } else {
                MensagensDialogo.mostrarErro("Erro: ID do produto nulo na tabela.", "Erro de Dados");
                return; // Saia do método se o estoque for nulo
            }

            // Limpando o campo quantidade
            quantidadeProduto.removeAllItems();
            // Criando laço de repetição para preencher o campo
            for (int i = 1; i <= estoqueproduto; i++) {
                quantidadeProduto.addItem(String.valueOf(i));
            } //fim do for
            
            // SELECIONE O PRIMEIRO ITEM APÓS PREENCHER
            if (estoqueproduto > 0) {
                quantidadeProduto.setSelectedIndex(0); // Garante que um item esteja selecionado
            } else {
                // Se não houver estoque, defina um valor padrão ou desabilite o JComboBox
                totalVendas.setText("0.0"); // Zera o total
            }

            // Chamar calculandoPrecoDaVenda SOMENTE AQUI, depois de popular o JComboBox
            calculandoPrecoDaVenda();

        } // fim do if
    }//GEN-LAST:event_tabela_produtosMouseClicked

    private void tabela_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_usuarioMouseClicked
        
        int linhaselecionada = tabela_usuario.getSelectedRow();
        
        if(linhaselecionada>=0){
            DefaultTableModel modelotabela = (DefaultTableModel)tabela_usuario.getModel();
            
            this.idcliente = Integer.parseInt(modelotabela.getValueAt(linhaselecionada,0).toString());
        }//fim do if
    }//GEN-LAST:event_tabela_usuarioMouseClicked

    private void botao_finalizar_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_finalizar_vendaActionPerformed
        VendasController controller = new VendasController();
    
        // criando um objeto do tipo vendas
        Vendas venda = new Vendas();

        // passando os valores para o objeto venda
        venda.setId_clientes(this.idcliente);
        venda.setId_produto(this.idproduto);
        venda.setId_vendedor(usuario.getId());
        venda.setQuantidade(Integer.parseInt(quantidadeProduto.getSelectedItem().toString()));
        venda.setFormadepagamento(formaPagamento.getSelectedItem().toString());

        venda.setValor(valortotalcompra);

        // ** Alteração para lidar com a nova classe Date no modelo Vendas **
        // 1. Captura a data atual do sistema como LocalDate (melhor prática para data)
        LocalDate dataAtualLocalDate = LocalDate.now();
        // 2. Converte LocalDate para java.util.Date para passar para o modelo
        Date dataAtualUtil = Date.from(dataAtualLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // 3. Define a data na venda usando o objeto Date convertido
        venda.setDatavenda(dataAtualUtil);

        boolean cadastrou = controller.cadastrarVendas(venda);

        if(cadastrou){
            // ** Alteração dos diálogos para MensagemSucesso e MensagemErro **
            MensagensDialogo.mostrarSucesso("Sua Venda foi cadastrada com sucesso!", "Venda Cadastrada");
        }else{
            // ** Alteração dos diálogos para MensagemSucesso e MensagemErro **
            MensagensDialogo.mostrarErro("Não foi possível cadastrar a venda!", "Erro ao Cadastrar");
        }
    }//GEN-LAST:event_botao_finalizar_vendaActionPerformed

    private void quantidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeProdutoActionPerformed
        calculandoPrecoDaVenda();
    }//GEN-LAST:event_quantidadeProdutoActionPerformed

    private void formaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaPagamentoActionPerformed

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltarActionPerformed

        // Flag para verificar se a tela foi alterada
        boolean alteracoesFeitas = false;

        // 1. Verifique se os campos de pesquisa foram preenchidos
        if (!campoPesquisaUsuario.getText().trim().isEmpty() ||
            !campoPesquisaProduto.getText().trim().isEmpty()) {

            alteracoesFeitas = true;
        }

        // 2. Verifique se algum cliente ou produto foi selecionado nas tabelas
        // O valor do 'totalVendas' só é atualizado após a seleção de um produto.
        // Assim, essa é uma forma confiável de saber se uma transação foi iniciada.
        if (!totalVendas.getText().trim().isEmpty() && !totalVendas.getText().trim().equals("0.0")) {
            alteracoesFeitas = true;
        }

        // Se alguma alteração foi feita, exiba o diálogo de confirmação
        if (alteracoesFeitas) {
            int resposta = MensagensDialogo.mostrarPergunta(
                "Deseja cancelar e voltar a tela home? Todos os dados não salvos serão perdidos.",
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
            // Se nenhuma alteração foi feita, volte diretamente para a tela Home
            TelaHome home = new TelaHome(usuario);
            home.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_botao_voltarActionPerformed

    private void campoPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisaProdutoActionPerformed

    private void campoPesquisaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPesquisaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPesquisaUsuarioActionPerformed

    
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
            java.util.logging.Logger.getLogger(TelaCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario user = null;
               new TelaCarrinho(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_finalizar_venda;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JTextField campoPesquisaProduto;
    private javax.swing.JTextField campoPesquisaUsuario;
    private javax.swing.JLabel carrindoCompras;
    private javax.swing.JLabel cliente;
    private javax.swing.JComboBox<String> formaPagamento;
    private javax.swing.JLabel imagem_fundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel precoTotal;
    private javax.swing.JLabel produto;
    private javax.swing.JComboBox<String> quantidadeProduto;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JTable tabela_usuario;
    private javax.swing.JTextField totalVendas;
    // End of variables declaration//GEN-END:variables
}
