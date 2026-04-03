import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens = new ArrayList<>();

    // Atributo static para contar quantos pedidos foram finalizados no sistema
    public static int totalPedidosGeral = 0;

    public void adicionar(Produto p) {
        itens.add(p);
        System.out.println(p.getNome() + " adicionado ao carrinho!");
    }

    public void listar() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        System.out.println("--- Itens no Carrinho ---");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(i + " - " + itens.get(i).getNome() + " (R$ " + itens.get(i).getPreco() + ")");
        }
    }

    public void remover(int index) {
        if (index >= 0 && index < itens.size()) {
            System.out.println(itens.get(index).getNome() + " removido.");
            itens.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }
}