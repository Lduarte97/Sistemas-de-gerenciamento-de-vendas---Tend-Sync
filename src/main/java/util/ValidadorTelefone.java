/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lldua
 */
public class ValidadorTelefone {
    
    // Regex para validar números de telefone no padrão brasileiro.
    // Permite formatos como:
    // (DD) 9XXXX-XXXX
    // (DD) XXXX-XXXX
    // DD9XXXX-XXXX
    // DDXXXX-XXXX
    // A regex lida com ou sem parênteses, com ou sem espaço e com ou sem o hífen.
    private static final String TELEFONE_REGEX =
            "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[19])\\)?\\s?(?:9[1-9]|9\\d|[2-9])\\d{3}-?\\d{4}$";
    
    private static final Pattern pattern = Pattern.compile(TELEFONE_REGEX);

    /**
     * Valida um número de telefone no formato brasileiro.
     * @param telefone O número de telefone a ser validado (pode conter parênteses, espaços e hífens).
     * @return true se o número de telefone for válido, false caso contrário.
     */
    public static boolean isValidTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return false; // Telefone nulo ou vazio não é válido
        }
        
        // Remove parênteses, espaços e hífens antes de validar com a regex
        String telefoneFormatado = telefone.replaceAll("[^0-9]", "");

        // A regex não lida com o 9 adicional dos telefones móveis,
        // então é mais fácil remover o 9 e validar o restante.
        // Ou podemos usar uma regex mais flexível. A regex acima já é flexível.
        
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }
    
}
