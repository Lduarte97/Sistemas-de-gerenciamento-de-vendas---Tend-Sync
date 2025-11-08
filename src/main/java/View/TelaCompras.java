/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.VendasController;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.RelatorioVendas;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Usuario;
import util.MensagensDialogo;

/**
 *
 * @author Lucas Duarte
 */
public class TelaCompras extends javax.swing.JFrame {

    /**
     * Creates new form TelaCompras
     */
    Usuario usuario;// objeto com os dados do vendedor
    public TelaCompras(Usuario user) {
        initComponents();
        popularDatasCombos(); 
        ListagemVendasComFiltro(null, null, null);
        usuario = user;
        iconeTela();
// ** Adiciona o DocumentListener aqui, no construtor **
        // Isso ativa o filtro em tempo real no campo de cliente
        pesquisa_cliente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                realizarFiltragemAutomatica();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                realizarFiltragemAutomatica();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Não é usado para JTextFields
            }
            
            private void realizarFiltragemAutomatica() {
                String nomeCliente = pesquisa_cliente.getText().trim();
                
                // Pega os textos dos JComboBox de data para o filtro completo
                String dataInicio = (String) data_inicio.getSelectedItem();
                String dataFim = (String) data_fim.getSelectedItem();
                
                if ("Todas as datas".equals(dataInicio)) {
                    dataInicio = null;
                }
                if ("Todas as datas".equals(dataFim)) {
                    dataFim = null;
                }

                ListagemVendasComFiltro(dataInicio, dataFim, nomeCliente);
            }
        }); 
        
    }
    
    // TelaCompras.java

