package designpatterns.iterator;

public interface SongIterator {
    public boolean hasNext();
    public Song next();
    boolean hasPrevious();
    Song previous();
    
}