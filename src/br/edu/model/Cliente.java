package br.edu.model;

public class Cliente implements Comparable<Cliente> {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Cliente o) {
        return nome.compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return "\nCliente{" +
                "nome ='" + nome + '\'' +
                '}';
    }
}
