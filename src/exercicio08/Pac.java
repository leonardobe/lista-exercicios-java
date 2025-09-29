package exercicio08;

import java.math.BigDecimal;

class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return new BigDecimal("15.00");
    }
}