package exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite o nome do produto: ");
            String nome = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            double preco = sc.nextDouble();

            System.out.print("Digite a quantidade em estoque: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nome, preco, quantidade);
            produto.exibirInfo();

            System.out.print("Digite a porcentagem de desconto: ");
            double desconto = sc.nextDouble();

            produto.aplicarDesconto(desconto);

            System.out.println("Após aplicar desconto:");
            produto.exibirInfo();

        } catch (DescontoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }

        sc.close();
    }
}

