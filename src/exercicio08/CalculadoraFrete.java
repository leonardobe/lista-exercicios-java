package exercicio08;

import java.math.BigDecimal;

@FunctionalInterface
interface CalculadoraFrete{
    BigDecimal calcular(Pedido pedido);
}