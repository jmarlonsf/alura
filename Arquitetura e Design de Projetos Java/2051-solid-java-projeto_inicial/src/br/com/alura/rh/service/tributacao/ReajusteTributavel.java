package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ReajusteTributavel extends Reajuste{

    BigDecimal valorImpostoDeRenda();
}
