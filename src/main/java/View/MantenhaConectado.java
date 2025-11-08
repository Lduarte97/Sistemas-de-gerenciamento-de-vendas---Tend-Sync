package View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream; // Adicionar este import
import java.util.Properties;

public class MantenhaConectado {
    // Nome do arquivo de configuração
    private static final String CONFIG_FILE_NAME = "config.properties";
    // Caminho onde o arquivo será SALVO e LIDO no sistema de arquivos
    // (Isso será no diretório onde o JAR é executado, ou na raiz do projeto em desenvolvimento)
    private static final String CONFIG_FILE_PATH = CONFIG_FILE_NAME; 

    public static void salvarLogin(String user, String password) {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE_PATH)) {
            Properties prop = new Properties();
            prop.setProperty("usuario", user);
            prop.setProperty("senha", password);
            prop.store(fos, "Configurações de login salvo");
            System.out.println("Login salvo em: " + new File(CONFIG_FILE_PATH).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao salvar o login: " + e.getMessage());
            e.printStackTrace();
        }//fim do catch
        
    }//fim do salvarLogin

    public static String[] carregarLogin() {
        Properties prop = new Properties();
        // Primeiro, tenta carregar do CLASSPATH (útil se o arquivo estiver no JAR)
        try (InputStream input = MantenhaConectado.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME)) {
            if (input != null) {
                prop.load(input);
                System.out.println("Login carregado do classpath.");
            } else {
                // Se não encontrou no classpath, tenta carregar do sistema de arquivos
                // (Onde 'salvarLogin' o teria criado)
                File file = new File(CONFIG_FILE_PATH);
                if (file.exists()) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        prop.load(fis);
                        System.out.println("Login carregado do sistema de arquivos.");
                    }// fim do try
                } else {
                    System.out.println("Arquivo de configuração para login não encontrado em nenhum local. Primeiro acesso ou não salvo.");
                    return null; // Retorna null se o arquivo não existe
                }//fim do 2º else
            }// fim do 1º else

            String user = prop.getProperty("usuario");
            String password = prop.getProperty("senha");

            if (user != null && password != null) {
                return new String[]{user, password};
            }// fim do if
        } catch (IOException e) {
            System.err.println("Erro ao carregar o login: " + e.getMessage());
            e.printStackTrace();
        }// fim do catch
        return null;
    }// fim do CarregarLogin

    public static void limparLogin() {
        File file = new File(CONFIG_FILE_PATH);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Arquivo de login limpo com sucesso.");
            } else {
                System.err.println("Não foi possível limpar o arquivo de login.");
            }//fim do else
        } else {
            System.out.println("Arquivo de login não encontrado para limpeza.");
        }// fim do else
    }// fim do limparlogin
}// fim da classe Mantenha conectado