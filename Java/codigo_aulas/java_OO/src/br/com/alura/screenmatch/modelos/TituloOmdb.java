//  Record é um recurso que permite representar uma classe imutável, contendo apenas atributos, construtor e métodos de leitura, de uma maneira muito simples e enxuta.

package br.com.alura.screenmatch.modelos;

public record TituloOmdb(String title, String year, String runtime) {
}
