package designpatterns.iterator;

public class Song {
    String name;
    String artist;
    double duration;
    ESongLanguage language;
    public Song(String name, String artist, double duration, ESongLanguage language) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.language = language;
    }
    
    public String getName() {
        return name;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public double getDuration() {
        return duration;
    }
    
    public ESongLanguage getLanguage() {
        return language;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Song{");
        sb.append("name='").append(name).append('\'');
        sb.append(", artist='").append(artist).append('\'');
        sb.append(", duration=").append(duration);
        sb.append(", language=").append(language);
        sb.append('}');
        return sb.toString();
    }
}