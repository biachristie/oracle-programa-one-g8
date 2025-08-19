package br.com.alura.mymusic.main;

import br.com.alura.mymusic.models.Music;
import br.com.alura.mymusic.models.MyFavorites;
import br.com.alura.mymusic.models.Podcast;

public class Main {
    public static void main(String[] args) {
        Music music01 = new Music();
        music01.setTitle("The heart from your hate");
        music01.setSinger("Trivium");
        music01.setLengthMinutes(4);
        music01.playAudio();
        music01.addLikes();
        music01.addLikes();
        music01.addLikes();
//        music01.addStars(5);
        System.out.println("Cantor: " + music01.getSinger());
        System.out.println("Duração da música: " + music01.getLengthMinutes() + " minutos");
        System.out.println("Total de reproduções: " + music01.getTotalReproductions());
        System.out.println("Total de curtidas: " + music01.getTotalLikes());
        System.out.println("Classificação: " + music01.getClassification() + " estrelas \n");

        Podcast podcast01 = new Podcast();
        podcast01.setTitle("Braincast");
        podcast01.setHost("Carlos Merigo");
        podcast01.setDescription("Braincast é um podcast semanal onde informação e descontração se encontram.");
        podcast01.playAudio();
        podcast01.addLikes();
//        podcast01.addStars(5);
        System.out.println("Apresentador: " + podcast01.getHost());
        System.out.println("Descrição: " + podcast01.getDescription());
        System.out.println("Total de reproduções: " + podcast01.getTotalReproductions());
        System.out.println("Total de curtidas: " + podcast01.getTotalLikes());
        System.out.println("Classificação: " + podcast01.getClassification() + " estrelas \n");

        MyFavorites.includes(music01);
        MyFavorites.includes(podcast01);
    }
}
