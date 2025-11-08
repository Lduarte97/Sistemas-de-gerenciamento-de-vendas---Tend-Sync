
package Controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConexaoBancoDeDados;
import model.Produtos;

public class ProdutosController {
    
    public boolean cadastrandoProduto(Produtos produto){
        // comando do banco de dados para inserir 
        /* Os pontos de interrogação serão trocados pelos dados que o usuário
        irá inserir */
     
        String query = "INSERT INTO Produtos (nome_prod,estoque,preco,tamanho)"
               + "VALUES(?,?,?,?);";
               
        // Connection : conecta-se ao banco de dados
        // PreparedStatement : manda o comando sql para executar no Banco de DD
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query))
        {
          // mandar os dados para  dentro do insert
          preparedStatement.setString(1,produto.getNome_prod());
          preparedStatement.setInt(2, produto.getEstoque());
          preparedStatement.setFloat(3, produto.getPreco());
          preparedStatement.setInt(4, produto.getTamanho());
   
          
          // verifica se o insert foi executado
          int rowsAffected = preparedStatement.executeUpdate();
          return rowsAffected > 0;
          
        }catch(SQLException e){
            //imprimindo erro que deu ao inserir o produto
            System.err.print("Erro ao inserir Dados!"+ e);
            // return para indicar que o produto não foi cadastrado
            return false;
        }// final do try catch
        
        
    }// fim do metodo cadastrandoproduto()
    
    public List<Produtos> listarProdutos(){
        String query = "SELECT * FROM Produtos;";
        // criando uma lista para capturar os dados do select
        List<Produtos> lista = new ArrayList<>();

        // Criando o try catch

        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query);
        ResultSet resultset = preparedStatement.executeQuery() ){
            
            // passando o valor do select para um objeto produto
            while(resultset.next()){
                Produtos produto = new Produtos();
                produto.setId_produto(resultset.getInt("id_produto"));
                produto.setNome_prod(resultset.getString("nome_prod"));
                produto.setEstoque(resultset.getInt("estoque"));
                produto.setPreco(resultset.getFloat("preco"));
                produto.setTamanho(resultset.getInt("tamanho"));
                
                // jogando o produto dentro da lista
                lista.add(produto);
                
            }// fim do while
          return lista;  
            
        }catch(SQLException e){
            System.err.print("Erro ao listar produtos"+e);
            return null;
        }//fim do catch
        
    }//fim dolistarProdutos()
    
    // criando metodo de editar produtos
    public boolean editarProdutos(Produtos produto) throws SQLException{
      String query = "UPDATE Produtos SET nome_prod=?,estoque=?,preco=?,tamanho=?"+ "WHERE id_produto=?;";
      
      try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
        
          preparedStatement.setString(1,produto.getNome_prod());
          preparedStatement.setInt(2,produto.getEstoque());
          preparedStatement.setFloat(3,produto.getPreco());
          preparedStatement.setInt(4,produto.getTamanho());
          preparedStatement.setInt(5,produto.getId_produto());
          
          int cadastrou = preparedStatement.executeUpdate();
          return cadastrou > 0;
          
      }catch(SQLException e){
          System.err.print("Erro ao atualizar o produto"+e);
      }//fim do try catch
      return false;
    }//Fim do metódo editar
    
    public boolean excluirProdutos(int idproduto){
        String query = "DELETE FROM Produtos WHERE id_produto=?;";
        
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
           preparedStatement.setInt(1, idproduto);
           
           int excluir = preparedStatement.executeUpdate();
           return excluir > 0;
           
        }catch(SQLException e){
            System.err.print("Erro ao excluir produto! "+e);
            return false;
        }//fim do catch
        
    }// fim do método de excluir
    
    public List<Produtos> listarProdutosNome(String nome){
        String query ="SELECT * FROM Produtos WHERE nome_prod LIKE ?;";
        
        List<Produtos> lista = new ArrayList<>();

        // Criando o try catch

        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
            preparedStatement.setString(1, '%'+nome+'%');
            ResultSet resultset = preparedStatement.executeQuery();
            
            // passando o valor do select para um objeto produto
            while(resultset.next()){
                Produtos produto = new Produtos();
                produto.setId_produto(resultset.getInt("id_produto"));
                produto.setNome_prod(resultset.getString("nome_prod"));
                produto.setEstoque(resultset.getInt("estoque"));
                produto.setPreco(resultset.getFloat("preco"));
                produto.setTamanho(resultset.getInt("tamanho"));
                
                // jogando o produto dentro da lista
                lista.add(produto);
                
            }// fim do while
          return lista;  
            
        }catch(SQLException e){
            System.err.print("Nenhum produto encontrado!"+e);
                return null;
        }// fim do try catch
        
        
    }// fim do método listarProdutosNome()
            
}// fim da classe ProdutosController

    
