package br.edu.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo = 0.0;
    protected Cliente cliente;
    protected List<Transacao> transacoes;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque.");
        } else {
            saldo -= valor;
            addTransacao("Retirada", valor);
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        addTransacao("Depósito", valor);
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            addTransacao("Transferência", valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para a transferência.");
        }
    }

    public void addTransacao(String tipo, double valor) {
        transacoes.add(new Transacao(tipo, valor));
    }

    public void imprimirTransacoes() {
        System.out.println("Transações da conta:" + this.conta + "-" + this.agencia);
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    public abstract String getTipoConta();

    protected void imprimirInfosComuns() {
       // System.out.println(" === " + getTipoConta() + " === ");
        System.out.println(String.format(("Titular: %s"), this.cliente.getNome()));
        System.out.println(String.format(("Agencia: %d"), this.agencia));
        System.out.println(String.format(("Conta: %d"), this.conta));
        System.out.println(String.format(("Saldo: %.2f"), this.saldo));
    }

    @Override
    public String toString() {
        return String.format("Titular: %s\nAgencia: %d\nConta: %d\nSaldo: %.2f\n",
                             this.cliente.getNome(), this.agencia, this.conta, this.saldo);
    }
}
