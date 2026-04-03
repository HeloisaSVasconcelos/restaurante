import java.util.Scanner;

public class Main {
    // Constantes final para credenciais de login
    private static final String USUARIO_CORRETO = "admin";
    private static final String SENHA_CORRETA = "123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean autenticado = false;

        // 1. Tela de Login
        while (!autenticado) {
            System.out.println("--- LOGIN SISTEMA ---");
            System.out.print("Usuário: ");
            String user = sc.nextLine();
            System.out.print("Senha: ");
            String pass = sc.nextLine();

            if (user.equals(USUARIO_CORRETO) && pass.equals(SENHA_CORRETA)) {
                autenticado = true;
                System.out.println("Login bem-sucedido!\n");
            } else {
                System.out.println("Credenciais inválidas! Tente novamente ou digite 'sair'.");
                if (user.equalsIgnoreCase("sair")) return;
            }
        }

        // 2. Cardápio e Carrinho
        Carrinho meuCarrinho = new Carrinho();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- CARDÁPIO ---");
            System.out.println("1) Adicionar Cachorro-Quente (R$ 15,00)");
            System.out.println("2) Adicionar Sushi (R$ 45,00)");
            System.out.println("3) Adicionar Pizza (R$ 40,00)");
            System.out.println("4) Adicionar Baguncinha (R$ 20,00)");
            System.out.println("5) Gerenciar Carrinho / Finalizar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> meuCarrinho.adicionar(new Produto("Cachorro-Quente", 15.0));
                case 2 -> meuCarrinho.adicionar(new Produto("Sushi", 45.0));
                case 3 -> meuCarrinho.adicionar(new Produto("Pizza", 40.0));
                case 4 -> meuCarrinho.adicionar(new Produto("Baguncinha", 20.0));
            }
        }

        // 3. Gestão de Carrinho (Inclusão, Consulta, Exclusão)
        int acaoCarrinho = 0;
        while (acaoCarrinho != 3) {
            meuCarrinho.listar();
            System.out.println("\nTotal: R$ " + meuCarrinho.calcularTotal());
            System.out.println("1) Remover Item | 2) Adicionar Mais | 3) Finalizar Pedido");
            acaoCarrinho = sc.nextInt();

            if (acaoCarrinho == 1) {
                System.out.print("Digite o índice para remover: ");
                int idx = sc.nextInt();
                meuCarrinho.remover(idx);
            } else if (acaoCarrinho == 2) {
                System.out.println("Retornando ao cardápio...");
                main(args); // Reinicia o fluxo para adicionar mais
                return;
            }
        }

        System.out.println("Pedido finalizado! Obrigado.");
        sc.close();
    }
}