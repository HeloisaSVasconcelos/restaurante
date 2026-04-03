public class Produto {
    private String nome;
    private double preco;

    // Construtor para inicializar o produto
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters para encapsulamento
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}