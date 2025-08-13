package br.com.alura.conversor.service;

import br.com.alura.conversor.model.Conversor;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class ConversaoDados {

    private final ConsumoApi consumoApi;

    public ConversaoDados(ConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }

    public Conversor JsonParaObjeto(String json) {
         return new Gson().fromJson(json, Conversor.class);
    }

    public String realizarConversao(String codigoBase, String codigoAlvo, double valor) {
        String json = consumoApi.obterDados(codigoBase, codigoAlvo, valor);
        Conversor resposta = JsonParaObjeto(json);

        return resposta.formatarResultado(valor);
    }

}
