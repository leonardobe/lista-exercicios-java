/*
* Defina a interface IMeioTransporte com acelerar() e frear(). Implemente Carro, Bicicleta e Trem, cada um com lógica própria de variação de velocidade e limites. No método principal, crie uma lista de IMeioTransporte, percorra e invoque acelerar()/frear() demonstrando polimorfismo. Trate operações inválidas com exceções apropriadas.
*/
package exercicio04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IMeioTransporte transporte = null;

        try {
            System.out.println("Escolha um meio de transporte:");
            System.out.println("1 - Carro");
            System.out.println("2 - Bicicleta");
            System.out.println("3 - Trem");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> transporte = new Carro();
                case 2 -> transporte = new Bicicleta();
                case 3 -> transporte = new Trem();
                default -> throw new IllegalArgumentException("Opção inválida de transporte!");
            }

            int comando;
            do {
                System.out.println("\nDigite uma ação:");
                System.out.println("1 - Acelerar");
                System.out.println("2 - Frear");
                System.out.println("0 - Sair");

                comando = sc.nextInt();

                switch (comando) {
                    case 1 -> {
                        if (transporte == null) throw new IllegalStateException("Nenhum transporte selecionado!");
                        transporte.acelerar();
                    }
                    case 2 -> {
                        if (transporte == null) throw new IllegalStateException("Nenhum transporte selecionado!");
                        transporte.frear();
                    }
                    case 0 -> System.out.println("Encerrando programa...");
                    default -> throw new IllegalArgumentException("Comando inválido!");
                }
            } while (comando != 0);

        } catch (InputMismatchException e) {
            System.out.println("Erro: Você deve digitar apenas números!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}



