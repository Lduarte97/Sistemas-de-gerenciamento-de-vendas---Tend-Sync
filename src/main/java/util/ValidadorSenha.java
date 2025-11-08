/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author lldua
 */
public class ValidadorSenha {
    public static boolean isValidPassword(String password) {
        // 1. Verifica se a senha tem no mínimo seis caracteres
        if (password.length() < 6) {
            return false;
        }

        // 2. Verifica se a senha contém pelo menos uma letra maiúscula
        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase) {
            return false;
        }

        // 3. Verifica se a senha contém pelo menos um número
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            return false;
        }

        // Se todas as condições forem atendidas, a senha é válida
        return true;
    }
    
}
