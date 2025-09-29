/*Modele CalculadoraFrete com calcular(Pedido): BigDecimal. Crie estratégias Sedex, Pac e RetiradaNaLoja e permita injeção/troca da estratégia no Pedido. Acrescente uma estratégia promocional via lambda (frete grátis acima de X). Valide CEP/região e dispare exceções para CEP inválido. Mostre a troca de estratégia em tempo de execução.*/
package exercicio08;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pedido pedidoAtual = null;
        boolean rodando = true;
        String tipoFrete = " ";

        while (rodando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar novo pedido");
            System.out.println("2. Escolher estratégia de frete (pedido atual)");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o valor total do pedido: ");
                        BigDecimal valor = sc.nextBigDecimal();
                        sc.nextLine();
                        System.out.print("Digite o CEP (8 dígitos): ");
                        String cep = sc.nextLine();

                        pedidoAtual = new Pedido(valor, cep, new Pac());
                        System.out.println("Novo pedido criado: " + pedidoAtual);
                        tipoFrete = "Frete Pac";
                    }
                    case 2 -> {
                        if (pedidoAtual == null) {
                            System.out.println("Nenhum pedido criado ainda!");
                            break;
                        }
                        boolean subMenu = true;
                        while (subMenu) {
                            System.out.println("\n=== MENU FRETE ===");
                            System.out.println("Pedido atual: " + pedidoAtual);
                            System.out.println("1. Usar PAC");
                            System.out.println("2. Usar SEDEX");
                            System.out.println("3. Usar Retirada na Loja");
                            System.out.println("4. Usar Frete Promocional (Grátis acima de R$200)");
                            System.out.println("0. Voltar");
                            System.out.print("Escolha a opção: ");

                            int opcaoFrete = sc.nextInt();
                            sc.nextLine();

                            switch (opcaoFrete) {
                                case 1 -> {
                                    pedidoAtual.setEstrategiaFrete(new Pac());
                                    tipoFrete = "Frete Pac";
                                }
                                case 2 -> {
                                    pedidoAtual.setEstrategiaFrete(new Sedex());
                                    tipoFrete = "Frete Sedex";
                                }
                                case 3 -> {
                                    pedidoAtual.setEstrategiaFrete(new RetiradaNaLoja());
                                    tipoFrete = "Retire na Loja";
                                }
                                case 4 -> {
                                    tipoFrete = "Frete Promocional";
                                    pedidoAtual.setEstrategiaFrete(p -> {
                                    if (p.getValorTotal().compareTo(new BigDecimal("200")) > 0) {
                                        return BigDecimal.ZERO;
                                    }
                                    return new BigDecimal("20.00");
                                });
                                }
                                case 0 -> subMenu = false;
                                default -> {
                                    System.out.println("Opção inválida!");
                                    continue;
                                }
                            }

                            if (opcaoFrete != 0) {
                                BigDecimal frete = pedidoAtual.calcularFrete();
                                System.out.println(tipoFrete + pedidoAtual + ": R$ " + frete);
                            }
                        }
                    }
                    case 0 -> {
                        rodando = false;
                        System.out.println("Saindo...");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (CepInvalidoException | IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        sc.close();
    }
}