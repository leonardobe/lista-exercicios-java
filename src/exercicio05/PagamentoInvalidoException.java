package exercicio05;

public class PagamentoInvalidoException extends Exception {
    public PagamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}