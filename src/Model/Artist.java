package Model;

import java.util.ArrayList;

public class Artist {
    private final String name;
    private ArrayList<Album> albums = new ArrayList<>();
    private Album unknown = new Album("Unknown", this);

    private static final long serialVersionUID = 1398444L;

    public Artist(String name) {
        this.name = name;

    }

    public void addAlbum(Album album) {
        if ( name.equals(album.getArtist().getName()) ) {
            albums.add(album);
        }
    }

    public void addMusic(Music music) {
        if ( albums.contains(music.getAlbum()) ) {
            for (Album a: albums) {
                if ( a.equals(music.getAlbum()) ){
                    a.addMusic(music);
                }
            }
        } else {
            unknown.addMusic(music);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public Album getUnknown() {
        return unknown;
    }

    private ArrayList<Music> getMusic() {
        ArrayList<Music> music = new ArrayList<>();
        for (Album a :
                albums) {
            music.addAll(a.getMusics());
        }
        return music;
    }
}