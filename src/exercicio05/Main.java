/*Implemente a classe abstrata FormaPagamento com validarPagamento() e processarPagamento(BigDecimal valor). Crie CartaoCredito, Boleto e Pix com validações específicas (ex.: número do cartão, formato de boleto, chave Pix). Simule o uso de cada forma por polimorfismo e trate erros de validação com exceções específicas (ex.: PagamentoInvalidoException).*/
package exercicio05;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FormaPagamento pagamento = null;

        try {
            System.out.println("=== Sistema de Pagamentos ===");
            System.out.print("Digite o valor do pagamento: R$ ");
            BigDecimal valor = sc.nextBigDecimal();
            sc.nextLine(); // limpar buffer

            System.out.println("\nEscolha a forma de pagamento:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Boleto");
            System.out.println("3 - Pix");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o número do cartão (16 dígitos): ");
                    String numeroCartao = sc.nextLine();
                    pagamento = new CartaoCredito(numeroCartao);
                }
                case 2 -> {
                    System.out.print("Digite o código de barras do boleto (47 dígitos): ");
                    String codigoBarras = sc.nextLine();
                    pagamento = new Boleto(codigoBarras);
                }
                case 3 -> {
                    System.out.print("Digite a chave Pix (CPF, e-mail ou UUID): ");
                    String chavePix = sc.nextLine();
                    pagamento = new Pix(chavePix);
                }
                default -> throw new IllegalArgumentException("Opção inválida!");
            }

            if (pagamento != null) {
                pagamento.processarPagamento(valor);
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Digite apenas números onde for solicitado.");
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

