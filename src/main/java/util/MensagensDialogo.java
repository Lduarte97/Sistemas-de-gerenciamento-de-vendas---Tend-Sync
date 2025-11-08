package util;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.net.URL; // Necessário para getClass().getResource()

public class MensagensDialogo {

    // --- Ícones personalizados ---
    // É crucial que esses caminhos estejam corretos no seu classpath.
    // Assumimos que as imagens estão em 'src/main/java/img/' ou 'src/main/resources/img/'
    private static final ImageIcon ICON_SUCESSO;
    private static final ImageIcon ICON_ERRO;
    private static final ImageIcon ICON_ALERTA; // Um ícone para avisos/alertas
    private static final ImageIcon ICON_PERGUNTA; 

    // Bloco estático para inicializar os ícones uma única vez
    static {
        ICON_SUCESSO = carregarIcone("/img/sucesso.png"); // Caminho do seu ícone de sucesso
        ICON_ERRO = carregarIcone("/img/erro.png");    // Caminho do seu ícone de negação/erro
        ICON_ALERTA = carregarIcone("/img/aviso.png"); 
        ICON_PERGUNTA = carregarIcone("/img/question.png");
                                                         // Se não tiver, use null para usar o padrão do JOptionPane
    }

    // Método auxiliar para carregar ícones com tratamento de erro
    private static ImageIcon carregarIcone(String path) {
        URL imageUrl = MensagensDialogo.class.getResource(path);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            System.err.println("Erro: Ícone não encontrado no caminho: " + path);
            return null; // Retorna null se o ícone não for encontrado
        }
    }

    // --- Métodos de exibição de mensagens ---

    /**
     * Exibe uma mensagem de sucesso com ícone personalizado.
     * @param mensagem O texto da mensagem a ser exibido.
     * @param titulo O título da janela da mensagem.
     */
    public static void mostrarSucesso(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo,
                JOptionPane.INFORMATION_MESSAGE, ICON_SUCESSO);
    }

    /**
     * Exibe uma mensagem de erro com ícone personalizado.
     * @param mensagem O texto da mensagem a ser exibido.
     * @param titulo O título da janela da mensagem.
     */
    public static void mostrarErro(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo,
                JOptionPane.ERROR_MESSAGE, ICON_ERRO);
    }

    /**
     * Exibe uma mensagem de alerta/aviso com ícone personalizado.
     * @param mensagem O texto da mensagem a ser exibido.
     * @param titulo O título da janela da mensagem.
     */
    public static void mostrarAlerta(String mensagem, String titulo) {
        // Se ICON_ALERTA for null (não encontrado), JOptionPane usará seu ícone de aviso padrão.
        JOptionPane.showMessageDialog(null, mensagem, titulo,
                JOptionPane.WARNING_MESSAGE, ICON_ALERTA);
    }
    
    public static int mostrarPergunta(String mensagem, String titulo, int tipoBotoes) {
        // Se ICON_ALERTA for null (não encontrado), JOptionPane usará seu ícone de aviso padrão.
        return JOptionPane.showConfirmDialog(null, mensagem, titulo,
              tipoBotoes,  JOptionPane.QUESTION_MESSAGE, ICON_PERGUNTA);
    }
    
    public static int mostrarConfirmacaoSimNao(String mensagem, String titulo){
        return mostrarPergunta(mensagem, titulo, JOptionPane.YES_NO_OPTION);
    }
    

    // Você pode adicionar mais métodos conforme a necessidade, por exemplo:
    // public static void mostrarConfirmacao(String mensagem, String titulo) { ... }
}

