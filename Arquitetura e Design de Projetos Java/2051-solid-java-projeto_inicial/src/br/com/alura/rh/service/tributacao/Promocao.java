package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel {

    private BigDecimal valor;
    private LocalDate date;

    public Promocao(BigDecimal valor) {
        this.valor = valor;
        this.date = LocalDate.now();
    }

    @Override
    public BigDecimal valor() {
        return this.valor;
    }

    @Override
    public LocalDate date() {
        return this.date;
    }

    @Override
    public BigDecimal valorImpostoDeRenda() {
        return this.valor.multiply(new BigDecimal("0.1"));
    }
}
