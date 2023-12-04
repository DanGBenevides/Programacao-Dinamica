// Classe que representa um item da mochila
public class Item {
    public int id;
    public int peso;
    public int valor;

    public Item(int id, int peso, int valor) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return this.peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return this.valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

}
