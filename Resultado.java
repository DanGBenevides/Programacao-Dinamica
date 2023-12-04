import java.util.ArrayList;
import java.util.Set;

// Classe para armazenar o resultado da mochila
public class Resultado {
    int valorMaximo;
    Set<Integer> itensSelecionados;
    ArrayList<Integer> respGul = new ArrayList<Integer>();

    Resultado(int valorMaximo, Set<Integer> itensSelecionados) {
        this.valorMaximo = valorMaximo;
        this.itensSelecionados = itensSelecionados;
    }

    Resultado(int valorMaximo, ArrayList<Integer> respGul) {
        this.valorMaximo = valorMaximo;
        this.respGul = respGul;
    }
}