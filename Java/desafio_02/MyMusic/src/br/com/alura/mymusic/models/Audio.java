package br.com.alura.mymusic.models;

public class Audio {
    private String title;
    private double lengthMinutes;
    private int totalReproductions;
    private int likes;
    private int classification;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(double lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public int getTotalReproductions() {
        return totalReproductions;
    }

    public int getTotalLikes() {
        return likes;
    }

    public int getClassification() {
        return classification;
    }

    public void addLikes() {
        likes++;
    }

//    public void addStars(int stars) {
//        this.classification = stars;
//    }

    public void playAudio() {
        totalReproductions++;
        System.out.printf("Reproduzindo %s...\n", title);
    }
}
