package exercicio08;

import java.math.BigDecimal;

class RetiradaNaLoja implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}