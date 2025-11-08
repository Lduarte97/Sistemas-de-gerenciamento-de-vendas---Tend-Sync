/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Pattern;

/**
 *
 * @author lldua
 */
public class ValidadorNome {
    public static boolean isValidFullName(String fullName) {
        // 1. Remover espaços extras no início e fim
        fullName = fullName.trim();

        // 2. Verifica se o nome não está vazio após remover espaços extras
        if (fullName.isEmpty()) {
            return false; // Nome vazio é inválido
        }

        // 3. Verifica se tem pelo menos um nome e um sobrenome
        // Divide o nome por espaços. Considera nomes como "Maria Silva" ou "João Pedro Costa"
        String[] parts = fullName.split("\\s+"); // Divide por um ou mais espaços
        if (parts.length < 2) {
            // Se tiver menos de 2 partes (apenas nome, ou nome composto sem sobrenome), é inválido
            return false;
        }

        // 4. Verifica se contém apenas letras, espaços e, opcionalmente, hífens ou apóstrofos para nomes compostos
        // [a-zA-Z\u00C0-\u00FF] inclui letras acentuadas comuns em português
        // \\s permite espaços, - permite hífens, ' permite apóstrofos (ex: D'Angelo)
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\u00C0-\\u00FF'\\s-]*$");
        if (!namePattern.matcher(fullName).matches()) {
            return false; // Contém caracteres inválidos (números, símbolos estranhos)
        }

        // 5. Tentativa de impedir sequências aleatórias (heuristicamente)
        // Isso é mais difícil de ser 100% eficaz, mas podemos tentar:
        // Verifica se há pelo menos uma sequência de 3 consoantes ou 3 vogais consecutivas (indicador de aleatoriedade)
        // Ou se o nome tem menos de 3 caracteres por parte (ex: "A B") - já coberto pelo length < 2 acima.
        // Uma heurística mais simples é verificar se há muitas consoantes ou vogais juntas que não formam palavras comuns.
        // Para "jrfberkhge", ele tem sequências de consoantes e vogais estranhas.
        // Podemos ser mais rigorosos aqui. Por exemplo, evitar 3 ou mais consoantes seguidas não separadas por vogais
        // ou 3 ou mais vogais seguidas (exceto em casos como "Uruguai", "Paraguai").
        // No entanto, para uma validação simples, a regex acima (apenas letras) já ajuda bastante.
        // Para uma verificação mais robusta contra "jrfberkhge":
        // Podemos verificar se cada 'parte' do nome (nome, sobrenome) parece um nome.
        // Exemplo: cada parte deve ter pelo menos 2 letras e não pode ter 3 consoantes seguidas.
        
        // Exemplo de verificação simples para partes do nome:
        for (String part : parts) {
            if (part.length() < 2) { // Partes do nome muito curtas (ex: "A. Silva")
                return false;
            }
            // Adicionalmente, podemos usar uma regex para verificar padrões "estranhos" em cada parte
            // Ex: "jrfberkhge" pode ser detectado se não houver um padrão de vogais/consoantes típico.
            // Para simplicidade, a regex principal (item 4) já resolve a maioria dos casos de caracteres inválidos.
            // Para padrões aleatórios, seria necessário um dicionário ou algoritmos mais complexos.
            // Por enquanto, a combinação de (nome e sobrenome) + (apenas letras) é o mais eficaz.
        }

        return true; // Se passou por todas as verificações, o nome é considerado válido
    }
}
