package br.com.alura.loja.orcamento;

import br.com.alura.loja.exception.DomainException;
import br.com.alura.loja.http.HttpAdapter;
import br.com.alura.loja.http.JavaHttpClient;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {

        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orçamento não finalizado");
        }

        String url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidade", orcamento.getQuantidadeItens()
        );

        http.post(url, dados);
        //chamda HTTP para a API externa
        // URL connection
        //HTTP Client
        //lib Rest
    }
}
