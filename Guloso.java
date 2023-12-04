// Trabalho 4 - Programação Dinâmica
// Comparação de Algoritmos para o Problema da Mochila 0/1
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 02/12/2023

import java.util.ArrayList;

class Guloso {
    // Classe para armazenar o resultado da mochila através do algoritmo guloso
    public Resultado guloso(int tamMochila, int[] ids, int[] pesos, int[] valores) {
        // Ordena os itens pelo valor em ordem decrescente
        quicksort(0, pesos.length - 1, ids, pesos, valores);
        
        int valorTotal = 0;

        ArrayList<Integer> resp = new ArrayList<Integer>();
        int pesoRestante = tamMochila;

        // Coloca os itens na mochila enquanto houver espaço
        for (int i = 0; i < pesos.length; i++) {
            if (pesoRestante - pesos[i] >= 0) {
                valorTotal += valores[i];
                resp.add(ids[i]);
                pesoRestante -= pesos[i];
            }
        }

        Resultado resultado = new Resultado(valorTotal, resp);

        return resultado;
    }

    // Algoritmo de ordenação quicksort
    public static void quicksort(int esq, int dir, int[] itens, int[] pesos, int[] valores) {
        int i = esq, j = dir;
        int pivo = valores[(dir + esq) / 2];
        while (i <= j) {
            while (valores[i] > pivo) i++;
            while (valores[j] < pivo) j--;
            if (i <= j) {
                swap(i, j, itens, pesos, valores);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j, itens, pesos, valores);
        if (i < dir)  quicksort(i, dir, itens, pesos, valores);
    }
    
    public static void swap(int i, int j, int[] itens, int[] pesos, int[] valores) {
        int aux = valores[i];
        valores[i] = valores[j];
        valores[j] = aux;
    
        aux = pesos[i];
        pesos[i] = pesos[j];
        pesos[j] = aux;
    
        aux = itens[i];
        itens[i] = itens[j];
        itens[j] = aux;
    }
}