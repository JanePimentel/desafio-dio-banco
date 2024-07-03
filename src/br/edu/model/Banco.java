package br.edu.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(int conta) {
        Conta contaRemover = null;
        if (!contas.isEmpty()) {
            for (Conta c : contas) {
                if (c.conta == conta) {
                    contaRemover = c;
                    break;
                }
            }
            contas.remove(contaRemover);

        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
        if (contaRemover == null) {
            System.out.println("Conta não encontrada");
        } else {
            System.out.println("Conta removida com sucesso!");
        }
    }

    public List<Conta> getListaContasCorrentes() {
        if (!contas.isEmpty()) {
            List<Conta> contasCorrentes = new ArrayList<>();
            for (Conta conta : contas) {
                if (conta instanceof ContaCorrente) {
                    contasCorrentes.add(conta);
                }
            }
            return contasCorrentes;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public List<Conta> getListaContasPoupancas() {
        if (!contas.isEmpty()) {
            List<Conta> contasPoupancas = new ArrayList<>();
            for (Conta conta : contas) {
                if (conta instanceof ContaPoupanca) {
                    contasPoupancas.add(conta);
                }
            }
            return contasPoupancas;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public void imprimeListaContas() {
        if (!contas.isEmpty()) {
            for (Conta conta : contas) {
                if (conta instanceof ContaPoupanca) {
                    System.out.println(" === Conta Poupança === ");
                } else {
                    System.out.println(" === Conta Corrente === ");
                }
                conta.imprimirInfosComuns();
            }
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public void getContasPorCliente(Cliente cliente) {
        for (Conta conta : contas) {
            if (conta.cliente.equals(cliente)) {
                System.out.println(conta);
            }
        }
    }

    public void listaClientes() {
        Set<String> contasSetOrdenadoPorNome = new TreeSet<>();
        if (!contas.isEmpty()) {
            for (Conta conta : contas) {
                contasSetOrdenadoPorNome.add(conta.cliente.getNome());
            }
            System.out.println(contasSetOrdenadoPorNome);
        } else {
            throw new RuntimeException("Lista está vazia!");
        }
    }

    public void listaContasPorSaldo() {
        Set<Conta> contasSetOrdenadoPorSaldo = new TreeSet<>(new OrdenaPorSaldo());
        if (!contas.isEmpty()) {
            for (Conta conta : contas) {
                contasSetOrdenadoPorSaldo.add(conta);
            }
            System.out.println(contasSetOrdenadoPorSaldo);
        } else {
            throw new RuntimeException("Lista está vazia!");
        }
    }

    public void listaContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    } 

}
