package exercicio08;

import java.math.BigDecimal;

class Sedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("30.00");
    }
}
