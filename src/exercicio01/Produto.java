/*Implemente a classe Produto com atributos privados nome, preco e quantidadeEmEstoque. Forneça getters e setters com validações: preço e quantidadeEmEstoque não podem ser negativos e nome não pode ser nulo ou vazio. Lance IllegalArgumentException em casos inválidos. Demonstre o uso criando instâncias, alterando valores válidos e tentando atribuições inválidas.*/

package exercicio01;

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

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirInfo() {
        System.out.println("Produto: " + nome +
                " | Preço: R$ " + preco +
                " | Estoque: " + quantidadeEstoque);
    }
}
