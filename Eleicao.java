import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

public class Eleicao {


    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int[] votos = new int[7]; // Array para contar votos (índices 1-6 usados)

            // Lambda para leitura de votos com tratamento de exceções
            Consumer<String> lerVotos = (mensagem) -> {
                while (true) {
                    System.out.print(mensagem);
                    try {
                        int codigoVoto = scanner.nextInt();

                        if (codigoVoto == 0) {
                            break;
                        }

                        if (codigoVoto >= 1 && codigoVoto <= 6) {
                            votos[codigoVoto]++;
                        } else {
                            System.out.println("Código de voto inválido. Tente novamente.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Por favor, insira um número.");
                        scanner.next(); // Limpa a entrada inválida
                    }
                }
            };

            lerVotos.accept("(1) - candidato A\n(2) - Candidato B\n(3) - Candidato C\n(4) - Candidato D\n(5) - Nulo\n(6) - Branco:\n(0) - Sair\n\n Compute seu Voto: ");


            System.out.println("Resultado da Eleição:");
            System.out.println("Total de votos para o Candidato A: " + votos[1]);
            System.out.println("Total de votos para o Candidato B: " + votos[2]);
            System.out.println("Total de votos para o Candidato C: " + votos[3]);
            System.out.println("Total de votos para o Candidato D: " + votos[4]);
            System.out.println("Total de votos nulos: " + votos[5]);
            System.out.println("Total de votos em branco: " + votos[6]);

            scanner.close();
        }
    }
