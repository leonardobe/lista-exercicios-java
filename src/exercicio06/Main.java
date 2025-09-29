/*Crie o objeto de valor imutável Dinheiro (valor BigDecimal e enum Moeda)com equals/hashCode coerentes. Modele Produto, ItemCarrinho e um Carrinho cuja lista de itens seja imutável: operações de adicionar/remover/aplicar cupom retornam um novo carrinho. Valide quantidades > 0, proíba valores negativos e limite cupons a 30% com arredondamento bancário. Demonstre o fluxo completo em testes.*/
package exercicio06;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Carrinho carrinhoOriginal = new Carrinho(Collections.emptyList());
        Carrinho carrinhoAtual = carrinhoOriginal; // referência ao carrinho em uso

        while (true) {
            System.out.println("\n===== MENU CARRINHO =====");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Exibir carrinho atual");
            System.out.println("4. Aplicar cupom");
            System.out.println("5. Remover cupom (voltar ao original)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            try {
                switch (opcao) {
                    case 1: {
                        System.out.print("Nome do produto: ");
                        String nome = sc.nextLine();

                        System.out.print("Preço do produto: ");
                        BigDecimal preco = new BigDecimal(sc.nextLine());

                        System.out.print("Quantidade: ");
                        int quantidade = Integer.parseInt(sc.nextLine());

                        Produto p = new Produto(nome, new Dinheiro(preco, Moeda.BRL));
                        carrinhoOriginal = carrinhoOriginal.adicionarItem(p, quantidade);
                        carrinhoAtual = carrinhoOriginal;
                        System.out.println("Item adicionado com sucesso!");
                        break;
                    }
                    case 2: {
                        System.out.print("Nome do produto a remover: ");
                        String nome = sc.nextLine();
                        carrinhoOriginal = carrinhoOriginal.removerItem(nome);
                        carrinhoAtual = carrinhoOriginal;
                        System.out.println("Item removido (se existia)!");
                        break;
                    }
                    case 3: {
                        System.out.println("\nCarrinho atual (hash=" + carrinhoAtual.hashCode() + "):");
                        System.out.println(carrinhoAtual);
                        break;
                    }
                    case 4: {
                        System.out.print("Digite o valor do cupom (%): ");
                        BigDecimal cupom = new BigDecimal(sc.nextLine());
                        carrinhoAtual = carrinhoOriginal.aplicarCupom(cupom);
                        System.out.println("Cupom aplicado com sucesso!");
                        break;
                    }
                    case 5: {
                        carrinhoAtual = carrinhoOriginal;
                        System.out.println("Cupom removido. Voltando ao carrinho original.");
                        break;
                    }
                    case 6:
                        System.out.println("Saindo...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
