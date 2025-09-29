package exercicio06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor e moeda não podem ser nulos.");
        }

        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN); // arredondamento bancário
        this.moeda = Objects.requireNonNull(moeda);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dinheiro)) return false;
        Dinheiro dinheiro = (Dinheiro) obj;
        return valor.equals(dinheiro.valor) && moeda == dinheiro.moeda;
    }

    @Override
    public String toString() {
        return moeda + " " + valor;
    }

    @Override
    public int hashCode(){
        return Objects.hash(valor, moeda);
    }
}

