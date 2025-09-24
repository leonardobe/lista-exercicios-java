package exercicio05;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (chavePix == null || chavePix.isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix não pode ser vazia!");
        }
        if (!(chavePix.matches("\\d{11}") || chavePix.contains("@") || chavePix.matches("[a-fA-F0-9\\-]{36}"))) {
            throw new PagamentoInvalidoException("Chave Pix inválida! Deve ser CPF, e-mail ou UUID.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " realizado via Pix para a chave: " + chavePix);
    }
}
