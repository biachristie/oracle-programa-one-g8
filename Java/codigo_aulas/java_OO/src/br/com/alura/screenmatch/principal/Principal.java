package br.com.alura.screenmatch.principal;/*
 PACOTES: usados para agrupar classes que estão relacionadas a alguma funcionalidade.
 CLASSE: estrutura que define um tipo de objeto. É um molde que define quais são as características (atributos) e comportamentos (métodos) que os objetos desse tipo possueírão.
 OBJETO: é uma instância de uma classe. Para criar um objeto em Java, usa-se a palavra reservada *new*.
 - todos os objetos criados a partir da mesma classe terão os mesmos tipos de atributos e métodos.
 MODIFICADORES DE ACESSO (public, private, protected, default): palavras-chave que definem o nível de visibilidade de classes, atributos e métodos, a fim de garantir segurança e encapsulamento do código.
 GETTERS E SETTERS: métodos que permitem controlar a forma como variáveis importantes são acessadas e atualizadas no seu código.
 INTERFACE: "contrato" que as classes devem seguir. Define quais métodos devem ser implementados pelas classes a fim de padronizar, via polimorfismo, os comportamentos das diferentes classes.
*/

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos() + " minutos");
        System.out.println("Média das avaliações: " + meuFilme.pegaMedia() + "\n");

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração da série: " + lost.getDuracaoEmMinutos() + " minutos\n");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println("Tempo total da maratona: " + calculadora.getTempoTotal() + " minutos\n");

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("\nPrimeiro filme da lista: " + listaDeFilmes.get(0).getNome());
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println(listaDeFilmes);
    }
}
