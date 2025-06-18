package designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Playlist {
    List<Song> songs;
    
    public Playlist() {
        songs = new ArrayList<>();
    }
    
    public List<Song> getSongs() {
        return songs;
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }
    
    public SongIterator iterator(){
        return new ForwardBackwardIterator(this.songs);
    }
    
    public SongIterator filteredIterator(Predicate<Song> predicate){
        return new FilteredIterator(this.songs,predicate);
    }
    
    private static class ForwardBackwardIterator implements SongIterator{
        
        private final List<Song> songList;
        private int currentIndex;
        
        public ForwardBackwardIterator(List<Song> songs) {
            this.songList =songs;
            currentIndex = 0;
        }
        @Override
        public boolean hasNext() {
            if(currentIndex < songList.size()) {
                return true;
            }
            return false;
        }
        
        @Override
        public Song next() {
            Song nextSong = songList.get(currentIndex);
            currentIndex++;
            return nextSong;
        }
        
        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }
        
        @Override
        public Song previous() {
            currentIndex--;
            Song previousSong = songList.get(currentIndex);
            return previousSong;
        }
        
    }
    
    private static class FilteredIterator implements SongIterator{
        
        private final List<Song> songList;
        private int currentIndex;
        private Predicate<Song> filter;
        
        public FilteredIterator(List<Song> songList, Predicate<Song> filter) {
            this.songList = songList;
            this.currentIndex = 0;
            this.filter = filter;
        }
        
        @Override
        public boolean hasNext() {
            int tempIndex = currentIndex;
            while(tempIndex < songList.size()) {
                if(filter.test(songList.get(tempIndex))) {
                    currentIndex = tempIndex;
                    return true;
                }
                tempIndex++;
            }
            return false;
        }
        
        @Override
        public Song next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element matches the filter");
            }
            Song nextSong = songList.get(currentIndex);
            currentIndex++;
            return nextSong;
        }
        
        @Override
        public boolean hasPrevious() {
            int tempIndex = currentIndex;
            if(tempIndex == songList.size()) {
                tempIndex--;
            }
            while(tempIndex >= 0) {
                if(filter.test(songList.get(tempIndex))) {
                    currentIndex = tempIndex;
                    return true;
                }else{
                    tempIndex--;
                }
            }
            return false;
        }
        
        @Override
        public Song previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("No next element matches the filter");
            }
            Song previousSong = songList.get(currentIndex);
            currentIndex--;
            return previousSong;
        }
    }
    
    public static Playlist populatePlayList(){
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Pal Pal","Mongo Mochi",2.35,ESongLanguage.URDU));
        playlist.addSong(new Song("Pappu Can't Dance Sala","Irfan Khan",4.75,ESongLanguage.HINDI));
        playlist.addSong(new Song("Kitnay Armaan","Himesh Rayshimya",3.3,ESongLanguage.HINDI));
        playlist.addSong(new Song("Work Work Work","Ariane Grande",3.05,ESongLanguage.ENGLISH));
        playlist.addSong(new Song("Nach Panjaban","Abrar ul Haq",2.35,ESongLanguage.PUNJABI));
        playlist.addSong(new Song("Ashiq Banaya","Himesh Rayshimya",4.35,ESongLanguage.HINDI));
        playlist.addSong(new Song("Radha","Hamida Bano",3.35,ESongLanguage.HINDI));
        return playlist;
    }
    
    public static void main(String[] args) {
        Playlist playlist = Playlist.populatePlayList();
        SongIterator iterator = playlist.iterator();
        while(iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println(song);
        }
        System.out.println("---------");
        System.out.println("Playing backwards now");
        
        while(iterator.hasPrevious()) {
            Song song = iterator.previous();
            System.out.println(song);
        }
        
        System.out.println("---------");
        System.out.println("Testing FilteredIterator now");
        
        SongIterator filteredIterator = playlist.filteredIterator(song->song.getLanguage().equals(ESongLanguage.HINDI));
        while(filteredIterator.hasNext()) {
            Song song = filteredIterator.next();
            System.out.println(song);
        }
        System.out.println("---------");
        System.out.println("Playing backwards now");
        
        while(filteredIterator.hasPrevious()) {
            Song song = filteredIterator.previous();
            System.out.println(song);
        }
        
    }
}