// ...

    public void ListagemVendasComFiltro(String dataInicioStr, String dataFimStr, String nomeCliente){
        VendasController controller = new VendasController();

        // AQUI: Declare as variáveis como java.util.Date
        java.util.Date dataInicio = null;
        java.util.Date dataFim = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (dataInicioStr != null && !"Todas as datas".equals(dataInicioStr)) {
                dataInicio = sdf.parse(dataInicioStr);
            }
            if (dataFimStr != null && !"Todas as datas".equals(dataFimStr)) {
                dataFim = sdf.parse(dataFimStr);
            }
        } catch (ParseException e) {
            System.err.println("Erro de formatação de data: " + e.getMessage());
        }

        // Agora o controller.listarVendasComFiltro espera e recebe objetos java.util.Date
        List<RelatorioVendas> lista = controller.listarVendasComFiltro(dataInicio, dataFim, nomeCliente);

        DefaultTableModel modeloTabela = (DefaultTableModel) tabela_compras.getModel();
        modeloTabela.setRowCount(0);

        if(lista!= null && !lista.isEmpty()){
            SimpleDateFormat sdfTabela = new SimpleDateFormat("dd/MM/yyyy");

            for(RelatorioVendas vendas : lista){
                Object[] linha = {
                    vendas.getNomeCliente(),
                    vendas.getNomeProduto(),
                    vendas.getNomeVendedor(),
                    vendas.getQuantidade(),
                    vendas.getPreco(),
                    sdfTabela.format(vendas.getDataVenda())
                };
                modeloTabela.addRow(linha);
            }// fim do for
        }//fim do if
    }//fim do ListagemVendasComFiltro()

    //Método para mudar o ícone da tela
    private void iconeTela(){
        try {
            Image iconeTitulo = ImageIO.read(getClass().getResource("/img/icone.png"));
            this.setIconImage(iconeTitulo);
          
        }catch(IOException ex){
            System.out.println("Erro ao importar icone: " + ex.getMessage());
        }
    }// fim do coneTela()
    
    private void popularDatasCombos() {
    VendasController controller = new VendasController();
    List<java.util.Date> datas = controller.listarDatasDeVenda();
    
        // Limpa os combos e adiciona a opção padrão "Todas as datas"
        data_inicio.removeAllItems();
        data_fim.removeAllItems();

        // Adiciona a opção "Todas as datas"
        data_inicio.addItem("Todas as datas");
        data_fim.addItem("Todas as datas");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if (datas != null && !datas.isEmpty()) {
            for (Date data : datas) {
                String dataFormatada = sdf.format(data);
                data_inicio.addItem(dataFormatada);
                data_fim.addItem(dataFormatada);
            }//fim do for
        }//fim do if
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_compras = new javax.swing.JTable();
        data_inicio = new javax.swing.JComboBox<>();
        data_fim = new javax.swing.JComboBox<>();
        label_data_inicio = new javax.swing.JLabel();
        label_data_fim = new javax.swing.JLabel();
        nome_cliente = new javax.swing.JLabel();
        pesquisa_cliente = new javax.swing.JTextField();
        Botao_baixar_pdf = new javax.swing.JButton();
        titulo_da_tela = new javax.swing.JLabel();
        botao_voltar = new javax.swing.JButton();
        botaoFiltrar = new javax.swing.JButton();
        imagem_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 580));

        jPanel1.setMinimumSize(new java.awt.Dimension(920, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela_compras.setBackground(new java.awt.Color(255, 255, 255));
        tabela_compras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabela_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome do cliente", "Nome de produtos", "Nome do vendedor", "Quantidade", "Preço total", "Data da venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_compras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 860, 280));

        data_inicio.setBackground(new java.awt.Color(255, 255, 255));
        data_inicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        data_inicio.setForeground(new java.awt.Color(0, 0, 0));
        data_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        data_inicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(data_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 80, 30));

        data_fim.setBackground(new java.awt.Color(255, 255, 255));
        data_fim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        data_fim.setForeground(new java.awt.Color(0, 0, 0));
        data_fim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        data_fim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(data_fim, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 80, 30));

        label_data_inicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_data_inicio.setForeground(new java.awt.Color(0, 0, 0));
        label_data_inicio.setText("Data de Início");
        jPanel1.add(label_data_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 100, 30));

        label_data_fim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_data_fim.setForeground(new java.awt.Color(0, 0, 0));
        label_data_fim.setText("Data Final");
        jPanel1.add(label_data_fim, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 100, 30));

        nome_cliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nome_cliente.setForeground(new java.awt.Color(0, 0, 0));
        nome_cliente.setText("Nome do Cliente:");
        jPanel1.add(nome_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 170, 30));

        pesquisa_cliente.setBackground(new java.awt.Color(255, 255, 255));
        pesquisa_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pesquisa_cliente.setForeground(new java.awt.Color(0, 0, 0));
        pesquisa_cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pesquisa_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 290, 30));

        Botao_baixar_pdf.setBackground(new java.awt.Color(102, 153, 255));
        Botao_baixar_pdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Botao_baixar_pdf.setForeground(new java.awt.Color(0, 0, 0));
        Botao_baixar_pdf.setText("Baixar pdf");
        Botao_baixar_pdf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Botao_baixar_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botao_baixar_pdfActionPerformed(evt);
            }
        });
        jPanel1.add(Botao_baixar_pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 90, 30));

        titulo_da_tela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo_da_tela.setText("COMPRAS");
        jPanel1.add(titulo_da_tela, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 110, 40));

        botao_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/voltar.png"))); // NOI18N
        botao_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });
        jPanel1.add(botao_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 40));

        botaoFiltrar.setBackground(new java.awt.Color(0, 204, 153));
        botaoFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        botaoFiltrar.setText("Filtrar");
        botaoFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 90, 30));

        imagem_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        jPanel1.add(imagem_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

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

    private void Botao_baixar_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botao_baixar_pdfActionPerformed
        // TODO add your handling code here:
        
        String pdfPath = "RelatorioDeVendas.pdf";
        
        try{
            
            // criar o documento pdf
            Document documento = new Document();
            PdfWriter.getInstance(documento, new java.io.FileOutputStream(pdfPath));
           // abrir pdf 
           documento.open();
           
           // criando tabela no pdf
           // capturando a quantidade de colunas da minha tabela
           int colunas = tabela_compras.getColumnCount();
           // definindo a nossa tabela dentro do pdf
           PdfPTable tabela = new PdfPTable(colunas);
           // definindo a excala da tabela 100%, 80%, ou 50%
           tabela.setWidthPercentage(100);
           
           // adicionando o nome das colunas da tabela do pdf
           for(int i=0;i<colunas;i++){
               tabela.addCell(new Phrase(tabela_compras.getColumnName(i)));
           }//fim do for
           
           // adicionando os dados na tabela pdf
           DefaultTableModel modeloTabela = (DefaultTableModel) tabela_compras.getModel();
           
           // usando laço de repetição para inserir os dados
           for(int ln=0;ln<modeloTabela.getRowCount(); ln++){
               for(int c=0;c<modeloTabela.getColumnCount();c++){
                    // adicionando os dados dentro da tabela
                    Object valorcelula = modeloTabela.getValueAt(ln,c);
                    
                    tabela.addCell(valorcelula !=null ? valorcelula.toString():"");
                }// fim do 2º for
           }// fim do 1º for
           
           // adicionando a tabela dentro do pdf
           documento.add(tabela);
           
           // fechando o documento 
           documento.close();
           MensagensDialogo.mostrarSucesso("PDF GERADO COM SUCESSO!", "Sucesso");
           // abrir o pdf automaticamente
           
           File pdfFile = new File(pdfPath);
           if(pdfFile.exists()){
               if(Desktop.isDesktopSupported()){
                   
                   Desktop.getDesktop().open(pdfFile);
                   
               }else{
                   MensagensDialogo.mostrarErro("Não foi encontrado nenhum aplicativo com suporte para PDF","Erro");
                           
               }// fim do else
               
           }// fim do primeiro if
           
        }catch(Exception e){
            MensagensDialogo.mostrarErro("Não foi possível gerar o PDF", pdfPath);
        }// fim do try catch
    }//GEN-LAST:event_Botao_baixar_pdfActionPerformed

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltarActionPerformed

        
        // Voltar para a tela Home
        TelaHome home = new TelaHome(usuario);
        home.setVisible(true);
        dispose(); // Fecha a tela atual
        
    }//GEN-LAST:event_botao_voltarActionPerformed

    private void botaoFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFiltrarActionPerformed
        // TODO add your handling code here:
        // Pega os textos dos campos de filtro
        String dataInicio = (String) data_inicio.getSelectedItem();
        String dataFim = (String) data_fim.getSelectedItem();
        String nomeCliente = pesquisa_cliente.getText();
        
            // Se o usuário selecionou a opção padrão, o filtro não será aplicado para essa data
        if ("Todas as datas".equals(dataInicio)) {
            dataInicio = null;
        }
        if ("Todas as datas".equals(dataFim)) {
            dataFim = null;
        }

        ListagemVendasComFiltro(dataInicio, dataFim, nomeCliente);

        DefaultTableModel modeloTabela = (DefaultTableModel) tabela_compras.getModel();
        if (modeloTabela.getRowCount() == 0) {
            MensagensDialogo.mostrarAlerta("Nenhuma venda encontrada com os filtros selecionados!", "Aviso");
        }
    }//GEN-LAST:event_botaoFiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario user = null;
                new TelaCompras(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botao_baixar_pdf;
    private javax.swing.JButton botaoFiltrar;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JComboBox<String> data_fim;
    private javax.swing.JComboBox<String> data_inicio;
    private javax.swing.JLabel imagem_fundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_data_fim;
    private javax.swing.JLabel label_data_inicio;
    private javax.swing.JLabel nome_cliente;
    private javax.swing.JTextField pesquisa_cliente;
    private javax.swing.JTable tabela_compras;
    private javax.swing.JLabel titulo_da_tela;
    // End of variables declaration//GEN-END:variables
}
