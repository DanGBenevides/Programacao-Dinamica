// Trabalho 4 - Programação Dinâmica
// Comparação de Algoritmos para o Problema da Mochila 0/1
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 02/12/2023

import java.io.BufferedReader;
import java.io.FileReader;

// Classe principal
class TP4 {
    public static void main(String[] args) throws Exception{
        FileReader arq = new FileReader("Testes/teste100.txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine();
        int qtdItens = Integer.parseInt(linha);
        linha = lerArq.readLine();
        int tamMochila = Integer.parseInt(linha);

        int[] ids = new int[qtdItens];
        int[] idsDin = new int[qtdItens];

        int[] pesos = new int[qtdItens];
        int[] pesosDin = new int[qtdItens];

        int[] valores = new int[qtdItens];
        int[] valoresDin = new int[qtdItens];
        
        // Lê os itens do arquivo
        int i = 0;
        while((linha = lerArq.readLine()) != null) {
            String[] dados = linha.split(" ");

            ids[i] = Integer.parseInt(dados[0]);
            idsDin[i] = Integer.parseInt(dados[0]);

            pesos[i] = Integer.parseInt(dados[1]);
            pesosDin[i] = Integer.parseInt(dados[1]);

            valores[i] = Integer.parseInt(dados[2]);
            valoresDin[i] = Integer.parseInt(dados[2]);

            i++;
        }
        arq.close();

        Guloso gul = new Guloso();

        long tempoInicialGuloso = System.nanoTime();
        Resultado respGul = gul.guloso(tamMochila, ids, pesos, valores);
        long tempoFinalGuloso = System.nanoTime();


        System.out.println("Resposta do algoritmo Guloso:");
        System.out.println("Valor total: " + respGul.valorMaximo);
        System.out.println("Itens escolhidos: ");
        for (int j = 0; j < respGul.respGul.size(); j++) {
            System.out.print(respGul.respGul.get(j) + " ");
        }
        System.out.println("\nTempo de execucao: " + (tempoFinalGuloso - tempoInicialGuloso) / 1000000.0 + "ms");

        Dinamica din = new Dinamica();

        long tempoInicialDinamica = System.nanoTime();
        Resultado respDin = din.mochila(tamMochila, idsDin, pesosDin, valoresDin, qtdItens);
        long tempoFinalDinamica = System.nanoTime();

        System.out.println("\nResposta do algoritmo de Programacao Dinamica:");
        System.out.println("Valor total: " + respDin.valorMaximo);
        System.out.println("Itens escolhidos: ");
        for (int j = 0; j < respDin.itensSelecionados.size(); j++) {
            System.out.print(respDin.itensSelecionados.toArray()[j] + " ");
        }
        System.out.println("\nTempo de execucao: " + (tempoFinalDinamica - tempoInicialDinamica) / 1000000.0 + "ms");
    }
}