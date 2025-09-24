package exercicio05;

import java.math.BigDecimal;

public abstract class FormaPagamento {
    public abstract void validarPagamento() throws PagamentoInvalidoException;

    public abstract void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException;
}

