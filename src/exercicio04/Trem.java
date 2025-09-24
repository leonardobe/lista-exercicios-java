package exercicio04;

public class Trem implements IMeioTransporte {
    private int velocidade;
    private final int VELOCIDADE_MAXIMA = 300;

    @Override
    public void acelerar() {
        if (velocidade + 50 <= VELOCIDADE_MAXIMA) {
            velocidade += 50;
        } else {
            velocidade = VELOCIDADE_MAXIMA;
        }
        System.out.println("Trem acelerou. Velocidade atual: " + velocidade + " km/h");
    }

    @Override
    public void frear() {
        if (velocidade - 30 >= 0) {
            velocidade -= 30;
        } else {
            velocidade = 0;
        }
        System.out.println("Trem freou. Velocidade atual: " + velocidade + " km/h");
    }
}

