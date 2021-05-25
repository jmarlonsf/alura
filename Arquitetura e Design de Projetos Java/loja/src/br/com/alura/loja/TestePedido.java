package br.com.alura.loja;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestePedido {

    public static void main(String[] args) {
        String cliente = "João Marlon"; //args[0];
        BigDecimal valorOrcamento = new BigDecimal(300);
        int quantidadeItens = 2;//Integer.parseInt(args[2]);

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(
                        new EnviarEmailPedido(),
                        new SalvarPedidoNoBancoDeDados(),
                        new LogDePedido())
        );
        handler.execute(gerador);
    }
}
