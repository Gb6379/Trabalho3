import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

public class Contagem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Função lambda para ler um número inteiro
        Supplier<Integer> lerNumero = () -> {
            while (true) {
                try {
                    return scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }
        };

        // Contadores para cada intervalo
        int intervalo1 = 0; // [0, 25]
        int intervalo2 = 0; // [26, 50]
        int intervalo3 = 0; // [51, 75]
        int intervalo4 = 0; // [76, 100]

        // Lendo 10 números
        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o número " + i + ": ");
            int numero = lerNumero.get();

            // Contando os números nos intervalos
            if (numero >= 0 && numero <= 25) {
                intervalo1++;
            } else if (numero >= 26 && numero <= 50) {
                intervalo2++;
            } else if (numero >= 51 && numero <= 75) {
                intervalo3++;
            } else if (numero >= 76 && numero <= 100) {
                intervalo4++;
            } else {
                System.out.println("Número fora dos intervalos considerados.");
            }
        }

        // Exibindo os resultados
        System.out.println("Contagem dos números nos intervalos:");
        System.out.println("[0, 25]: " + intervalo1);
        System.out.println("[26, 50]: " + intervalo2);
        System.out.println("[51, 75]: " + intervalo3);
        System.out.println("[76, 100]: " + intervalo4);

        scanner.close();
    }
}
