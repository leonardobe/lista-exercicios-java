package exercicio04;

public class Bicicleta implements IMeioTransporte {
    private int velocidade;
    private final int VELOCIDADE_MAXIMA = 40;

    @Override
    public void acelerar() {
        if (velocidade + 5 <= VELOCIDADE_MAXIMA) {
            velocidade += 5;
        } else {
            velocidade = VELOCIDADE_MAXIMA;
        }
        System.out.println("Bicicleta acelerou. Velocidade atual: " + velocidade + " km/h");
    }

    @Override
    public void frear() {
        if (velocidade - 5 >= 0) {
            velocidade -= 5;
        } else {
            velocidade = 0;
        }
        System.out.println("Bicicleta freou. Velocidade atual: " + velocidade + " km/h");
    }
}

