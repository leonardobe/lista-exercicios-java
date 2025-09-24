package exercicio06;

import java.util.Collections;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrinho carrinho = new Carrinho(Collections.emptyList());

        try {
            System.out.print("Digite o nome do produto: ");
            String nome = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            BigDecimal preco = sc.nextBigDecimal();

            System.out.print("Digite a quantidade: ");
            int quantidade = sc.nextInt();

            Produto p = new Produto(nome, new Dinheiro(preco, Moeda.BRL));
            carrinho = carrinho.adicionarItem(p, quantidade);

            System.out.println(carrinho);

            System.out.print("Digite o valor do cupom de desconto (%): ");
            BigDecimal cupom = sc.nextBigDecimal();

            carrinho = carrinho.aplicarCupom(cupom);
            System.out.println("Carrinho após desconto:");
            System.out.println(carrinho);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
