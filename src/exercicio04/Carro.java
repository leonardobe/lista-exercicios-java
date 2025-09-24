package exercicio04;

public class Carro implements IMeioTransporte {
    private int velocidade;
    private final int VELOCIDADE_MAXIMA = 200;

    @Override
    public void acelerar() {
        if (velocidade + 20 <= VELOCIDADE_MAXIMA) {
            velocidade += 20;
        } else {
            velocidade = VELOCIDADE_MAXIMA;
        }
        System.out.println("Carro acelerou. Velocidade atual: " + velocidade + " km/h");
    }

    @Override
    public void frear() {
        if (velocidade - 20 >= 0) {
            velocidade -= 20;
        } else {
            velocidade = 0;
        }
        System.out.println("Carro freou. Velocidade atual: " + velocidade + " km/h");
    }
}
