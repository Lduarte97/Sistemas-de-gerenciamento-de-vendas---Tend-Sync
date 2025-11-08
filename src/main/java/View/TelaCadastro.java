
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
import util.ValidadorCPF;
import util.ValidadorDataAntigo;
import util.ValidadorEmail;
import util.ValidadorNome;
import util.ValidadorSenha;

/**
 *
 * @author Lucas Duarte
 */
public class TelaCadastro extends javax.swing.JFrame {

    
    public TelaCadastro() {
        initComponents();
        ocultarsenha.setIcon(new ImageIcon(getClass().getResource("/img/ocultar.png")));
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

        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        campo_email = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        dataDeNascimento = new javax.swing.JLabel();
        botao_cadastrar = new javax.swing.JButton();
        cadastro_usuario = new javax.swing.JLabel();
        campo_data_nasc = new javax.swing.JFormattedTextField();
        campo_cpf = new javax.swing.JFormattedTextField();
        ocultarsenha = new javax.swing.JButton();
        campo_senha = new javax.swing.JPasswordField();
        botao_limpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        imagem_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(920, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 580));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nome.setForeground(new java.awt.Color(0, 0, 0));
        nome.setText("NOME");
        jPanel1.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 56, 26));

        campo_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(campo_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 400, 40));

        campo_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(campo_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 400, 40));

        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));
        email.setText("E-MAIL");
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 56, -1));

        cpf.setBackground(new java.awt.Color(255, 255, 255));
        cpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cpf.setForeground(new java.awt.Color(0, 0, 0));
        cpf.setText("CPF");
        jPanel1.add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 40, 26));

        senha.setBackground(new java.awt.Color(255, 255, 255));
        senha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        senha.setForeground(new java.awt.Color(0, 0, 0));
        senha.setText("SENHA");
        jPanel1.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 56, 26));

        dataDeNascimento.setBackground(new java.awt.Color(255, 255, 255));
        dataDeNascimento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dataDeNascimento.setForeground(new java.awt.Color(0, 0, 0));
        dataDeNascimento.setText("DATA NASC.");
        jPanel1.add(dataDeNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, 26));

        botao_cadastrar.setBackground(new java.awt.Color(51, 102, 255));
        botao_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        botao_cadastrar.setText("CADASTRAR");
        botao_cadastrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botao_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(botao_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 100, 35));

        cadastro_usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cadastro_usuario.setForeground(new java.awt.Color(0, 0, 0));
        cadastro_usuario.setText("CADASTRO DE USUÁRIO");
        jPanel1.add(cadastro_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        campo_data_nasc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            campo_data_nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campo_data_nasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_data_nascActionPerformed(evt);
            }
        });
        jPanel1.add(campo_data_nasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 130, 40));

        campo_cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            campo_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campo_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cpfActionPerformed(evt);
            }
        });
        jPanel1.add(campo_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 160, 40));

        ocultarsenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ocultar.png"))); // NOI18N
        ocultarsenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        ocultarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarsenhaActionPerformed(evt);
            }
        });
        jPanel1.add(ocultarsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 50, 40));

        campo_senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campo_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_senhaActionPerformed(evt);
            }
        });
        jPanel1.add(campo_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 350, 40));

        botao_limpar.setBackground(new java.awt.Color(204, 204, 204));
        botao_limpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botao_limpar.setForeground(new java.awt.Color(0, 0, 0));
        botao_limpar.setText("LIMPAR");
        botao_limpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botao_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparActionPerformed(evt);
            }
        });
        jPanel1.add(botao_limpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 100, 35));

        btnSair.setBackground(new java.awt.Color(204, 204, 204));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setText("SAIR");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 70, 40));

        imagem_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        imagem_fundo.setMaximumSize(new java.awt.Dimension(1080, 1));
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

    private void botao_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrarActionPerformed

        /*Validações dos campos de cadastro para não efetuar o cadastro caso alguns dos campos esteva vazio, além de 
        validações que asseguram que os dados sejam válidos
        */
        
        //Criação de variável para capturar o que é digitado no campo
        String nomeCompletoInformado = campo_nome.getText();
        //Primeira verificação: campo nome vazio
        if (nomeCompletoInformado.trim().isEmpty()){
            MensagensDialogo.mostrarAlerta("O campo Nome não pode estar vazio!", "Aviso");
            return;
        }else{
            //Validação campo de nome para verificar se é um nome válido chamando a classe ValidadorNome
            if (!ValidadorNome.isValidFullName(nomeCompletoInformado)) {
                String mensagemErro = "Por favor, insira um nome completo válido.\n" +
                                      "Requisitos:\n" +
                                      "- Deve conter um nome e pelo menos um sobrenome.\n" +
                                      "- Apenas letras, espaços, hífens e apóstrofos são permitidos.\n" +
                                      "Ex: João da Silva, Maria Antônia de Souza.";
            // Mensagem de diálogo personalizado da classe MensagensDialogo   
            MensagensDialogo.mostrarErro(mensagemErro, "Nome inválido");
            return; // Interrompe a execução
            }// fim di if
        }//fim do else
        
        //Criação de variável para capturar o que é digitado no campo
        String emailInformado = campo_email.getText();
        
        //Validação para verificar se o campo está vazio
        if (emailInformado.trim().isEmpty()) {
            MensagensDialogo.mostrarAlerta("O campo Email não pode estar vazio!", "Aviso");
            return; // Interrompe a execução
        }else{
            //Validação de email através da chamada da classe ValidadorEmail
            if (!ValidadorEmail.isValidEmail(emailInformado)) {
            String mensagemErro = "O e-mail informado não é válido.\n"+
                                  "Por favor, verifique o formato (ex: seu.email@dominio.com).";
            //Mensagem de erro personalisada chamada da classe MensagensDialogo
            MensagensDialogo.mostrarErro(mensagemErro, "E-mail inválido");
            return; // Interrompe a execução
            }//fim di if de validação de email válido
        }//fim do else
        
        //Criação de variável para capturar o que é digitado no campo
        String senhaInformada = new String(campo_senha.getPassword());
        
        // Verificação de campo vazio
        if (senhaInformada.trim().isEmpty()){
            MensagensDialogo.mostrarAlerta("O campo Senha não pode estar vazio!", "Aviso");
            return;
        }else {
            // Validação de senha que precisa de no mínimo 6 dígitos, uma letra maiúscula e um número
            if (!ValidadorSenha.isValidPassword(senhaInformada)){
            String mensagemErro = "A senha não atende aos requisitos de segurança: \n"+
                                  "- Mínimo de 6 caracteres\n" +
                                  "- Pelo menos uma letra maiúscula\n" +
                                  "- Pelo menos um número";
            MensagensDialogo.mostrarErro(mensagemErro,"Senha inválida!");
            return; // Interrompe a execução
            }//fim do if
        
        }//fim do else
        
        //Criação de variável para capturar o que é digitado no campo
        String cpfInformado = campo_cpf.getText();
        
        //Verificação de campo vazio
        if (cpfInformado.trim().isEmpty()){
            MensagensDialogo.mostrarAlerta("O campo Senha não pode estar vazio!", "Aviso");
            return;
        }else{
            
            //Verificando se o cpf informado é válido através da chamada da classe ValidadorCPF
            if (!ValidadorCPF.isValidCPF(cpfInformado)){
            String mensagemErro = "O CPF informado não é válido.\n"+
                                  "Por favor, verifique o  número ou digite um CPF válido.";
            // Mensagen de erro personalizada chamada da classe MensagensDialogo
            MensagensDialogo.mostrarErro(mensagemErro, "CPF inválido");
            return;
            }//fim do if 
            
            //Verificação se o CPF já está cadastrado no sistema 
            UsuarioController controller = new UsuarioController();
            if (controller.verificarCpfExistente(cpfInformado)){
                MensagensDialogo.mostrarAlerta("O CPF informado já está cadastrado para outro usuário!", "CPF Duplicado");
                return;
            }// fim do if
        }//fim do else
        
        // Obtenha a data de nascimento do campo de texto
        String dataNascimentoInformada = campo_data_nasc.getText();

        // PRIMEIRA VERIFICAÇÃO: Campo vazio?
        if (dataNascimentoInformada.trim().isEmpty()) {
            MensagensDialogo.mostrarAlerta("O campo data de nascimento não pode ser vazio!", "Campo vazio");
            return; // Interrompe a execução
        }//fim do if

        // SEGUNDA VERIFICAÇÃO: Valida o formato, idade e limites da data
        // Certifique-se de importar a classe ValidadorDataAntigo (ex: import seu.pacote.base.util.ValidadorDataAntigo;)
        if (!ValidadorDataAntigo.isValidBirthDate(dataNascimentoInformada)) {
            String mensagemErro = "A Data de Nascimento informada não é válida.\n" +
                                  "Verifique os requisitos:\n" +
                                  "- Formato: DD/MM/AAAA (ex: 25/07/2000)\n" +
                                  "- Você deve ter no mínimo 18 anos.\n" +
                                  "- Não pode ser uma data futura ou muito antiga (mais de 100 anos atrás).";
            MensagensDialogo.mostrarErro(mensagemErro, "Data de nascimento inválida!");
            return; // Interrompe a execução
        }
        
        try{
        UsuarioController controller = new UsuarioController();
        
        //Configurando o formato da data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        
        // Convertendo o texto do campo em um objeto java.util.Date
        java.util.Date utilDate =  formato.parse(campo_data_nasc.getText());
         
        // Convertendo java.util.Date para java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date (utilDate.getTime());
        
       
        Usuario user = new Usuario(
                campo_nome.getText(), 
                campo_email.getText(),
                
                new String (campo_senha.getPassword()),
                campo_cpf.getText(),
                
                sqlDate
        );
        controller.cadastrandoUsuario(user);
        MensagensDialogo.mostrarSucesso("Usuário cadastrado com sucesso!","Cadastro Realizado");
        // Abre a tela de login após cadastrar
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        // fechar tela de cadastro
        dispose();
        
        }catch(Exception e){
          MensagensDialogo.mostrarErro("Usuário não cadastrado! Detalhes: " + e.getMessage(),"Erro no Cadastro");
        }//fim do catch
    }//GEN-LAST:event_botao_cadastrarActionPerformed

    private void campo_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_senhaActionPerformed
    // variável que verifica se e senha está oculta ou não
    boolean oculto=true;
    private void ocultarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarsenhaActionPerformed
        // se senha estiver oculta
        
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

    private void campo_data_nascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_data_nascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_data_nascActionPerformed

    private void campo_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cpfActionPerformed

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        // TODO add your handling code here:
        campo_nome.setText("");
        campo_email.setText("");
        campo_cpf.setText("");
        campo_data_nasc.setText("");
        campo_senha.setText("");
        
    }//GEN-LAST:event_botao_limparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       // Criação da variável que recebe a resposta do usuário e chama a mensagem de diálogo personalizada
        int resposta = MensagensDialogo.mostrarPergunta(
            "Deseja cancelar o cadastro e sair?",
            "Confirmação",
            JOptionPane.OK_CANCEL_OPTION // Tipo de botões que você quer: OK e Cancelar
        );

        // Verifica a resposta do usuário
        if (resposta == JOptionPane.OK_OPTION) {
            // Voltar para a tela Home
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
            dispose(); // Fecha a tela atual
        }
        // Caso clique em "Cancelar", nada acontece
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_cadastrar;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel cadastro_usuario;
    private javax.swing.JFormattedTextField campo_cpf;
    private javax.swing.JFormattedTextField campo_data_nasc;
    private javax.swing.JTextField campo_email;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JLabel cpf;
    private javax.swing.JLabel dataDeNascimento;
    private javax.swing.JLabel email;
    private javax.swing.JLabel imagem_fundo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nome;
    private javax.swing.JButton ocultarsenha;
    private javax.swing.JLabel senha;
    // End of variables declaration//GEN-END:variables
}
