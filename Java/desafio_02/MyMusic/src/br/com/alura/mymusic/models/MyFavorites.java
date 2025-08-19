package br.com.alura.mymusic.models;

public class MyFavorites {
    public static void includes(Audio audio) {
        if (audio.getClassification() > 3) {
            System.out.println(audio.getTitle() + " é considerado sucesso absoluto!");
            return;
        }

        System.out.println(audio.getTitle() + " é uma boa opção.");
    }
}
