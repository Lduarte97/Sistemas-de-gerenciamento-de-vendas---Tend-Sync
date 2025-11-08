
package model;

import java.util.Date;

/**
 *
 * @author Lucas Duarte
 */

public class RelatorioVendas {
    private String nomeCliente;
    private String nomeVendedor;
    private String nomeProduto;
    private int quantidade;
    private float preco;
    
    // O atributo já estava correto
    private Date dataVenda;

    // Construtor completo corrigido:
    // 1. O tipo de 'dataVenda' foi corrigido para 'Date' (com 'D' maiúsculo).
    // 2. O parâmetro 'preco' foi adicionado para inicializar todos os atributos.
    public RelatorioVendas(String nomeCliente, String nomeVendedor, String nomeProduto, int quantidade, float preco, Date dataVenda) {
        this.nomeCliente = nomeCliente;
        this.nomeVendedor = nomeVendedor;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataVenda = dataVenda;
    }

    // Construtor vazio
    public RelatorioVendas() {
    }

    // Getters e Setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    // AQUI ESTÁ A CORREÇÃO PRINCIPAL:
    // O getter retorna um objeto do tipo 'Date'
    public Date getDataVenda() {
        return dataVenda;
    }

    // O setter recebe um objeto do tipo 'Date', não 'String'
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}