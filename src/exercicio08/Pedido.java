package exercicio08;

import java.math.BigDecimal;

class Pedido {
    private final BigDecimal valorTotal;
    private final String cep;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(BigDecimal valorTotal, String cep, CalculadoraFrete estrategiaFrete) {
        if (!cep.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP inválido! Deve conter 8 dígitos numéricos.");
        }
        if (valorTotal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do pedido não pode ser negativo!");
        }
        this.valorTotal = valorTotal;
        this.cep = cep;
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getCep() {
        return cep;
    }

    public void setEstrategiaFrete(CalculadoraFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        return estrategiaFrete.calcular(this);
    }

    @Override
    public String toString() {
        return "Pedido: {valor=" + valorTotal + ", cep='" + cep + "'}";
    }
}