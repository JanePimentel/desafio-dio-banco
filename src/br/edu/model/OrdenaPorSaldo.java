package br.edu.model;

import java.util.Comparator;

public class OrdenaPorSaldo implements Comparator<Conta>{
    @Override
    public int compare(Conta c1, Conta c2) {
        return Double.compare(c1.getSaldo(), c2.getSaldo());
    }
}
