
package model;

/**
 *
 * @author Lucas Duarte
 */
public class Clientes {
    
    int id_clientes;
    String nome_cliente;
    String cpf;
    String email;
    String telefone;
    
    // Criando o primeiro construtor(que obriga o objeto a ser criado já com os dados)
    public Clientes (String nome_cliente, String cpf, String email, String telefone){
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }//fim do primeiro construtor
    
    //Criação do segundo construtor
    public Clientes(int id_clientes, String nome_cliente, String cpf, String email, String telefone) {
        this.id_clientes = id_clientes;
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }// fim do segundo construtot

    // Criação do terceiro construtor, esse vazio
    public Clientes(){
        
    }// fim do terceiro construtor
    
    
    // Criação dos getters e setters
    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
}// final da classe Clientes
