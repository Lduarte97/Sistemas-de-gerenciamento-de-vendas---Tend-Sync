
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Clientes;
import model.ConexaoBancoDeDados;


/**
 *
 * @author Lucas Duarte
 */
public class ClientesController {
    
    public boolean cadastrarCliente(Clientes c){
        String query = " INSERT INTO Clientes (nome_cliente,cpf,email,telefone)"+"VALUES(?,?,?,?)";
        
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query))
        {
          // mandar os dados para  dentro do insert
          preparedStatement.setString(1,c.getNome_cliente());
          preparedStatement.setString(2,c.getCpf());
          preparedStatement.setString(3,c.getEmail());
          preparedStatement.setString(4,c.getTelefone());
          
          int cadastrou = preparedStatement.executeUpdate();
          return cadastrou>0;
            
       }catch(SQLException e){
            System.err.print("Erro ao cadastrar clientes"+e);
            return false;
        }// fim do catch
        
    }// Fim do método cadastrar clientes
    
    public List<Clientes> listarClientes(String nomecliente){
        List<Clientes> lista = new ArrayList<>();
        String query="SELECT * FROM Clientes WHERE nome_cliente LIKE ?;";
        
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)
        ){
            
            preparedStatement.setString(1,'%'+nomecliente+'%');
            ResultSet resultset = preparedStatement.executeQuery();
            
             // passando o valor do select para um objeto produto
            while(resultset.next()){
                Clientes cliente = new Clientes();
                cliente.setId_clientes(resultset.getInt("id_clientes"));
                cliente.setNome_cliente(resultset.getString("nome_cliente"));
                cliente.setCpf(resultset.getString("cpf"));
                cliente.setEmail(resultset.getString("email"));
                cliente.setTelefone(resultset.getString("telefone"));
                
                // jogando o produto dentro da lista
                lista.add(cliente);
            } // fim do while
            return lista;
            
            }catch(SQLException e){
             System.err.print("Erro ao Listar clientes"+e);
              return null;
        }// fim do try catch
        
       
    }// fim do método listarClientes
    
    // método para verificar se já existe um cliente cadastrado com o cpf informado no cadastro
    public boolean verificarCpfExistente(String cpf) {
    String query = "SELECT COUNT(*) FROM clientes WHERE cpf = ?";
    
    try (Connection connection = ConexaoBancoDeDados.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, cpf);
        
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                // Se a contagem for maior que 0, o CPF já existe
                return resultSet.getInt(1) > 0;
            }
        }// fim do try
        
    } catch (SQLException e) {
        System.err.println("Erro ao verificar CPF existente: " + e.getMessage());
    }// fim do catch
    return false; // Retorna falso em caso de erro
}// fim do verificarCpfExistente()
    
}// fim da classe ClientesController
