package Model;

import java.util.ArrayList;

public class MusicPlayer {

    private ArrayList<Music> musics = new ArrayList<>();

    private final Object lock = new Object();

    public void addMusic(Media media) {
        synchronized (lock) {
            if ( media instanceof Music ) { // if media is Music, ...

                if ( !musics.contains(media) ) { // if there is not any music like media, ...
                    musics.add((Music) media);
                }
            }
        }
    }

    public Object getLock() {
        return lock;
    }

    public void addMusic(ArrayList<Music> medium) {
        synchronized (lock) {
            for (Media m : // for all medium
                    medium) {
                this.addMusic(m);
            }
        }

    }

    public void removeAllMusics() {
        musics.removeAll(musics.subList(0, musics.size()));
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }
}
