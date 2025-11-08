 
package model;


public class Produtos {
    int id_produto;
    String nome_prod;
    int estoque;
    float preco;
    int tamanho;

    // Construtor vazio
    public Produtos(){}
    
    // Construtor com todas as informações

    public Produtos(int id_produto, String nome_prod, int estoque, float preco, int tamanho) {
        this.id_produto = id_produto;
        this.nome_prod = nome_prod;
        this.estoque = estoque;
        this.preco = preco;
        this.tamanho = tamanho;
    }
    // Construtor sem o id, já que ele é gerado automaticamente

    public Produtos(String nome_prod, int estoque, float preco, int tamanho) {
        this.nome_prod = nome_prod;
        this.estoque = estoque;
        this.preco = preco;
        this.tamanho = tamanho;
    }
    
    
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    
}
