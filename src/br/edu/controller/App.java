package br.edu.controller;
import br.edu.model.Banco;
import br.edu.model.Cliente;
import br.edu.model.Conta;
import br.edu.model.*;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente c1 = new Cliente("Juma Lopes");
        Cliente c2 = new Cliente("Osmar Brad");
        Cliente c3 = new Cliente("Lucas Brito Lopes");
        Cliente c4 = new Cliente("Aline Carvalho");
        Cliente c5 = new Cliente("Ricardo Almeida");
        Cliente c6 = new Cliente("Larissa Barbosa");
        Banco banco = new Banco();
        Conta cc1 = new ContaCorrente(c1);
        Conta cc2 = new ContaCorrente(c2);
        Conta cc3 = new ContaCorrente(c3);
        banco.adicionarConta(cc1);
        banco.adicionarConta(cc2);
        banco.adicionarConta(cc3);
        cc1.depositar(1250.00);
        cc1.sacar(50.00);
        cc1.transferir(325.00, cc3);
       System.out.println("Lista de contas correntes.: " + banco.getListaContasCorrentes());

       Conta cc4 = new ContaPoupanca(c4);
       Conta cc5 = new ContaPoupanca(c5);
       Conta cc6 = new ContaPoupanca(c6);
       banco.adicionarConta(cc4);
       banco.adicionarConta(cc5);
       banco.adicionarConta(cc6);
       cc4.depositar(500.00);
       cc5.depositar(1500.00);
       cc4.transferir(250.00, cc6);
      System.out.println("Lista de contas poupancas.: " + banco.getListaContasPoupancas());
      banco.imprimeListaContas();
      banco.getContasPorCliente(c6);
      banco.listaClientes();
      banco.listaContasPorSaldo();
      banco.listaContas();
      banco.removerConta(cc6.getConta());
      banco.listaContas();

    }
}
