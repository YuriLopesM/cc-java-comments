package org.comments.models;
import java.util.List;

// Reescreva o código abaixo substituindo comentários que poderiam ser substituídos por outros métodos:

public class Pedido {
    private List<Item> itens;
    private double desconto;
    private double taxaImposto;

    public Pedido(List<Item> itens, double desconto, double taxaImposto) {
        this.itens = itens;
        this.desconto = desconto;
        this.taxaImposto = taxaImposto;
    }

    public double calcularTotalPedido() {
        double total = calcularTotalItens();
        total = aplicarDesconto(total);
        total = calcularImposto(total);
        return total;
    }

    private double calcularTotalItens() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    private double aplicarDesconto(double total) {
        double valorDesconto = total * (desconto / 100);
        return total - valorDesconto;
    }

    private double calcularImposto(double total) {
        double imposto = total * (taxaImposto / 100);
        return total + imposto;
    }

    public String gerarRecibo() {
        StringBuilder recibo = new StringBuilder();
        recibo.append("===== RECIBO =====\n");

        for (Item item : itens) {
            recibo.append(item.getNome()).append(" - ")
                    .append(item.getQuantidade()).append(" x ")
                    .append(String.format("%.2f", item.getPreco())).append("\n");
        }

        recibo.append("Total: R$ ").append(String.format("%.2f", calcularTotalPedido())).append("\n");
        return recibo.toString();
    }
}

// Classe auxiliar Item
class Item {
    private String nome;
    private double preco;
    private int quantidade;

    public Item(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
}

