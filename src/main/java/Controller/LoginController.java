
package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConexaoBancoDeDados;
import model.Usuario;

/**
 *
 * @author Lucas Duarte
 */
public class LoginController {
    
    public Usuario authenticate(String email,String senha) {
        /* Foi criado uma variável com o nome de query que recebe o método de 
        de seleção do banco de dados, onde ele vai selecionar todos os registros
        da tabela, no caso, usuário, e verificar se o email e senha digitados 
        existe no banco de dados */
        String query = "SELECT * FROM usuario WHERE email = ? AND senha =?";
            // Conexão com o banco de dados
        try (Connection connection = ConexaoBancoDeDados.getConnection();
            // Mandar o comando select para ser executado no Banco de dados
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            /*Parâmetros que vão substituir os pontos de interrogação da variável
            query em ordem, email para o 1º ponto e senha para o 2º ponto, se 
            se fosse mais pontos de interrogação seria preparedStatement.setString
            .set(tipo da variável)(3, variável) */
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            
            // Método ResultSet recebe o returno do comando sql da variável query 
            try(ResultSet resultSet = preparedStatement.executeQuery() ){
                if(resultSet.next()){
                  // retorna o valor que ele recebeu do banco de dados
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String senhausuario = resultSet.getString("senha");
                String emailusuario = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                Date data = resultSet.getDate("data_nascimento");
                // mandando o usuário para tela de login
                
                
                return new Usuario(id, emailusuario, senhausuario, cpf, nome,data);  
                }//fim do if
            }// fim do try
        }catch (SQLException e){
            System.err.println("Erro ao autenticar o usuario: "+ e.getMessage());
            return null;
        }// fim do catch
        return null;
    
    }// fim do authenticate
}// fim da classe loginController