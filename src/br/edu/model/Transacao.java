package br.edu.model;
import java.time.LocalDateTime;

public class Transacao {
    private String tipo;  // 'deposito' ou 'saque'
    private double valor;
    private LocalDateTime data;

    // Construtor
    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    // Método para obter uma representação textual da transação
    @Override
    public String toString() {
        String tipoTransacao = this.tipo.equals("deposito") ? "Depósito" : "Saque";
        return tipoTransacao + " de " + this.valor + " em " + this.data;
    }

    // Exemplo de método adicional para aplicação bancária
    // Método para obter o valor da transação
    public double getValor() {
        return this.valor;
    }

    // Método para obter o tipo da transação
    public String getTipo() {
        return this.tipo;
    }

    // Método para obter a data da transação
    public LocalDateTime getData() {
        return this.data;
    }
}
