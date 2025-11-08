
package model;

/**
 *
 * @author Lucas Duarte
 */
import java.util.Date;

public class Vendas {
    
    private int id_vendas;
    private int id_clientes;
    private int id_produto;
    private int id_vendedor;
    private String formadepagamento;
    private float valor;
    // Alteração: O tipo de dado para a data agora é java.util.Date
    private Date datavenda; 
    private int quantidade;
    
    // Construtor completo
    public Vendas(int id_vendas, int id_clientes, int id_produto, int id_vendedor, String formadepagamento, float valor, Date datavenda, int quantidade) {
        this.id_vendas = id_vendas;
        this.id_clientes = id_clientes;
        this.id_produto = id_produto;
        this.id_vendedor = id_vendedor;
        this.formadepagamento = formadepagamento;
        this.valor = valor;
        this.datavenda = datavenda;
        this.quantidade = quantidade;
    }
    
    // Construtor sem o id_vendas (para cadastrar novas vendas)
    public Vendas(int id_clientes, int id_produto, int id_vendedor, String formadepagamento, float valor, Date datavenda, int quantidade) {
        this.id_clientes = id_clientes;
        this.id_produto = id_produto;
        this.id_vendedor = id_vendedor;
        this.formadepagamento = formadepagamento;
        this.valor = valor;
        this.datavenda = datavenda;
        this.quantidade = quantidade;
    }

    // Construtor vazio
    public Vendas() {
    }
    
    // Getters e setters
    public int getId_vendas() {
        return id_vendas;
    }
    
    public void setId_vendas(int id_vendas) {
        this.id_vendas = id_vendas;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento(String formadepagamento) {
        this.formadepagamento = formadepagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    // Alteração: O getter e setter agora usam java.util.Date
    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}