package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Imposto {

    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal vlImposto = realizarCalculo(orcamento);
        BigDecimal vlOutroImposto = BigDecimal.ZERO;

        if (Objects.nonNull(outro)) {
            vlOutroImposto = outro.realizarCalculo(orcamento);
        }

        return vlImposto.add(vlOutroImposto);

    }


}
