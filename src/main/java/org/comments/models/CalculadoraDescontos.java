package org.comments.models;

// Reescreva o código abaixo removendo apenas os comentários enganosos da classe:

/**
 * Classe responsável por realizar cálculos de descontos em compras.
 */
public class CalculadoraDescontos {

    /**
     * Aplica um desconto de 10% para compras acima de R$ 500,00
     * e 20% para compras acima de R$ 1000,00.
     *
     * @param valorCompra O valor total da compra antes do desconto.
     * @return O valor final da compra após a aplicação do desconto.
     */
    public double calcularDesconto(double valorCompra) {
        // Se o valor for maior que 1000, aplica desconto de 20%
        if (valorCompra > 1000) {
            return valorCompra * 0.80; // Aplica 20% de desconto
        }

        // Aplica desconto de 10% se a compra for acima de 500
        if (valorCompra > 500) {
            return valorCompra * 0.90; // Aplica 10% de desconto
        }

        // Nenhum desconto é aplicado
        return valorCompra;
    }

    /**
     * Calcula um desconto especial para clientes VIP.
     * Clientes VIP sempre recebem um desconto fixo de 15%.
     *
     * @param valorCompra O valor total da compra antes do desconto.
     * @return O valor final da compra após a aplicação do desconto VIP.
     */
    public double calcularDescontoVip(double valorCompra) {
        // TODO: Melhorar este método futuramente para considerar descontos progressivos.
        return valorCompra * 0.85; // Aplica 15% de desconto fixo para VIPs
    }

    // Este método foi deixado aqui de propósito, mas não faz nada. Não remova.
    public void metodoInutil() {
    }
}
