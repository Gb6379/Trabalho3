import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

public class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Função para ler código do aluno
        Supplier<Integer> lerCodigoAluno = () -> {
            while (true) {
                System.out.print("Digite o código do aluno: ");
                try {
                    return scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }
        };

        // Função para ler nota
        Supplier<Double> lerNota = () -> {
            while (true) {
                //System.out.print("Digite a nota: ");
                try {
                    return scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número válido.");
                    scanner.next();
                }
            }
        };

        // Laço
        for (int i = 1; i <= 5; i++) {
            int codigoAluno = lerCodigoAluno.get();
            System.out.println("\nAluno " + codigoAluno);


            System.out.print("Digite a primeira nota: ");
            double nota1 = lerNota.get();
            System.out.print("Digite a segunda nota: ");
            double nota2 = lerNota.get();
            System.out.print("Digite a terceira nota: ");
            double nota3 = lerNota.get();

            // Calculo da média ponderada
            double maiorNota = Math.max(nota1, Math.max(nota2, nota3));
            double mediaPonderada;

            if (maiorNota == nota1) {
                mediaPonderada = (nota1 * 4 + nota2 * 3 + nota3 * 3) / 10;
            } else if (maiorNota == nota2) {
                mediaPonderada = (nota1 * 3 + nota2 * 4 + nota3 * 3) / 10;
            } else {
                mediaPonderada = (nota1 * 3 + nota2 * 3 + nota3 * 4) / 10;
            }

            // Exibição dos resultados
            System.out.println("Código do aluno: " + codigoAluno);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
            System.out.printf("Média Ponderada: %.2f%n", mediaPonderada);

            if (mediaPonderada >= 5) {
                System.out.println("Status: Aprovado");
            } else {
                System.out.println("Status: Reprovado");
            }
        }

        scanner.close();
    }
}
