// Trabalho 4 - Programação Dinâmica
// Comparação de Algoritmos para o Problema da Mochila 0/1
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 02/12/2023

import java.util.HashSet;
import java.util.Set;

public class Dinamica {
    // Classe para armazenar o resultado da mochila através da programação dinâmica
    public Resultado mochila(int tamMochila, int[] ids, int[] pesos, int[] valores, int n) {
        // Inicializa a matriz de valores
        int[][] V = new int[n + 1][tamMochila + 1];

        // Inicializa a primeira linha e a primeira coluna com 0
        for (int i = 0; i <= tamMochila; i++) {
            V[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            V[i][0] = 0;
        }

        // Preenche a matriz de valores
        for (int i = 1; i <= n; i++) {
            // Preenche a linha
            for (int j = 1; j <= tamMochila; j++) {
                // Verifica se o item cabe na mochila
                if (pesos[i - 1] <= j) {
                    // Verifica se o item vale mais que o item anterior
                    if ((valores[i - 1] + V[i - 1][j - pesos[i - 1]]) > V[i - 1][j]) {
                        V[i][j] = valores[i - 1] + V[i - 1][j - pesos[i - 1]];
                    } 
                    // Se não, pega o valor do item anterior
                    else {
                        V[i][j] = V[i - 1][j];
                    }
                } 
                else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }       

        Set<Integer> itensSelecionados = new HashSet<>();
        int i = n, j = tamMochila;
        // Pega os itens selecionados
        while (i > 0 && j > 0) {
            if (V[i][j] != V[i-1][j]) {
                itensSelecionados.add(i);
                j = j - pesos[i-1];
            }
            i--;
        }

        return new Resultado(V[n][tamMochila], itensSelecionados);
    }
}
