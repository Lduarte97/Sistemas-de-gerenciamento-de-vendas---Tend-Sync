
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas Duarte
 */
public class ValidadorNomeProduto {
    
    // Regex para validar nomes de produtos.
    // Permite letras (incluindo acentuadas), números, espaços, hífens e apóstrofos.
    // A validação exige que a string tenha pelo menos 2 caracteres não numéricos e não especiais
    private static final String NOME_PRODUTO_REGEX = "^[a-zA-ZÀ-ÿ\\s'-]{2,}(?:\\s[a-zA-ZÀ-ÿ\\s'-]+)*$";
    private static final Pattern NOME_PRODUTO_PATTERN = Pattern.compile(NOME_PRODUTO_REGEX);

    public static boolean isValidProductName(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = NOME_PRODUTO_PATTERN.matcher(nome.trim());
        return matcher.matches();
    }// fim do isValidProductName
    
}// fim da classe
