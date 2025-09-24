package exercicio05;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (codigoBarras == null || codigoBarras.length() != 47 || !codigoBarras.matches("\\d+")) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido! Deve conter 47 dígitos numéricos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " registrado via boleto. Código: " + codigoBarras.substring(0, 5) + "...");
    }
}

