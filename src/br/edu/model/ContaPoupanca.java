package br.edu.model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        //TODO Auto-generated constructor stub
    }

    public void imprimirExtrato() {
        System.out.println(" === Extrato Conta Poupanca");
        super.imprimirInfosComuns();
    }

     @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }
}
