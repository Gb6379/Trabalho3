import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class CalcularPrecoProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar os produtos
        List<Produto> produtos = new ArrayList<>();

        // Função lambda para ler cod do produto
        Supplier<Integer> lerCodigoProduto = () -> {
            while (true) {
                System.out.print("Digite o código do produto (para sair digite codigo negativo): ");
                try {
                    int codigo = scanner.nextInt();
                    if (codigo < 0) {
                        return null; // Retorna null para sair do loop
                    }
                    return codigo;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }
        };

        // Função lambda para ler preço de custo do produto
        Supplier<Double> lerPrecoCusto = () -> {
            while (true) {
                System.out.print("Digite o preço de custo do produto: ");
                try {
                    return scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número válido.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }
        };

        // Leitura dos produtos
        while (true) {
            Integer codigo = lerCodigoProduto.get();
            if (codigo == null) {
                break; // Sai do loop se o código for negativo
            }

            double precoCusto = lerPrecoCusto.get();
            double novoPreco = precoCusto * 1.2; // Aumento de 20%

            // Armazena o produto na lista
            produtos.add(new Produto(codigo, novoPreco));
        }

        // Exibição dos produtos e cálculo da média dos preços novos
        double somaPrecos = 0;
        System.out.println("\nCódigo do Produto | Novo Preço");
        System.out.println("-----------------|------------");
        for (Produto produto : produtos) {
            System.out.printf("%17d | R$ %.2f%n", produto.getCodigo(), produto.getNovoPreco());
            somaPrecos += produto.getNovoPreco();
        }

        double mediaPrecos = somaPrecos / produtos.size();
        System.out.printf("Média dos preços novos: R$ %.2f%n", mediaPrecos);

        scanner.close();
    }
}

// Classe Produto para armazenar código e novo preço
class Produto {
    private int codigo;
    private double novoPreco;

    public Produto(int codigo, double novoPreco) {
        this.codigo = codigo;
        this.novoPreco = novoPreco;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getNovoPreco() {
        return novoPreco;
    }
}