import java.util.InputMismatchException;
import java.util.Scanner;

public class PesquisaHabitantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Digite o número de habitantes: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    throw new IllegalArgumentException("O número de habitantes deve ser maior que zero.");
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scanner.next(); // Limpa a entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double somaSalarios = 0;
        int somaFilhos = 0;
        double maiorSalario = 0;

        for (int i = 1; i <= n; i++) {
            boolean validSalario = false;
            boolean validFilhos = false;
            double salario = 0;
            int numeroFilhos = 0;

            while (!validSalario) {
                try {
                    System.out.println("Habitante " + i + ":");
                    System.out.print("Digite o salário: ");
                    salario = scanner.nextDouble();
                    if (salario < 0) {
                        throw new IllegalArgumentException("O salário não pode ser negativo.");
                    }
                    validSalario = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número válido para o salário.");
                    scanner.next(); // Limpa a entrada inválida
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (!validFilhos) {
                try {
                    System.out.print("Digite o número de filhos: ");
                    numeroFilhos = scanner.nextInt();
                    if (numeroFilhos < 0) {
                        throw new IllegalArgumentException("O número de filhos não pode ser negativo.");
                    }
                    validFilhos = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro para o número de filhos.");
                    scanner.next(); // Limpa a entrada inválida
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            somaSalarios += salario;
            somaFilhos += numeroFilhos;

            if (salario > maiorSalario) {
                maiorSalario = salario;
            }
        }

        double mediaSalarios = somaSalarios / n;
        double mediaFilhos = (double) somaFilhos / n;

        System.out.printf("Média de salários: %.2f%n", mediaSalarios);
        System.out.printf("Média de número de filhos: %.2f%n", mediaFilhos);
        System.out.printf("Maior salário: %.2f%n", maiorSalario);

        scanner.close();
    }
}
