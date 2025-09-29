package exercicio06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Carrinho {
    private final List<ItemCarrinho> itens;

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novosItens = new ArrayList<>(itens);
        novosItens.add(new ItemCarrinho(produto, quantidade));
        return new Carrinho(novosItens);
    }

    public Carrinho removerItem(String nomeProduto) {
        List<ItemCarrinho> novosItens = new ArrayList<>(itens);
        novosItens.removeIf(item -> item.getProduto().getNome().equalsIgnoreCase(nomeProduto));
        return new Carrinho(novosItens);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem.compareTo(BigDecimal.ZERO) < 0 ||
                porcentagem.compareTo(BigDecimal.valueOf(30)) > 0) {
            throw new IllegalArgumentException("O cupom deve estar entre 0% e 30%.");
        }

        BigDecimal fator = BigDecimal.ONE.subtract(
                porcentagem.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN)
        );

        List<ItemCarrinho> novosItens = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            BigDecimal precoComDesconto = item.getProduto().getPreco().getValor().multiply(fator);
            Dinheiro precoDescontado = new Dinheiro(precoComDesconto, item.getProduto().getPreco().getMoeda());
            Produto produtoComDesconto = new Produto(item.getProduto().getNome(), precoDescontado);
            novosItens.add(new ItemCarrinho(produtoComDesconto, item.getQuantidade()));
        }
        return new Carrinho(novosItens);
    }

    public Carrinho removerCupom(Carrinho carrinhoOriginal) {
        return new Carrinho(carrinhoOriginal.getItens());
    }

    public Dinheiro getTotal() {
        BigDecimal soma = BigDecimal.ZERO;
        Moeda moeda = itens.isEmpty() ? Moeda.BRL : itens.get(0).getProduto().getPreco().getMoeda();
        for (ItemCarrinho item : itens) {
            soma = soma.add(item.getTotal().getValor());
        }
        return new Dinheiro(soma, moeda);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ItemCarrinho item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Total: ").append(getTotal().getMoeda()).append(" ").append(getTotal().getValor()).append("\n");
        return sb.toString();
    }
}

