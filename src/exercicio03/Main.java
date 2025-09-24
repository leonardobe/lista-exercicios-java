/*Crie a classe base Funcionario com protected String nome e protected BigDecimal salario (com getters). Crie Gerente e Desenvolvedor que sobrescrevem calcularBonus(): 20% do salário para gerente e 10% para desenvolvedor. Garanta que salários sejam positivos. Em um programa, coloque diferentes funcionários em uma coleção do tipo List<Funcionario> e exiba o bônus de cada um.*/
package exercicio03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Quantos funcionários deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtd; i++) {
            System.out.println("\n--- Cadastro do funcionário " + (i + 1) + " ---");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Salário: ");
            BigDecimal salario = sc.nextBigDecimal();
            sc.nextLine();

            System.out.print("Cargo (1 = Gerente, 2 = Desenvolvedor): ");
            int cargo = sc.nextInt();
            sc.nextLine();

            try {
                if (cargo == 1) {
                    funcionarios.add(new Gerente(nome, salario));
                } else if (cargo == 2) {
                    funcionarios.add(new Desenvolvedor(nome, salario));
                } else {
                    System.out.println("Cargo inválido.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
        }

        System.out.println("\n--- Lista de Funcionários e Bônus ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome()
                    + " | Salário: R$ " + f.getSalario()
                    + " | Bônus: R$ " + f.calcularBonus());
        }

        sc.close();
    }
}
