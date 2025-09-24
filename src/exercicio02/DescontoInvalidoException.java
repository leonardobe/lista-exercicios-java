package exercicio02;

public class DescontoInvalidoException extends RuntimeException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
