/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author lldua
 */
public class ValidadorCPF {
    public static boolean isValidCPF(String cpf) {
        // Remove caracteres não numéricos (pontos e traços)
        cpf = cpf.replace(".", "").replace("-", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (ex: 111.111.111-11 é inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Converte o CPF para um array de inteiros
            int[] digitos = new int[11];
            for (int i = 0; i < 11; i++) {
                digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
            }

            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += digitos[i] * (10 - i);
            }
            int primeiroDigitoVerificador = 11 - (soma % 11);
            if (primeiroDigitoVerificador > 9) {
                primeiroDigitoVerificador = 0;
            }

            // Verifica o primeiro dígito verificador
            if (primeiroDigitoVerificador != digitos[9]) {
                return false;
            }

            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += digitos[i] * (11 - i);
            }
            int segundoDigitoVerificador = 11 - (soma % 11);
            if (segundoDigitoVerificador > 9) {
                segundoDigitoVerificador = 0;
            }

            // Verifica o segundo dígito verificador
            if (segundoDigitoVerificador != digitos[10]) {
                return false;
            }

            return true; // CPF válido
        } catch (NumberFormatException e) {
            // Caso a string do CPF contenha caracteres não numéricos após a limpeza inicial
            return false;
        }
    }
    
}
