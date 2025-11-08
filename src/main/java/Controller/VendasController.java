
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConexaoBancoDeDados;
import model.RelatorioVendas;
import model.Vendas; 

public class VendasController {
    
    public boolean cadastrarVendas(Vendas venda) {
        String query ="INSERT INTO Vendas (id_clientes,id_produto,id_vendedor,"
                + "formadepagamento,valor,datavenda,quantidade)VALUES (?,?,?,?,?,?,?)";
        
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
        
            preparedStatement.setInt(1,venda.getId_clientes());
            preparedStatement.setInt(2,venda.getId_produto());
            preparedStatement.setInt(3,venda.getId_vendedor());
            preparedStatement.setString(4,venda.getFormadepagamento());
            preparedStatement.setFloat(5,venda.getValor());
            preparedStatement.setDate(6, new java.sql.Date(venda.getDatavenda().getTime()));
            preparedStatement.setInt(7,venda.getQuantidade());
            
            int cadastrou = preparedStatement.executeUpdate();
            return cadastrou>=0;
            
        }catch(SQLException e){
             System.err.print("Erro ao cadastrar Venda! "+e);
             return false;
        }//fim do catch
    }// fim do cadastrarVendas
    
    public List<RelatorioVendas> listarVendasComFiltro(java.util.Date dataInicio, java.util.Date dataFim, String nomeCliente) {
        StringBuilder query = new StringBuilder(
            "SELECT c.nome_cliente as Cliente, p.nome_prod as Produto, u.nome as Vendedor, v.quantidade as Quantidade, "
            + "v.valor as Preco, v.datavenda as DataVenda "
            + "FROM Vendas v "
            + "INNER JOIN Clientes c ON v.id_clientes = c.id_clientes "
            + "INNER JOIN Usuario u ON v.id_vendedor = u.id "
            + "INNER JOIN Produtos p ON v.id_produto = p.id_produto "
            + "WHERE 1=1 "
        );
        
        List<RelatorioVendas> lista = new ArrayList<>();

        if (dataInicio != null) {
            query.append(" AND v.datavenda >= ? ");
        }
        if (dataFim != null) {
            query.append(" AND v.datavenda <= ? ");
        }
        if (nomeCliente != null && !nomeCliente.isEmpty()) {
            query.append(" AND c.nome_cliente LIKE ? ");
        }
        
        query.append(" ORDER BY v.datavenda DESC");

        try (Connection conection = ConexaoBancoDeDados.getConnection();
             PreparedStatement preparedStatement = conection.prepareStatement(query.toString())) {
            
            int parameterIndex = 1;

            if (dataInicio != null) {
                preparedStatement.setDate(parameterIndex++, new java.sql.Date(dataInicio.getTime()));
            }
            if (dataFim != null) {
                preparedStatement.setDate(parameterIndex++, new java.sql.Date(dataFim.getTime()));
            }
            if (nomeCliente != null && !nomeCliente.isEmpty()) {
                preparedStatement.setString(parameterIndex++, "%" + nomeCliente + "%");
            }
            
            try (ResultSet resultset = preparedStatement.executeQuery()) {
                while (resultset.next()) {
                    RelatorioVendas vendas = new RelatorioVendas();
                    vendas.setNomeCliente(resultset.getString("Cliente"));
                    vendas.setNomeProduto(resultset.getString("Produto"));
                    vendas.setNomeVendedor(resultset.getString("Vendedor"));
                    vendas.setQuantidade(resultset.getInt("Quantidade"));
                    vendas.setPreco(resultset.getFloat("Preco"));
                    java.sql.Date sqlDate = resultset.getDate("DataVenda");
                    if (sqlDate != null) {
                        vendas.setDataVenda(new java.util.Date(sqlDate.getTime()));
                    } else {
                        vendas.setDataVenda(null);
                    }//fim do else
                    lista.add(vendas);
                }//fim do wile
            }//fim do try
            return lista;
            
        } catch (SQLException e) {
            System.err.print("Erro ao listar vendas: " + e.getMessage());
            return null;
        }// fim do catch
    }//fim do ListarVendascomFiltro
    
    public List<RelatorioVendas> listarTodasAsVendas() {
        return listarVendasComFiltro(null, null, null);
    }//fim do listarTodasasvendas
    
    public List<java.util.Date> listarDatasDeVenda() {
        String query = "SELECT DISTINCT datavenda FROM Vendas ORDER BY datavenda";
        List<java.util.Date> datas = new ArrayList<>();
        
        try (Connection connection = ConexaoBancoDeDados.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                datas.add(resultSet.getDate("datavenda"));
            }//fim do while
            
        } catch (SQLException e) {
            System.err.print("Erro ao listar datas de vendas: " + e.getMessage());
        }//fim do catch
        return datas;
    }//fim do ListarDatasDeVendas
}// fim do VendasController