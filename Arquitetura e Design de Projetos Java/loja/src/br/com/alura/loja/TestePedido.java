package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestePedido {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("600"), 4);
        String cliente = "Ana da Silva";
        LocalDateTime data = LocalDateTime.now();

        Pedido pedido = new Pedido(cliente, data, orcamento);

        System.out.println("Gera pedido");
        System.out.println("Salva pedido");
    }
}
