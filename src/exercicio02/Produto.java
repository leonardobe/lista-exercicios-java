/* Estenda Produto com o método aplicarDesconto(double porcentagem). Permita apenas valores entre 0 e 50 (inclusive) e lance exceção (IllegalArgumentException ou DescontoInvalidoException) se a regra for violada. Mostre, em um main ou testes, o preço antes/depois do desconto e a reação a entradas inválidas.
*/
package exercicio02;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEstoque);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
        this.quantidadeEstoque = quantidadeEmEstoque;
    }

    public void exibirInfo() {
        System.out.println("Produto: " + nome +
                " | Preço: R$ " + preco +
                " | Estoque: " + quantidadeEstoque);
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("O desconto deve estar entre 0% e 50%.");
        }
        double desconto = preco * (porcentagem / 100);
        preco -= desconto;
    }
}

