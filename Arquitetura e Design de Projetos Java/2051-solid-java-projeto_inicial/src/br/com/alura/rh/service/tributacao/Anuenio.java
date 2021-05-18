package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste {

    private BigDecimal valor;
    private LocalDate date;

    public Anuenio(BigDecimal valor) {
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
}
