
package model;

import java.sql.Date;

/**
 *
 * @author Lucas Duarte
 */
public class Usuario {
   private int id; 
    private String email;
    private String senha;
    private String cpf;
    private String nome;
    private Date dataNascimento;
    
    // Exemplo de criação de objeto, ex;
    
    // Usuario objusuario = new Usuario();
    
    // Criando um construtor(que obriga o objeto a ser criado já com os dados)
    public Usuario (String nome, String email, String senha, String cpf, Date data_nascimento){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = data_nascimento;
    }// final construtor

    //Criação do segundo construtor de forma automática, da mesma maneira do getter e setter
    public Usuario(int id, String email, String senha, String cpf, String nome,
            Date dataNascimento) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }// final do segundo construtor
    
    // Criação do terceiro construtor sem parãmetros
    Usuario(){
        
    }// final do terceiro construtor
    
    /*Para gerar getters e setters de forma automática basta clicar om o botão 
    direito no espaço vazio e com o botão direito>> insert code>>
    getter and setter, selecionar as variáveis >> generate>> ok
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
}
