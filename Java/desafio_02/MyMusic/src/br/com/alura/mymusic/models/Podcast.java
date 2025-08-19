package br.com.alura.mymusic.models;

public class Podcast extends Audio {
    private String host;
    private String description;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getClassification() {
        if (this.getTotalLikes() >= 5) {
            return 5;
        }
        return 3;
    }
}
