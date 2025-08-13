package br.com.alura.literalura.model;

import java.util.List;

public class RespostaApi {

    private int count;
    private String next;
    private String previous;
    private List<Livro> results;

    public List<Livro> getResultados() {
        return results;
    }

}