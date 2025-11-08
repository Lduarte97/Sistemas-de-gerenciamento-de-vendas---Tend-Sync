
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConexaoBancoDeDados;

import model.Usuario;

/**
 *
 * @author devmat
 */
public class UsuarioController {
    
    // Criando metodo de inseriri usuario no banco de dados
    // metodo para verificar se o usuário está ou não cadastrado no BD
    
    public boolean cadastrandoUsuario(Usuario user){
        // comando do banco de dados para inserir 
        /* Os pontos de interrogação serão trocados pelos dados que o usuário
        irá inserir */
     
        String query = "INSERT INTO Usuario (nome,cpf,senha,email,data_nascimento)"
               + "VALUES(?,?,?,?,?);";
               
        // Connection : conecta-se ao banco de dados
        // PreparedStatement : manda o comando sql para executar no Banco de DD
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query))
        {
          // mandar os dados para  dentro do insert
          preparedStatement.setString(1,user.getNome());
          preparedStatement.setString(2, user.getCpf());
          preparedStatement.setString(3, user.getSenha());
          preparedStatement.setString(4, user.getEmail());
          preparedStatement.setDate(5, user.getDataNascimento());
          
          // verifica se o insert foi executado
          int rowsAffected = preparedStatement.executeUpdate();
          return rowsAffected > 0;
          
        }catch(SQLException e){
            //imprimindo erro que deu ao inserir usuário
            System.err.print("Erro ao inserir Dados!"+ e);
            // return para indicar que o usuário não foi cadastrado
            return false;
        }// final do try catch
        
        
    }// fim do metodo cadastrandousuario()
    
    // método para verificar se o usuário que está sendo cadastrado já tem o cpf cadastrado, se sim ele breca o cadastro
    public boolean verificarCpfExistente(String cpf) {
    // A query agora verifica o CPF na tabela de usuarios
    String query = "SELECT COUNT(*) FROM usuarios WHERE cpf = ?";
    
    try (Connection connection = ConexaoBancoDeDados.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, cpf);
        
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                // Se a contagem for maior que 0, o CPF já existe
                return resultSet.getInt(1) > 0;
               }
            }
        
        } catch (SQLException e) {
            System.err.println("Erro ao verificar CPF existente na tabela de usuários: " + e.getMessage());
        }
    return false; // Retorna falso em caso de erro
    }
    
    public boolean atualizarUsuario(Usuario user){
        // Comando SQL para atualizar o usuário
        String query = "UPDATE Usuario SET nome =?,senha=?, email =?, data_nascimento =? WHERE cpf = ?;";
        
        try(Connection conection = ConexaoBancoDeDados.getConnection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
        
            // Configurando os valores dos campos
          preparedStatement.setString(1,user.getNome());
          preparedStatement.setString(2, user.getSenha());
          preparedStatement.setString(3, user.getEmail());
          preparedStatement.setDate(4, user.getDataNascimento());
          preparedStatement.setString(5, user.getCpf());
          
          // Executa o comando e verifica se houve alterações
          int rowsAffected = preparedStatement.executeUpdate();
          return rowsAffected > 0;
          
        }catch(SQLException e){
            //imprime o erro no console
            System.err.print("Erro ao atualizar Dados!"+ e);
            // return para indicar que o usuário não foi cadastrado
            return false;
        }
    }  
    
    public boolean deletarUsuario(int idusuario) throws SQLException{
        String query ="DELETE FROM Usuario WHERE id_cliente = ?;";
        
        // conectando ao banco de dados e mandando o comando delete
        try(Connection conection = ConexaoBancoDeDados.getConnection();
            PreparedStatement preparedstatement = conection.prepareStatement(query)){
            
           // mandando o idusuario para dentro do comando sql 
           preparedstatement.setInt(1,idusuario);
           
           // Verifica se o delete foi concluído
          int resultado = preparedstatement.executeUpdate();
          return resultado > 0;
           
        }catch(SQLException e){
            System.err.print("Exclusão não realizada!"+e);
            return false;
        }
    }
    
}// final da classe UsuarioController
