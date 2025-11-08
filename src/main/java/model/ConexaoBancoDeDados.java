
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas Duarte
 */
// Toda conexão com banco de dados vai usar essa classe, só muda o nome do banco
public class ConexaoBancoDeDados {
    
    private static final String URL=
            "jdbc:sqlserver://localhost:1433;databaseName=Loja;"
            + "integratedSecurity=true;"
            + "trustServerCertificate=true";
    public static Connection getConnection(){
        // criando um objeto de tipo Connection
        Connection conection = null;
        // try/ catch é como se fosse um if else, só que para erros no sistema
        
        try{// se não der erro nenhum
            // estabeleça a conexão com o banco de dados
            conection = DriverManager.getConnection(URL);
            System.out.println("Conexão bem sucedida!");
        }catch (SQLException e){/* caso dê algum erro. SQLException captura o erro e 
            joga ele na variável "e", que é chamada no print para mostrar ao 
            usuário qual é o erro */
            System.out.println("Erro de conexão!"+e);
        }
        return conection;
        
    }// final do getConnection
    
}// final do public class
