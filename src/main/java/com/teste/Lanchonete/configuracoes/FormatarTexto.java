package com.teste.Lanchonete.configuracoes;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class FormatarTexto {

    // Conjunto de palavras de ligação que não devem ser capitalizadas
    private static final Set<String> PALAVRAS_LIGACAO = new HashSet<>(Arrays.asList(
            "da", "de", "do", "das", "dos", "e", "em", "com", "um", "uma", "uns", "umas", "o", "a"
    ));

    public static String formatarTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto; // Retorna texto vazio ou nulo diretamente
        }

        // Divide o texto em palavras
        String[] palavras = texto.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        // Itera sobre cada palavra
        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i].toLowerCase(); // Coloca toda a palavra em minúscula

            // Se a palavra não for de ligação ou for a primeira palavra da frase, capitaliza
            if (!PALAVRAS_LIGACAO.contains(palavra) || i == 0) {
                palavra = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
            }

            // Adiciona a palavra ao resultado
            if (i > 0) {
                resultado.append(" ");
            }
            resultado.append(palavra);
        }
        return resultado.toString();
    }
}
